package garg.sarthik.classwork;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            myTask myTask = new myTask();
//            myTask.cancel(true);
            myTask.execute(100000001);

            }
        });


    }

//    private void startCount(final int num) {
//
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                for(int i = 1 ; i < num ; i++ )
//                {
//                    Log.e("TAG", ""+i );
//
//                }
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        tv.setText("COUNTING IS DONE");
//                    }
//                });
//              }
//        });
//
//        thread.start();
//
//
//
//
//    }
    class myTask extends AsyncTask<Integer,Integer,Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        ProgressBar pb = findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        if(aBoolean)
            Toast.makeText(MainActivity.this, "COUNTING Done", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "COUNTING Failed", Toast.LENGTH_SHORT).show();

        ProgressBar pb = findViewById(R.id.pb);
        pb.setVisibility(View.GONE);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        TextView textView = findViewById(R.id.textView);
        textView.setText(values[0].toString());
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {

        for(Integer i = 1 ; i < integers[0] ; i++ )
        {
                    Log.e("TAG", "" + i );
                    if(i % 1000 == 0)
                        publishProgress(i);

        }
        return true;
    }
}


}
