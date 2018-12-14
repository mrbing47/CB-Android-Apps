package garg.sarthik.dynamicfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add FragA here

        FragmentA fragmentA = new FragmentA();
//        FragmentA fragmentA1 = new FragmentA();
//        FragmentA fragmentA2 = new FragmentA();


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.FragAContainer,fragmentA)
//                .commit()
//                .add(R.id.FragAContainer,fragmentA2)
//                .add(R.id.FragAContainer,fragmentA1)
                .commit();

    }

    void addFragment(FragmentB fragmentB)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragBContainer,fragmentB)
                .commit();

        /*TextView tvCount = findViewById(R.id.tvCounter);
        tvCount.setText(String.format("%d", count));*/

        }
}
