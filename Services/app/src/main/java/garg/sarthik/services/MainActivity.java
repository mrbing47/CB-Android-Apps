package garg.sarthik.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myService = new Intent(MainActivity.this, MyService.class);
                Intent myIntentService = new Intent(getBaseContext(),MyIntentService.class);
                Intent myForegroundService = new Intent(getBaseContext(), MyForegroundService.class);
//                startService(myIntentService);

                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("420",
                            "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(notificationChannel);
                }

                ContextCompat.startForegroundService(getBaseContext(),myForegroundService);



//                startForegroundService(myForegroundService);
            }
        });


    }

}
