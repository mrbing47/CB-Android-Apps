package garg.sarthik.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ettxt=findViewById(R.id.etID);
        Button btn=findViewById(R.id.btn);
        Log.e(TAG, "onCreate: ");

       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start Second_Activity
                String enteredValue = ettxt.getText().toString();
                Intent intent= new Intent(getBaseContext(),Second_Activity.class);

                intent.putExtra("KEY", enteredValue);
                startActivity(intent);
               // finish();//kills the current activity
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "WELCOME",Toast.LENGTH_SHORT).show();
    }
}
