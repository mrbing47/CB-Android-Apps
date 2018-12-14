package garg.sarthik.pokedex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    ImageView ivMaleFront;
    TextView tvName;
    ImageView ivMaleBack;
    ImageView ivFemaleFront;
    ImageView ivFemaleBack;
    Pokemon pokemon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ivFemaleBack = findViewById(R.id.ivFemaleBack);
        ivFemaleFront = findViewById(R.id.ivFemaleFront);
        ivMaleBack = findViewById(R.id.ivMaleBack);
        ivMaleFront = findViewById(R.id.ivMaleFront);
        tvName = findViewById(R.id.tvSecondName);

        Bundle bundle = getIntent().getExtras();
        String json = bundle.getString("json");

        convertJSON(json);

    }

    private void convertJSON(String s) {

        Gson gson = new Gson();

        pokemon = gson.fromJson(s, Pokemon.class);

        final Sprites sprites = pokemon.getSprites();

        (SecondActivity.this).runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Picasso.get()
                        .load(sprites.getFront_default())
                        .placeholder(R.drawable.pokeball1)
                        .into(ivMaleFront);
                Picasso.get()
                        .load(sprites.getBack_default())
                        .placeholder(R.drawable.pokeball1)
                        .into(ivMaleBack);
                Picasso.get()
                        .load(sprites.getFront_female())
                        .placeholder(R.drawable.pokeball1)
                        .into(ivFemaleFront);
                Picasso.get()
                        .load(sprites.getBack_female())
                        .placeholder(R.drawable.pokeball1)
                        .into(ivFemaleBack);
                tvName.setText(pokemon.getName().toUpperCase().replace("-", " "));

                Log.e("TAG", "onResponse: " + pokemon.getWeight());
                ViewPager viewPager = findViewById(R.id.vpInfo);
                viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
                TabLayout tabLayout = findViewById(R.id.tabLayout);
                tabLayout.setupWithViewPager(viewPager);

            }
        });

    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Basic Info";
                case 1:
                    return "Abilities";
                case 2:
                    return "Stats";
                case 3:
                    return "Items";
            }
            return "";
        }

        @Override
        public android.support.v4.app.Fragment getItem(int i) {
            switch (i) {
                case 0:
                    Log.e("TAG", "getItem: " + pokemon.getWeight());
                    return new Frag_basicInfo().newInstance(pokemon.getWeight(), pokemon.getHeight(), pokemon.getId(), pokemon.getOrder(), pokemon.getBase_experience(), pokemon.getTypes());
                case 1:
                    return new Frag_abilities().newInstance(pokemon.getAbilities());
                case 2:
                    return new Frag_stats().newInstance(pokemon.getStats());
                case 3:
                    return new Frag_items().newInstance(pokemon.getHeld_items());
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
