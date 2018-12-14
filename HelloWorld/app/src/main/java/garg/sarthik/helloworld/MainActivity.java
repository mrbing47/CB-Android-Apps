package garg.sarthik.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showText;
    int counter = 0;
    String str = "COUNTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText = (TextView) findViewById(R.id.counterValue);
    }


    public void countIE(View v1)
    {
        counter++;
        showText.setText(Integer.toString(counter));
    }

    public void countDE(View v2)
    {
     counter--;
     showText.setText(Integer.toString(counter));
    }

    public void resetCOUNT(View v3)
    {
        counter = 0;
        showText.setText(str);
    }




}