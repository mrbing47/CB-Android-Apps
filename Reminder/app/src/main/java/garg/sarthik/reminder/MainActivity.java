package garg.sarthik.reminder;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    EditText etTask;
    EditText etTaskID;
    FloatingActionButton fabSearch;
    RecyclerView rvTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Task> taskList = TaskApplication.taskDatabase.getTaskDao().getAllData();
        final TaskAdaptor taskAdaptor = new TaskAdaptor(taskList,this);

        etTask = findViewById(R.id.etTask);
        btnAdd = findViewById(R.id.btnAdd);
        fabSearch = findViewById(R.id.fabSearch);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etTask.getText() != null) {

                    Task task = new Task(etTask.getText().toString(), false, 0);
                    TaskApplication.getDB().getTaskDao().insertTask(task);
                    taskList.add(task);
                    taskAdaptor.notifyDataSetChanged();

                }

            }
        });

        final View view = LayoutInflater.from(this).inflate(R.layout.alertdialog_layout, null, true);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Enter the ID")
                .setView(view)
                .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        etTaskID = view.findViewById(R.id.etTaskID);

                        List<Task> tasks = new ArrayList<>();
                        Task task = TaskApplication.taskDatabase.getTaskDao().getDataWithId(Integer.parseInt(etTaskID.getText().toString()));

                        tasks.add(task);
                        rvTask = findViewById(R.id.rvTask);
                        rvTask.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        rvTask.setAdapter(new TaskAdaptor(tasks, getBaseContext()));
                    }
                })
                .create();

        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.show();

            }
        });


        // if(TaskApplication.taskDatabase.getTaskDao().getAllData() != null)
      //  TaskAdaptor taskAdaptor = new TaskAdaptor(taskList,this);
        rvTask = findViewById(R.id.rvTask);
        rvTask.setLayoutManager(new LinearLayoutManager(this));
        rvTask.setAdapter(taskAdaptor);

    }

    @Override
    public void onBackPressed() {

        rvTask = findViewById(R.id.rvTask);
        rvTask.setLayoutManager(new LinearLayoutManager(this));
        rvTask.setAdapter(new TaskAdaptor(TaskApplication.getDB().getTaskDao().getAllData(),this));

    }
}
