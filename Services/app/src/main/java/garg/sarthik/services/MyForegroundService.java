package garg.sarthik.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class MyForegroundService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent stopForeground = new Intent(this, MyForegroundService.class);
        stopForeground.putExtra("KEY",true);
        PendingIntent pendingIntent = PendingIntent.getService(this, 123, stopForeground, PendingIntent.FLAG_UPDATE_CURRENT);

        if(intent.getBooleanExtra("KEY",false))
            stopSelf();
        Notification notification = new NotificationCompat.Builder(this, "420")
                .setSmallIcon(R.drawable.ic_android)
                .setContentTitle("HELLO WORLD")
                .setContentText("This is a Foreground Service")
                .addAction(R.drawable.ic_android, "REPLY", pendingIntent)
                .setAutoCancel(true)
                .build();

        startForeground(420, notification);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
