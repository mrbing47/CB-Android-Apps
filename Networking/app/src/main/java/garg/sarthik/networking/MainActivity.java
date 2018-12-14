package garg.sarthik.networking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnGO);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyNetworkTask myTask = new MyNetworkTask();
                EditText etURL = findViewById(R.id.etURL);
                myTask.execute(etURL.getText().toString());
            }
        });
    }

    private class MyNetworkTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {

            String URL = strings[0];

            String str = makeNetworkcall(URL);

            return str;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView tvPage = findViewById(R.id.tvPage);
            tvPage.setText(s);

        }
    }

    private String makeNetworkcall(String currenturl) {

        try{

            URL url = new URL(currenturl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);

            String s = "";
            scanner.useDelimiter("\\A");

            if(scanner.hasNext())
            {
                s = scanner.next();
            }

            return s;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Something Went Wrong";
    }
}
