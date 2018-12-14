package garg.sarthik.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static garg.sarthik.calculator.R.id.Number2;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView result;

    String TAG = "Main Activity";

    int number1 = 0;
    int number2 = 0;
    int res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.Number1);
        num2 = findViewById(R.id.Number2);
        result = findViewById(R.id.txtResult);
    }

    public void calMul(View view) {

        number1 = Integer.parseInt(num1.getText().toString());
        number2 = Integer.parseInt(num2.getText().toString());
        res = number1 * number2;
        result.setText(""+res);

        Log.e(TAG, "calMul: ");
    }

    public void calDiv(View view) {

        number1 = Integer.parseInt(num1.getText().toString());
        number2 = Integer.parseInt(num2.getText().toString());
        if(number2 == 0)
        {
            result.setText("MATH ERROR!!");

        }
        else {
            res = number1 / number2;
            result.setText(""+res);
        }

        Log.e(TAG, "calDiv: ");
    }

    public void calSub(View view) {

        number1 = Integer.parseInt(num1.getText().toString());
        number2 = Integer.parseInt(num2.getText().toString());
        res = number1 - number2;
        result.setText(""+res);

        Log.e(TAG, "calSub: ");
    }

    public void calAdd(View view) {

        number1 = Integer.parseInt(num1.getText().toString());
        number2 = Integer.parseInt(num2.getText().toString());
        res = number1 + number2;
        result.setText(""+res);

        Log.e(TAG, "calAdd: ");
    }
}
