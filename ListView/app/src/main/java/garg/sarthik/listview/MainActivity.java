package garg.sarthik.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> studentList = new ArrayList<>();

        studentList.add("Hello");
        studentList.add("Sarthik");
        studentList.add("I");
        studentList.add("am");
        studentList.add("Array");
        studentList.add("List");
        studentList.add("Welcome");
        studentList.add("To");
        studentList.add("Coding");
        studentList.add("Blocks");

        ArrayAdapter<String> arrayAdaptor = new ArrayAdapter<String>(this,R.layout.item_list,R.id.tvList,studentList);  //Adaptors eg: Array Adaptor

        lvStudent = findViewById(R.id.lvStudent);

        lvStudent.setAdapter(arrayAdaptor);

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arrayAdaptor, View view, int i, long l) {
                Toast t = Toast.makeText(MainActivity.this,studentList.get(i), Toast.LENGTH_SHORT);
                t.setGravity(15,0,0);
                t.show();
            }
        });

    }
}
