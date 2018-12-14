package garg.sarthik.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import garg.sarthik.database.db.TaskDb;

public class MainActivity extends AppCompatActivity {

    TaskDb taskDb;
    EditText etInput;
    Button btnAdd;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnAdd = findViewById(R.id.btnAdd);
        taskDb = new TaskDb(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = etInput.getText().toString();
                if (input != null) {

                    task = new Task(System.currentTimeMillis(), input);
                    long position = taskDb.insertTask(task);
                    Log.e("TAG", "onCreate: " + position);
                }

            }
        });

        Log.e("FETCH", "onCreate: " + fetchData().size());

    }

    ArrayList fetchData() {
        return taskDb.getAllTask();
    }
}
