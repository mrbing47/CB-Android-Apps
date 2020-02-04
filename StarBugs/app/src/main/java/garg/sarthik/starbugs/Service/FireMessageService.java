package garg.sarthik.starbugs.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.firestore.SetOptions;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

import garg.sarthik.starbugs.MainActivity;
import garg.sarthik.starbugs.R;
import garg.sarthik.starbugs.Statics.Functions;
import garg.sarthik.starbugs.Statics.Variables;

public class FireMessageService extends FirebaseMessagingService {

    private String TAG = "FCMService";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        String address = Functions.decodeAddress(getBaseContext(), Functions.getLatLng(remoteMessage.getData().get("eventLatlng")));
        Log.i(TAG, "onMessageReceived: " + remoteMessage.getData().get("eventGifUrl"));
        showNotification(Functions.formatDateTime(remoteMessage.getData().get("eventId").split("-")[0]), address);
    }

    void showNotification(String time, String address) {

        final String CHANNEL_ID = "4769";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    "Anomaly Notify",
                    NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent launchPendingIntent = PendingIntent.getActivity(this, 47, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentIntent(launchPendingIntent)
                .setContentTitle("Anomaly detected!!")
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setAutoCancel(true)
                .setContentText("Started at " + time)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Anomaly has been detected at " + address))
                .build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(6969, notification);

    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Map<String, Object> data = new HashMap<>();
        data.put("userToken", s);

        Variables.colUser.document(Variables.fireUser.getUid()).set(data, SetOptions.merge());


        Log.i(TAG, "onNewToken: " + s);

    }
}
