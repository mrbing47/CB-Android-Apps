package garg.sarthik.custombroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExplicit = findViewById(R.id.btnExplicit);
        Button btnImplicit  = findViewById(R.id.btnImplicit);


        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),MyExplicitReceiver.class);
                sendBroadcast(intent);
            }
        });

        MyImplicitReceiver myImplicitReceiver = new MyImplicitReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("garg.sarthik.custombroadcast");

        registerReceiver(m
                yImplicitReceiver,intentFilter);

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction("garg.sarthik.custombroadcast");
                sendBroadcast(intent);
            }
        });
    }
}
