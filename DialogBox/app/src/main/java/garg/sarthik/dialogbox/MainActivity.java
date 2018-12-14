package     garg.sarthik.dialogbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmailID;
    EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnComplex = findViewById(R.id.btnComplex);
        Button btnSimple = findViewById(R.id.btnSimple);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Alert Dialog")
                .setMessage("HEY")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "YEAH!!!", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "NOOOOOOOO!!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });

        final View view = LayoutInflater.from(this).inflate(R.layout.layout_dialog,null,true);

        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Complex Alert Dialog")
                .setView(view)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        etEmailID = view.findViewById(R.id.etEmail);
                        etPass = view.findViewById(R.id.etPassword);

                        String email = etEmailID.getText().toString();
                        String password = etPass.getText().toString();

                        Toast.makeText(MainActivity.this, email + " " + password, Toast.LENGTH_SHORT).show();
                        //Create a new User
                        //Send a Broadcast
                    }
                })
                .create();
        btnComplex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();
            }
        });

    }
}
