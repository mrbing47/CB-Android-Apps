package garg.sarthik.starbugs.Service;

import android.app.Notification;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FireMessageService extends FirebaseMessagingService {

    private String TAG = "FCMService";


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());

    }

    void showNotification(String title, String body){

        Notification notification = new NotificationCompat.Builder(this,"FCM")
                .setContentTitle(title)
                .setAutoCancel(true)
                .setContentText(body)
                .build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(6969, notification);

    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Log.i(TAG, "onNewToken: ");

    }
}
