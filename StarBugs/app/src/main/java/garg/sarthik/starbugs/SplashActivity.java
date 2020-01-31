package garg.sarthik.starbugs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import garg.sarthik.starbugs.POJO.User;
import garg.sarthik.starbugs.Statics.Constants;
import garg.sarthik.starbugs.Statics.Variables;

public class SplashActivity extends AppCompatActivity {

    private int RC_SIGN_IN = 6969;
    private String TAG = "Auth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build());

// Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN){

            if(resultCode == RESULT_OK){
                Variables.fireUser = FirebaseAuth.getInstance().getCurrentUser();

                Variables.db = FirebaseFirestore.getInstance();
                Variables.colUser = Variables.db.collection(Constants.COL_USER);
                Variables.colCamera = Variables.db.collection(Constants.COL_CAMERA);

                Variables.colUser.document(Variables.fireUser.getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){

                            Variables.user = documentSnapshot.toObject(User.class);

                            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
                                @Override
                                public void onSuccess(InstanceIdResult instanceIdResult) {
                                    if(!instanceIdResult.getToken().equals(Variables.user.getUserToken())){
                                        Map<String, Object> data = new HashMap<>();
                                        data.put("userToken", instanceIdResult.getToken());

                                        Variables.colUser.document(Variables.fireUser.getUid()).set(data, SetOptions.merge());
                                    }
                                }
                            });


                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }else{
                            startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SplashActivity.this, "Failed to Log-in, Please Try Again", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onFailure: ",e );
                    }
                });

            }else{
                Toast.makeText(this, "Error Occurred, Please try again", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
