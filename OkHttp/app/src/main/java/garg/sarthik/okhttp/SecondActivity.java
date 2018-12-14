package garg.sarthik.okhttp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvLogin;
    TextView tvBio;
    TextView tvLocation;
    TextView tvCompany;
    TextView tvBlog;
    ImageView ivUser;
    RecyclerView rvUserList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        tvName = findViewById(R.id.tvUserName);
        tvLogin = findViewById(R.id.tvUserLogin);
        tvBio = findViewById(R.id.tvUserBio);
        tvBio.setMovementMethod(new ScrollingMovementMethod());
        tvCompany = findViewById(R.id.tvUserCompany);
        tvBlog = findViewById(R.id.tvUserBlog);
        tvLocation = findViewById(R.id.tvUserLocation);
        ivUser = findViewById(R.id.ivUserImage);
        rvUserList = findViewById(R.id.rvUserList);
        Bundle bundle = getIntent().getExtras();
        String userURL = bundle.getString("url");

        makeNetworkCallForUser(userURL);


    }

    private void makeNetworkCallForUser(String userURL) {

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request =  new Request.Builder()
                .url(userURL)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                Gson gson = new Gson();

                final user_detail userDetail = gson.fromJson(result,user_detail.class);
                makeNetworkCallForRepo(userDetail.getRepos_url());

                (SecondActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvName.setText(userDetail.getName());
                        tvLogin.setText(userDetail.getLogin());
                        tvBio.setText(userDetail.getBio());
                        tvCompany.setText(userDetail.getCompany());
                        tvLocation.setText(userDetail.getLocation());
                        tvBlog.setText(userDetail.getBlog());

                        Picasso.get()
                                .load(userDetail.getAvatar_url())
                                .placeholder(R.drawable.ic_report)
                                .resize(250, 250)
                                .error(R.drawable.ic_wallpaper)
                                .into(ivUser);
                    }
                });
            }
        });
    }

    private void makeNetworkCallForRepo(String repos_url) {

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(repos_url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();

                Gson gson = new Gson();


                final ReposDetail[] reposDetail = gson.fromJson(result, ReposDetail[].class);


                (SecondActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvUserList.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        UserAdapter userAdapter = new UserAdapter(SecondActivity.this,reposDetail);
                        rvUserList.setAdapter(userAdapter);
                    }
                });
            }
        });
    }


}
