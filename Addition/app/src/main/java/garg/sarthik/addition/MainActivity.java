package garg.sarthik.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import garg.sarthik.calculator.R;

import static garg.sarthik.calculator.R.id.Number2;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView result;
    String TAG = "Main Activity";
    int number1 = 0;
    int number2 = 0;
    int res = 0;
    int numop = 0;
    //int power = 0;
    int decimal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");

        result = findViewById(R.id.txtResult);
        num1 = findViewById(R.id.Number1);
        num2 = findViewById(R.id.Number2);

    }


    public void showResult(View view) {

    }

    public void num(View view) {
    }
}