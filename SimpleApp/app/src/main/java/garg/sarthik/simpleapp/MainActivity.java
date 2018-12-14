package garg.sarthik.simpleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvOutput;
    // EditText etInput;
    Button btnCounter;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = findViewById(R.id.tvOutput);
        //etInput = findViewById(R.id.etInput);
        btnCounter = findViewById(R.id.btnCounter);


        if (savedInstanceState != null && savedInstanceState.containsKey("count")) {

            counter = savedInstanceState.getInt("count");
            tvOutput.setText(""+counter);
        }



        btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter++;
                tvOutput.setText("" + counter);

            }
        });
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("count", counter);

        super.onSaveInstanceState(outState);

    }
}
