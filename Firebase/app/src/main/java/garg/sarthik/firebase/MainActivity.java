package garg.sarthik.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener {

    EditText etInput;
    Button btnAdd;
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etInput = findViewById(R.id.etInput);

        btnAdd = findViewById(R.id.btnAdd);
        rvList = findViewById(R.id.rvList);
//            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//
//            final DatabaseReference dbRef = firebaseDatabase.getReference();
//
////        final DatabaseReference childRef = dbRef.child("test");
//
//            final List<Task> taskList = new ArrayList<>();
//            final TaskAdaptor taskAdaptor = new TaskAdaptor(this, taskList);
//
//            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                    Iterable<DataSnapshot> dataSnapshotIterable = dataSnapshot.getChildren();
//                    //  taskList.clear();
//
//                    for (DataSnapshot ds : dataSnapshotIterable) {
//
//                        Task currentTask = ds.getValue(Task.class);
//                        taskList.add(currentTask);
//                    }
//                    taskAdaptor.notifyDataSetChanged();
//
//                    dbRef.addChildEventListener(new ChildEventListener() {
//                        @Override
//                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                            Task task = dataSnapshot.getValue(Task.class);
//
//                            int flag = 0;
//
//                            for (Task forTask : taskList) {
//
//                                if (task.getId().equals(forTask.getId())) {
//                                    flag = 1;
//                                    break;
//                                }
//                            }
//
//                            if (flag == 0)
//                                taskList.add(task);
//                        }
//
//                        @Override
//                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                        }
//
//                        @Override
//                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                            Task task = dataSnapshot.getValue(Task.class);
//
//                            for (Task forTask : taskList) {
//
//                                if (task.getId().equals(forTask.getId())) {
//                                    taskList.remove(forTask);
//                                    taskAdaptor.notifyDataSetChanged();
//                                    break;
//                                }
//                            }
//
//                        }
//
//                        @Override
//                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            Toast.makeText(MainActivity.this, "UNABLE TO FETCH DATA", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//            btnAdd.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //Submit the entered data here to firebase
//                    String name = etInput.getText().toString();
//
//                    //childRef.push().setValue(name);
//                    Task task = new Task(name,
//                            "Current time is: ",
//                            System.currentTimeMillis(),
//                            false);
//                    dbRef.push().setValue(task);
//                    taskAdaptor.notifyDataSetChanged();
//                    etInput.setText("");
//
//                }
//            });
//
//            rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, true));
//            rvList.setAdapter(taskAdaptor);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseAuth.getInstance().addAuthStateListener(this);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

        if (firebaseAuth.getCurrentUser() == null) {

            //Start Login
            Intent loginIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(Arrays.asList(
                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.PhoneBuilder().build()))
                    .build();
            startActivity(loginIntent);

        } else {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

            final DatabaseReference dbRef = firebaseDatabase.getReference();

//        final DatabaseReference childRef = dbRef.child("test");

            final List<Task> taskList = new ArrayList<>();
            final TaskAdaptor taskAdaptor = new TaskAdaptor(this, taskList);

            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Iterable<DataSnapshot> dataSnapshotIterable = dataSnapshot.getChildren();
                    //  taskList.clear();

                    for (DataSnapshot ds : dataSnapshotIterable) {

                        Task currentTask = ds.getValue(Task.class);
                        taskList.add(currentTask);
                    }
                    taskAdaptor.notifyDataSetChanged();

                    dbRef.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            Task task = dataSnapshot.getValue(Task.class);

                            int flag = 0;

                            for (Task forTask : taskList) {

                                if (task.getId().equals(forTask.getId())) {
                                    flag = 1;
                                    break;
                                }
                            }

                            if (flag == 0)
                                taskList.add(task);
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                            Task task = dataSnapshot.getValue(Task.class);

                            for (Task forTask : taskList) {

                                if (task.getId().equals(forTask.getId())) {
                                    taskList.remove(forTask);
                                    taskAdaptor.notifyDataSetChanged();
                                    break;
                                }
                            }

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                            int errorCode = databaseError.getCode();
                            if(errorCode == -7)
                                Toast.makeText(MainActivity.this, "You Need To login to the app", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(MainActivity.this, "UNABLE TO FETCH DATA", Toast.LENGTH_SHORT).show();

                            Log.e("TAG", "onCancelled: " + errorCode);
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    int errorCode = databaseError.getCode();
                    if(errorCode == -7)
                        Toast.makeText(MainActivity.this, "You Need To login to the app", Toast.LENGTH_SHORT).show();
                }
            });
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Submit the entered data here to firebase
                    String name = etInput.getText().toString();

                    //childRef.push().setValue(name);
                    Task task = new Task(name,
                            "Current time is: ",
                            System.currentTimeMillis(),
                            false);
                    dbRef.push().setValue(task);
                    taskAdaptor.notifyDataSetChanged();
                    etInput.setText("");

                }
            });

            rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, true));
            rvList.setAdapter(taskAdaptor);
        }
    }
}
