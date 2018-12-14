package garg.sarthik.webbrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText etURL;
    WebView webview;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast t = Toast.makeText(MainActivity.this,"Access Internet", Toast.LENGTH_SHORT);
        t.setGravity(15,0,0);
        t.show();

        etURL = findViewById(R.id.etURLtxt);
        btn = findViewById(R.id.btnGO);
        webview = findViewById(R.id.wvPage);

        Intent i = getIntent();

        if(i.getData() != null) {

            URL = i.getData().toString();

            loadWebPage(URL);
        }
        else
            loadWebPage("https://www.google.in");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                URL = etURL.getText().toString();

                if(URL.length() != 0)
                   loadWebPage(URL);
                else
                    loadWebPage("https://www.google.in");

            }
        });
    }
    public void loadWebPage(String URL)
    {
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);


        if(URL.contains("https://") || URL.contains("https://www.") || URL.contains("http://") || URL.contains("http://www."))
            webview.loadUrl(URL);
        else
        {
            if(URL.contains(".com") || URL.contains(".net") || URL.contains(".org") || URL.contains(".gov") || URL.contains(".in"))
                URL = "https://" + URL;
            else
                URL = "https://www.google.com/search?q=" + URL;
        }
        etURL.setText(URL);
        webview.loadUrl(URL);
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack())
            webview.goBack();
        else
            super.onBackPressed();
    }
}
