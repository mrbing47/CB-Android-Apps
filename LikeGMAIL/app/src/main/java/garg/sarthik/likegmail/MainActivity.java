package garg.sarthik.likegmail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static garg.sarthik.likegmail.R.id.FragBContainer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(FragBContainer == 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.FragAContainer, new FragmentA())
                    .commit();
        }
    }

    void addFragment(FragmentB fragmentB){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(FragBContainer,fragmentB)
                .commit();
    }
}
