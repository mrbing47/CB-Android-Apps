package garg.sarthik.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand: ");
//        stopSelf(); => This is use to destroy the service same as finish() in an Activity

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                for (int i = 0; i < 1005; i++) {
//                    Log.e("TAG", "run: " + i);
//                }
//                stopSelf();
//            }
//        }).start();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {      //this is a bound service, one of the best use for this service is Music Player
        return null;
    }
}
