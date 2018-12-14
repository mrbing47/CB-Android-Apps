package garg.sarthik.mynotes;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    EditText etNote;
    ListView lvNote;
    ArrayList<Notes> notelist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = findViewById(R.id.etNotes);
        btnAdd = findViewById(R.id.btnAdd);
        lvNote = findViewById(R.id.lvNotes);
        final MyNotes myNotes = new MyNotes();
        lvNote.setAdapter(myNotes);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strDate = DateFormat.getDateTimeInstance().format(new Date());

                if(etNote.getText().toString().length() != 0)
                {
                    notelist.add(new Notes(etNote.getText().toString(),strDate));
                    myNotes.notifyDataSetChanged();
                    etNote.setText("");
                    Log.e("MainActivity", "onClick");
                }

            }
        });

    }

    class MyNotes extends BaseAdapter {

        @Override
        public int getCount() {
            return notelist.size();
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
        public View getView(final int i, View view, ViewGroup viewGroup) {

            View Inflatedview;

            if (view == null) {
                LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE); // OR LayoutInflater li = LayoutInflater.from(MainActivity.this);
                Inflatedview = li.inflate(R.layout.item_list, viewGroup, false);

                ViewHolder viewHolder = new ViewHolder();
                viewHolder.tvNote = Inflatedview.findViewById(R.id.tvNote);
                viewHolder.tvTime = Inflatedview.findViewById(R.id.tvTime);

                Inflatedview.setTag(viewHolder);

            } else
                Inflatedview = view;

            Notes currentnote = notelist.get(i);

            ViewHolder vh = (ViewHolder) Inflatedview.getTag();

            vh.tvNote.setText(currentnote.getNotes());
            vh.tvTime.setText(currentnote.getTime());

            Log.e("MyNotes", "getView");

            Button btnRemove = Inflatedview.findViewById(R.id.btnRemove);

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    notelist.remove(i);
                    notifyDataSetChanged();
                    Toast t = Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT);
                    t.show();
                }
            });

            return Inflatedview;

        }
        class ViewHolder {
            TextView tvTime;
            TextView tvNote;
        }
    }



}
