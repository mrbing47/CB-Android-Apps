package garg.sarthik.biodata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.FragAContainer,new FragmentA())
                .commit();

    }

    void addFragment(FragmentB fragmentB){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.FragBContainer,fragmentB)
                .commit();
    }
}
