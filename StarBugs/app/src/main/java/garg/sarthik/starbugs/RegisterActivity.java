package garg.sarthik.starbugs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import garg.sarthik.starbugs.POJO.User;
import garg.sarthik.starbugs.Statics.Variables;
import io.opencensus.metrics.LongGauge;

public class RegisterActivity extends AppCompatActivity {

    private String TAG = "Reg";

    LinearLayout llRegister;
    TextInputEditText etName;
    TextInputEditText etEmail;
    TextInputEditText etNumber;
    TextInputEditText etAuthId;
    TextInputEditText etBranch;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        llRegister = findViewById(R.id.llRegister);
        etName = findViewById(R.id.etRegName);
        etEmail = findViewById(R.id.etRegEmail);
        etNumber = findViewById(R.id.etRegNumber);
        etAuthId = findViewById(R.id.etRegAuthId);
        etBranch = findViewById(R.id.etRegBranch);
        btnRegister = findViewById(R.id.btnRegSubmit);

        if (Variables.fireUser.getDisplayName() != null)
            etName.setText(Variables.fireUser.getDisplayName());

        if (Variables.fireUser.getEmail() != null)
            etEmail.setText(Variables.fireUser.getEmail());

        if (Variables.fireUser.getPhoneNumber() != null)
            etNumber.setText(Variables.fireUser.getPhoneNumber());


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = etName.getText().toString().trim();
                final String email = etEmail.getText().toString().trim();
                final String phone = etNumber.getText().toString().trim();
                final String authId = etAuthId.getText().toString().trim();
                final String branch = etBranch.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || authId.isEmpty() || branch.isEmpty() || phone.length() != 10) {
                    Snackbar.make(llRegister, "Please enter proper data", Snackbar.LENGTH_LONG).show();
                    return;
                }

                FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
                    @Override
                    public void onSuccess(InstanceIdResult instanceIdResult) {

                        Log.i(TAG, "onSuccess: " + instanceIdResult.getToken());
                        Variables.user = new User(name, email, phone, authId, branch, instanceIdResult.getToken());

                        Variables.colUser.document(Variables.fireUser.getUid()).set(Variables.user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(llRegister, "Error Occurred, Please try again", Snackbar.LENGTH_LONG).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(llRegister, "Error Occurred, Please try again", Snackbar.LENGTH_LONG).show();
                    }
                });


            }
        });
    }
}
