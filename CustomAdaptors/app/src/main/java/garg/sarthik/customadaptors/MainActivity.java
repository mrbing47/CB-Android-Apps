package garg.sarthik.customadaptors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCustom;
    ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = new ArrayList<>();

        studentList.add(new Student("Hello","Android","Noida"));
        studentList.add(new Student("Sarthik","ML","Pritampura"));
        studentList.add(new Student("Garg","Android","Dwarks"));
        studentList.add(new Student("I","JAVA","Noida"));
        studentList.add(new Student("am","C++","Pritampura"));
        studentList.add(new Student("Array","ML","Noida"));
        studentList.add(new Student("List","Android","Pritampura"));
        studentList.add(new Student("Welcome","JAVA","Noida"));
        studentList.add(new Student("to","Python","Dwarka"));
        studentList.add(new Student("Coding","C++","Noida"));
        studentList.add(new Student("Blocks","Android","Dwarka"));


        lvCustom = findViewById(R.id.lvCustom);

        MyCustomAdaptor mca = new MyCustomAdaptor();
        lvCustom.setAdapter(mca);

    }

    class MyCustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return studentList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {  // i  = position

            LayoutInflater li = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE); // READ WHAT IS VIEW HOLDER
            View Inflatedview ;

            if(view == null)
                Inflatedview = li.inflate(R.layout.item_list,viewGroup,false);
            else
                Inflatedview = view;

            Student currentStudent = studentList.get(i);
            TextView tvName = Inflatedview.findViewById(R.id.tvName);
            TextView tvBatch = Inflatedview.findViewById(R.id.tvBatch);
            TextView tvLocation = Inflatedview.findViewById(R.id.tvLocation);

            tvLocation.setText(currentStudent.getLocation());
            tvBatch.setText(currentStudent.getBatch());
            tvName.setText(currentStudent.getName());
            return Inflatedview;
        }
    };
}
