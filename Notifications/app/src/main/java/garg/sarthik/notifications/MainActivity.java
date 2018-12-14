package garg.sarthik.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "420";
    Button btnSimple;
    Button btnText;
    Button btnImage;
    Button btnInbox;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimple = findViewById(R.id.btnSimple);
        btnText = findViewById(R.id.btnExpandedText);
        btnImage = findViewById(R.id.btnExpandedImage);
        btnInbox = findViewById(R.id.btnInbox);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    "Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        btnInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivities(MainActivity.this, 123, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentTitle("HELLO WORLD")
                        .setContentText("This is my Inbox notification")
                        .setStyle(new NotificationCompat
                                .InboxStyle()
                                .addLine("LINE 1")
                                .addLine("LINE 2")
                                .addLine("LINE 3"))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_android,"REPLY",pendingIntent)
                        .build();
                notificationManager.notify(141, notification);

            }
        });
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivities(MainActivity.this, 123, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentTitle("HELLO WORLD")
                        .setContentText("This is Expanded Image notification")
                        .setStyle(new NotificationCompat
                                .BigPictureStyle()
                                .bigPicture(icon))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_android,"REPLY",pendingIntent)
                        .build();
                notificationManager.notify(131, notification);

            }
        });
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivities(MainActivity.this, 123, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentTitle("HELLO WORLD")
                        .setContentText("This is my Expanded Text notification")
                        .setStyle(new NotificationCompat
                                .BigTextStyle()
                                .bigText("HAHAHAHAHAHAHAHAHAHAHAHA"))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_android, "REPLY", pendingIntent)
                        .build();
                notificationManager.notify(111, notification);

            }
        });
        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivities(MainActivity.this, 123, new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentTitle("HELLO WORLD")
                        .setContentText("This is my Simple notification")
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_android, "REPLY", pendingIntent)
                        .build();
                notificationManager.notify(101, notification);

            }
        });

    }
}
