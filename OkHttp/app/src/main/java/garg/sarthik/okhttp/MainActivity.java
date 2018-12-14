package garg.sarthik.okhttp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvUserList;
    EditText etUser;
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etInput);
        Button btn = findViewById(R.id.btnGo);
        rvUserList = findViewById(R.id.rvList);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etUser.getText().toString().contains(" ")) {
                    input = "https://api.github.com/search/users?q=" + etUser.getText().toString().replace(" ", "%20");
                    Log.e("TAG", "onCreate: IF" + input);
                } else {
                    input = "https://api.github.com/search/users?q=" + etUser.getText().toString();
                    Log.e("TAG", "onCreate: ELSE" + input);
                }

                makeNetworkCall(input);
            }
        });
    }

    void addIntent(Items items) {
        Intent i = new Intent(getBaseContext(), SecondActivity.class);
        i.putExtra("url", items.getUrl());
        startActivity(i);
    }

    private void makeNetworkCall(String s) {

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(s)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();
                final Gson gson = new Gson();

                github_users gu = gson.fromJson(result,github_users.class);

                final ArrayList<Items> items = gu.getItems();

                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvUserList.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        ListAdapter listAdapter = new ListAdapter(items,MainActivity.this);
                        rvUserList.setAdapter(listAdapter);
                    }
                });


            }
        });
    }

}