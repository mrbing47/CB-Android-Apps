package garg.sarthik.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String string = intent.getAction();
        if(string.equals("android.intent.action.ACTION_POWER_CONNECTED"))
            Toast.makeText(context, "CHARGING", Toast.LENGTH_SHORT).show();
        if(string.equals("android.intent.action.HEADSET_PLUG"))
            Toast.makeText(context, "HEADPHONES CONNECTED", Toast.LENGTH_SHORT).show();
        if(string.equals("android.intent.action.ACTION_POWER_DISCONNECTED"))
            Toast.makeText(context, "CHARGING DISCONTINUED", Toast.LENGTH_SHORT).show();

    }
}
