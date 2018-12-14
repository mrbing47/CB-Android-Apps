package garg.sarthik.loginpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(final Context context, Intent intent) {

        //prevents the system from killing this receiver
        //but don't do any long running task in the receiver instead do it in service
        final PendingResult pendingResult = goAsync();

        Bundle bundle = intent.getExtras();
        User user = bundle.getParcelable("user");

        Gson gson = new Gson();
        String result = gson.toJson(user);

        String postURL = "http://ptsv2.com/t/xzrak-1530787550/post";
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),result);

        Request request = new Request.Builder()
                .url(postURL)
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

//              Kills the thread
                pendingResult.finish();
            }
        });
    }


}
