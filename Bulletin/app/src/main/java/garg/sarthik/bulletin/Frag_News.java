package garg.sarthik.bulletin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Frag_News extends Fragment {

    String TAG = "BULLETIN_FRAG";
    News news;
    Typeface typeface;
    View view;

    Fragment newInstance(String url, int typeOfNews) {

        Frag_News frag_news = new Frag_News();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putInt("type", typeOfNews);
        frag_news.setArguments(bundle);
        return frag_news;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: FRAG_NEWS");


        boolean connected;
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;

        if (!connected) {
            Toast.makeText(getContext(), "PLEASE CONNECT TO INTERNET", Toast.LENGTH_SHORT).show();
            view = inflater.inflate(R.layout.layout_offline, container, false);
            Intent intent = new Intent(getActivity(), BookmarkActivity.class);
            startActivity(intent);
        }
        else
        {
            view = inflater.inflate(R.layout.recycler_view, container, false);
        }

        if (getArguments() != null) {

            fetchNews(getArguments(), view);
            Log.e(TAG, "onCreateView: getArguments()");
        }

        return view;

    }

    private void fetchNews(Bundle bundle, final View view) {

        String s = bundle.getString("url");
        final int typeOfNews = bundle.getInt("type");
        Log.e(TAG, "fetchNews: " + s);
        final OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(s)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                Gson gson = new Gson();
                news = gson.fromJson(result, News.class);
                Log.e(TAG, "onResponse: " + news.getArticles().get(0).getPublishedAt());

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        RecyclerView recyclerView = view.findViewById(R.id.rvNews);
                        TextView tvPublisher = view.findViewById(R.id.tvPublisher);
                        switch (typeOfNews) {
                            case News_Constants.NEWS_INDIA:
                                tvPublisher.setBackgroundColor(getResources().getColor(R.color.color_news));
                                typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Merriweather-Regular.ttf");
                                break;
                            case News_Constants.NEWS_ENT:
                                typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Merienda-Regular.ttf");
                                tvPublisher.setBackgroundColor(getResources().getColor(R.color.color_ent));
                                break;
                            case News_Constants.NEWS_SPORTS:
                                typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/BreeSerif-Regular.ttf");
                                tvPublisher.setBackgroundColor(getResources().getColor(R.color.color_sports));
                                break;
                            case News_Constants.NEWS_TECH:
                                typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Ubuntu-Regular.ttf");
                                tvPublisher.setBackgroundColor(getResources().getColor(R.color.color_tech));
                                break;
                        }
                        tvPublisher.setTypeface(typeface);
                        String[] publisher = news.getArticles().get(0).source.getName().split("\\(");
                        tvPublisher.setText(publisher[0]);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(new Adapter(news.getArticles(), getContext(), typeOfNews));
                    }
                });

            }
        });
    }
}
