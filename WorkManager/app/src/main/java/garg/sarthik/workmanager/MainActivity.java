package garg.sarthik.workmanager;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.State;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnWork);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                .Builder(MyWorker.class)
                .setInitialDelay(15, TimeUnit.SECONDS)
                .setConstraints(new Constraints
                        .Builder()
                        .setRequiresCharging(true)
                        .build())  //It will check the that if the constraint is true,if yes, only then the work will execute
                .build();


        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest
                .Builder(MyWorker.class,
                10,
                TimeUnit.SECONDS)
//                30,
//                TimeUnit.SECONDS)
                .setInputData(new Data                      //This is used to send the data which is required to do things
                        .Builder()
                        .putString("hey","WORLD")
                        .build())
                .build();


        WorkManager.getInstance().enqueue(periodicWorkRequest);

        final LiveData<WorkStatus> workStatusLiveData = WorkManager.getInstance().getStatusById(oneTimeWorkRequest.getId());

        workStatusLiveData.observe(this, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {
                State state = workStatus.getState();

                if(state == State.FAILED)
                {}
                else
                    if(state == State.SUCCEEDED)
                    {

                        //Fetch the data from here

                    }


            }
        });
    }
}
