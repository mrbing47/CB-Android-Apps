package garg.sarthik.sharedpreferences;

import android.content.SharedPreferences;
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

        SharedPreferences sharedPreferences = getSharedPreferences("my_shared_prefs",MODE_PRIVATE);

        if(sharedPreferences.contains("counter"))
        {

            counter = sharedPreferences.getInt("counter",0);
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

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences("my_shared_prefs",MODE_PRIVATE);

        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt("counter",counter);
        editor.apply();

    }
}
