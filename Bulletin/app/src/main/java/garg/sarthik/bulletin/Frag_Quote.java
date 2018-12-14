package garg.sarthik.bulletin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Frag_Quote extends Fragment {

    TextView tvAuthor;
    TextView tvQuote;
    Quotes quotes;
    List<Quotes> quotesList = new ArrayList<>();

    Frag_Quote newInstance(String url) {
        Frag_Quote frag_quote = new Frag_Quote();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        frag_quote.setArguments(bundle);
        return frag_quote;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_quote, container, false);
        if (getArguments() != null) {
            String url = getArguments().getString("url");
            fetchQOD(url, view);
        }
        return view;
    }

    private void fetchQOD(String s, final View view) {

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(s)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

//                quotes = NewsApplication.getDB().getNewsDao().getAllQuotes().get(0);
//                tvAuthor = view.findViewById(R.id.tvAuthor);
//                tvQuote = view.findViewById(R.id.tvQuote);
//                tvQuote.setText(quotes.getQuote());
//                tvAuthor.setText(quotes.getAuthor());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();
                final QuoteOfTheDay qod;


                Log.e("TAG", "onResponse: " + result);
                qod = new Gson().fromJson(result, QuoteOfTheDay.class);

//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        if (!(result.contains("error"))) {
//                            Log.e("TAG", "run: TRUE");
//                            quotesList = qod.getContents().getQuotes();
//                            quotesList.get(0);
//                            NewsApplication.getDB().getNewsDao().deleteQuote();
//                            NewsApplication.getDB().getNewsDao().insertQuote(quotes);
//                            tvAuthor = view.findViewById(R.id.tvAuthor);
//                            tvQuote = view.findViewById(R.id.tvQuote);
//                            tvQuote.setText(quotes.getQuote());
//                            tvAuthor.setText(quotes.getAuthor());
//                        } else {
//
//                            Log.e("TAG", "run: FALSE");
//                            quotes = NewsApplication.getDB().getNewsDao().getAllQuotes().get(0);
//                            tvAuthor = view.findViewById(R.id.tvAuthor);
//                            tvQuote = view.findViewById(R.id.tvQuote);
//                            tvQuote.setText(quotes.getQuote());
//                            tvAuthor.setText(quotes.getAuthor());
//                        }
//
//                    }
//                });

            }
        });
    }
}
