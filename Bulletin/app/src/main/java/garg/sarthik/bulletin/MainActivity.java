package garg.sarthik.bulletin;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String TAG = "BULLETIN";
    QuoteOfTheDay qod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Frag_Quote().newInstance("https://quotes.rest/qod"))
                .commit();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.bookmarks) {
            startActivity(new Intent(MainActivity.this,BookmarkActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        switch (id) {
            case R.id.googlenews:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_INDIA))
                        .commit();
                break;
            case R.id.thehindu:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=the-hindu&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03", News_Constants.NEWS_INDIA))
                        .commit();
                break;

            case R.id.toi:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=the-times-of-india&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_INDIA))
                        .commit();
                break;

            case R.id.buzzfeed:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=buzzfeed&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_ENT))
                        .commit();
                break;
            case R.id.ign:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=ign&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_ENT))
                        .commit();
                break;
            case R.id.ent_weekly:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=entertainment-weekly&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_ENT))
                        .commit();
                break;
            case R.id.mtv:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=mtv-news&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_ENT))
                        .commit();
                break;
            case R.id.bbcsports:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=bbc-sport&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_SPORTS))
                        .commit();
                break;
            case R.id.espn:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=espn&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_SPORTS))
                        .commit();
                break;
            case R.id.espncric:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=espn-cric-info&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_SPORTS))
                        .commit();
                break;

            case R.id.fox_sports:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=fox-sports&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_SPORTS))
                        .commit();
                break;
            case R.id.talksport:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=talksport&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_SPORTS))
                        .commit();
                break;
            case R.id.engadget:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=engadget&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_TECH))
                        .commit();
                break;
            case R.id.techcrunch:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_TECH))
                        .commit();
                break;
            case R.id.theverge:
                Log.e(TAG, "onNavigationItemSelected: THE VERGE");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=the-verge&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03", News_Constants.NEWS_TECH))
                        .commit();
                break;
            case R.id.wired:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container,new Frag_News().newInstance("https://newsapi.org/v2/top-headlines?sources=wired&apiKey=3fe5f4592f844dcf9e6fb9abe46aba03",News_Constants.NEWS_TECH))
                        .commit();
                break;


        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
