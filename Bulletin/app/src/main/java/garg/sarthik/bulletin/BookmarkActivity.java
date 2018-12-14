package garg.sarthik.bulletin;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookmarkActivity extends AppCompatActivity {

    TextView tvPublisher;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        tvPublisher = findViewById(R.id.tvPublisher);
        tvPublisher.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/acherus_grotesque.otf"));
        tvPublisher.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        tvPublisher.setText("Bookmark");
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)tvPublisher.getLayoutParams();
        params.setMargins(0, 0, 0, 0); //substitute parameters for left, top, right, bottom
        tvPublisher.setLayoutParams(params);

        RecyclerView recyclerView = findViewById(R.id.rvNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(NewsApplication.getDB().getNewsDao().getAllNews(),this,News_Constants.NEWS_UNKNOWN));
    }
}
