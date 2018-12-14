package garg.sarthik.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentServiceThread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        //This method runs on a separate thread by default

        //This service will end as soon as the task is done
        //Therefore, you can call blocking operations here directly


    }
}
