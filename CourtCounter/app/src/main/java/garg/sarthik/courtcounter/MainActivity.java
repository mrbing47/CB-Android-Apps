package garg.sarthik.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counterA = 0;
    int counterB = 0;
    TextView tvScoreA;
    TextView tvScoreB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScoreA = findViewById(R.id.tvScoreA);
        tvScoreB = findViewById(R.id.tvScoreB);
    }

    public void Score(View view) {

        switch(view.getId())
        {
            case R.id.btn3A:    counterA+=3;
                                break;
            case R.id.btn2A:    counterA+=2;
                                break;
            case R.id.btnFTA:   counterA++;
                                break;
            case R.id.btn3B:    counterB+=3;
                                break;
            case R.id.btn2B:    counterB+=2;
                                break;
            case R.id.btnFTB:   counterB++;
                                break;
            case R.id.btnReset: counterA = 0;
                                counterB = 0;
                                break;
        }
        tvScoreA.setText(Integer.toString(counterA));
        tvScoreB.setText(Integer.toString(counterB));

    }
}
