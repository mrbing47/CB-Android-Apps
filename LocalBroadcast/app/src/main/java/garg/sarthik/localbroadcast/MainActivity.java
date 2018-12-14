package garg.sarthik.localbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver = new MyReceiver();

    public static final  String packageName = "garg.sarthik.localbroadcast";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(packageName);

        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver,intentFilter);

        Button btn = findViewById(R.id.idLocalBroadcast);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(packageName);
                LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(i);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
    }
}
