package garg.sarthik.javaonclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Button btn = findViewById(R.id.onClick);

        View.OnClickListener click= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick1: " );
            }
        };

       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick2: ");
             //   btn.setText("Bye");

                //Toast is a class using which you can display a message on screen
               Toast t=  Toast.makeText(MainActivity.this,"SHUT UP", Toast.LENGTH_SHORT);
               t.setGravity(15,0,0);
               t.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,"Welcome", Toast.LENGTH_SHORT).show();

    }
}
