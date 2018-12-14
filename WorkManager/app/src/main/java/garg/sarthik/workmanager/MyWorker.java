package garg.sarthik.workmanager;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

public class MyWorker extends Worker {
    @NonNull
    @Override
    public Result doWork() {
        //This will run on a different thread
        //Do your long running jobs here


        //The application context is not a complete context and you can't use it to do any UI related things,
        // therefore you can't show a toast (there will be no errors, but it will never show up) using this context
        //getApplicationContext()

        //Let's make a network call

        //This is used to get data which is passes in the worker and can use this data to proceed further
        Data currentData = getInputData();
        String info = currentData.getString("hey",null);
        try {

            Log.e("TAG", "doWork: TRY "+System.currentTimeMillis());
            //make network call here
            return Result.SUCCESS;
        } catch (Exception e) {


            //You can return Result.FAILURE or Result.RETRY
            Log.e("TAG", "doWork: CATCH "+System.currentTimeMillis());

            return Result.FAILURE;
        }
    }
}
