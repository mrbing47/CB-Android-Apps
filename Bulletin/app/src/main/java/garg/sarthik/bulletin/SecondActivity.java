package garg.sarthik.bulletin;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    TextView tvTitle;
    ImageView ivImage;
    TextView tvDesc;
    Typeface typeface;
    LinearLayout ll;
    Button btnInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        final Bundle bundle = getIntent().getExtras();
        tvDesc = findViewById(R.id.tvDesc);
        btnInfo = findViewById(R.id.btnMoreInfo);
        ll = findViewById(R.id.linearlay);
        ivImage = findViewById(R.id.ivImage);
        tvTitle = findViewById(R.id.tvTitle);
        Picasso.get()
                .load(bundle.getString("image"))
                .placeholder(R.drawable.ic_wallpaper)
                .error(R.drawable.ic_report_problem)
                .into(ivImage);
        int typeOfNews = bundle.getInt("type");
        switch (typeOfNews) {
            case News_Constants.NEWS_INDIA:
                ll.setBackgroundColor(getResources().getColor(R.color.color_news));
                typeface = Typeface.createFromAsset(getAssets(), "fonts/Merriweather-Regular.ttf");
                break;
            case News_Constants.NEWS_ENT:
                typeface = Typeface.createFromAsset(getAssets(), "fonts/Merienda-Regular.ttf");
                ll.setBackgroundColor(getResources().getColor(R.color.color_ent));
                break;
            case News_Constants.NEWS_SPORTS:
                typeface = Typeface.createFromAsset(getAssets(), "fonts/BreeSerif-Regular.ttf");
                ll.setBackgroundColor(getResources().getColor(R.color.color_sports));
                break;
            case News_Constants.NEWS_TECH:
                typeface = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu-Regular.ttf");
                ll.setBackgroundColor(getResources().getColor(R.color.color_tech));
                break;
        }
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bundle.getString("url") != null) {
                    Intent intent = new Intent(SecondActivity.this, WebActivity.class);
                    intent.putExtra("url", bundle.getString("url"));
                    startActivity(intent);
                } else {
                    Toast t = Toast.makeText(SecondActivity.this, "INFORMATION NOT AVAILABLE", Toast.LENGTH_SHORT);
                    t.setGravity(15, 0, 0);
                    t.show();

                }
            }
        });
        tvDesc.setTypeface(typeface);
        tvTitle.setTypeface(typeface);
        tvTitle.setText(bundle.getString("title").toUpperCase());
        tvDesc.setText(bundle.getString("desc"));
    }
}
