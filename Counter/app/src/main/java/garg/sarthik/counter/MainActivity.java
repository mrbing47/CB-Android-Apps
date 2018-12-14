package garg.sarthik.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "Main Activity";
    int counter = 0 ;
    TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);
        Log.e(TAG,"onCreate was called");
        counterText = findViewById(R.id.txtCounter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    public void countDE(View view) {
        if(counter > 0)
          counter--;
        counterText.setText(Integer.toString(counter));
        Log.e(TAG, "countDE: " + counter);
    }

    public void countIN(View view) {
        counter++;
        counterText.setText(Integer.toString(counter));
        Log.e(TAG, "countIN: " + counter);
    }

    public void resetCounter(View view) {
        counter = 0;
        counterText.setText("COUNTER");
        Log.e(TAG, "resetCounter: " + counter);

    }
}
