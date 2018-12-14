package garg.sarthik.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvRank;
    TextView tvBaseExp;
    TextView tvName;
    EditText etInput;
    ImageView ivPokemon;
    FloatingActionButton fabSearch;
    ImageButton ibNext;
    ImageButton ibBack;
    int count;
    String result;
    Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRank = findViewById(R.id.tvRank);
        tvBaseExp = findViewById(R.id.tvBaseExp);
        fabSearch = findViewById(R.id.fabSearch);
        tvName = findViewById(R.id.tvName);
        etInput = findViewById(R.id.etInput);
        ivPokemon = findViewById(R.id.ivPokemon);
        ibBack = findViewById(R.id.ibBack);
        ibNext = findViewById(R.id.ibNext);

        count = generateRandom();
        Log.e("TAG", "onCreate: " + count);
        makeNetworkCall("https://pokeapi.co/api/v2/pokemon/" + count);
        ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count < 802) {
                    count++;
                    if (count == 802)
                        ibNext.setVisibility(View.INVISIBLE);
                    if (count > 1)
                        ibBack.setVisibility(View.VISIBLE);
                    Toast t = Toast.makeText(MainActivity.this, "PLEASE WAIT", Toast.LENGTH_LONG);
                    t.setGravity(15, 0, 0);
                    t.show();
                    makeNetworkCall("https://pokeapi.co/api/v2/pokemon/" + count);
                }

            }
        });
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count > 1) {
                    count--;
                    if (count == 1)
                        ibBack.setVisibility(View.INVISIBLE);
                    if (count < 802)
                        ibNext.setVisibility(View.VISIBLE);

                    Toast t = Toast.makeText(MainActivity.this, "PLEASE WAIT", Toast.LENGTH_LONG);
                    t.setGravity(15, 0, 0);
                    t.show();
                    makeNetworkCall("https://pokeapi.co/api/v2/pokemon/" + count);
                }

            }
        });
        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(etInput.getText().toString().equals(""))) {
                    if (Integer.parseInt(etInput.getText().toString()) < 803 && Integer.parseInt(etInput.getText().toString()) > 0) {

                        count = Integer.parseInt(etInput.getText().toString());

                        if (count == 802)
                            ibNext.setVisibility(View.INVISIBLE);
                        else
                            ibNext.setVisibility(View.VISIBLE);

                        if (count == 1)
                            ibBack.setVisibility(View.INVISIBLE);
                        else
                            ibBack.setVisibility(View.VISIBLE);

                        Toast t = Toast.makeText(MainActivity.this, "PLEASE WAIT", Toast.LENGTH_LONG);
                        t.setGravity(15, 0, 0);
                        t.show();
                        makeNetworkCall("https://pokeapi.co/api/v2/pokemon/" + count);
                    } else
                        Toast.makeText(MainActivity.this, "ID RANGE: 1 -> 802", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void makeNetworkCall(String s) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Log.e("TAG", "makeNetworkCall: ");

        final Request request = new Request.Builder()
                .url(s)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                result = response.body().string();
                Gson gson = new Gson();

                pokemon = gson.fromJson(result, Pokemon.class);
                final Sprites sprites = pokemon.getSprites();
                Log.e("TAG", "" + pokemon.getId());
                Log.e("TAG", "" + pokemon.getBase_experience());
                Log.e("TAG", "" + pokemon.getName().replace("-", " "));

                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        tvRank.setText("" + pokemon.getId());
                        tvBaseExp.setText("" + pokemon.getBase_experience());
                        tvName.setText(pokemon.getName().toUpperCase().replace("-", " "));

                        Picasso.get()
                                .load(sprites.getFront_default())
                                .placeholder(R.drawable.pokeball1)
                                .into(ivPokemon);
                        etInput.setText("");

                        ivPokemon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                                i.putExtra("json", result);
                                startActivity(i);
                            }
                        });
                    }
                });
            }
        });

    }

    public static int generateRandom() {
        Random rand = new Random();
        return rand.nextInt(802) + 1;
    }

}
