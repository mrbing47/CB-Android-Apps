package garg.sarthik.recordkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.support.v7.widget.LinearLayoutManager.*;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    EditText etNote;
    RecyclerView rvNote;
    ArrayList<Notes> notelist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = findViewById(R.id.etNotes);
        btnAdd = findViewById(R.id.btnAdd);
        rvNote = findViewById(R.id.rvNotes);

        final NoteAdaptor noteAdaptor = new NoteAdaptor(MainActivity.this,notelist);

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager glm = new GridLayoutManager(this,2);

        rvNote.setLayoutManager(llm);
        rvNote.setAdapter(noteAdaptor);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strDate = DateFormat.getDateTimeInstance().format(new Date());

                if(etNote.getText().toString().length() != 0)
                {
                    notelist.add(new Notes(etNote.getText().toString(),strDate,"#00FF00"));
                    etNote.setText("");
                    noteAdaptor.notifyDataSetChanged();
                    Log.e("MainActivity", "onClick");
                }

            }
        });
    }
}
