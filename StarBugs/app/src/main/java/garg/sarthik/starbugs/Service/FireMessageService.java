package garg.sarthik.starbugs.Service;

import android.app.Notification;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.firestore.SetOptions;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

import garg.sarthik.starbugs.R;
import garg.sarthik.starbugs.Statics.Constants;
import garg.sarthik.starbugs.Statics.Functions;
import garg.sarthik.starbugs.Statics.Variables;

public class FireMessageService extends FirebaseMessagingService {

    private String TAG = "FCMService";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Log.i(TAG, "onMessageReceived: " + remoteMessage.getData().get("latlng"));
        String address = Functions.decodeAddress(getBaseContext(), Functions.getLatLng(remoteMessage.getData().get("eventLatlng")));
        showNotification(Functions.formatDateTime(remoteMessage.getData().get("eventStartTime")), address);
    }

    void showNotification(String time, String address){

        Notification notification = new NotificationCompat.Builder(this,"FCM")
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
