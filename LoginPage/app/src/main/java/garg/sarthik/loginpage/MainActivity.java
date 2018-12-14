package garg.sarthik.loginpage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGo = findViewById(R.id.btnGO);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),MyBroadcastReceiver.class);
                User user = new User(etEmail.getText().toString(),etPassword.getText().toString());
//                intent.putExtra("id",etEmail.getText().toString());
//                intent.putExtra("password",etPassword.getText().toString());
                intent.putExtra("user",user);

             //   intent.setData(Uri.parse("C++ is the best"));
                sendBroadcast(intent);
            }
        });
    }
}
