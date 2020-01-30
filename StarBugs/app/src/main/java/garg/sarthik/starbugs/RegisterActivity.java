package garg.sarthik.starbugs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import garg.sarthik.starbugs.POJO.User;
import garg.sarthik.starbugs.Statics.Variables;

public class RegisterActivity extends AppCompatActivity {

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

        etName = findViewById(R.id.etRegName);
        etEmail = findViewById(R.id.etRegEmail);
        etNumber = findViewById(R.id.etRegNumber);
        etAuthId = findViewById(R.id.etRegAuthId);
        etBranch = findViewById(R.id.etRegBranch);
        btnRegister = findViewById(R.id.btnRegSubmit);

        if (!Variables.fireUser.getDisplayName().isEmpty())
            etName.setText(Variables.fireUser.getDisplayName());

        if (!Variables.fireUser.getEmail().isEmpty())
            etEmail.setText(Variables.fireUser.getEmail());

        if (!Variables.fireUser.getPhoneNumber().isEmpty())
            etNumber.setText(Variables.fireUser.getPhoneNumber());


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etNumber.getText().toString().trim();
                String authId = etAuthId.getText().toString().trim();
                String branch = etBranch.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || authId.isEmpty() || branch.isEmpty() || phone.length() != 10) {
                    Toast.makeText(RegisterActivity.this, "Please enter proper data", Toast.LENGTH_SHORT).show();
                    return;
                }

                Variables.user = new User(name, email, phone, authId, branch);

                Variables.colUser.document(Variables.fireUser.getUid()).set(Variables.user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error Occurred, Please try again", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
