package garg.sarthik.bulletin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    boolean isArrayList;
    private ArrayList<Articles> articlesArrayList;
    private List<Articles> articlesList;
    private Context context;
    private int typeOfNews;

    public Adapter(ArrayList<Articles> articlesArrayList, Context context, int typeOfNews) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
        this.typeOfNews = typeOfNews;
        isArrayList = true;
    }

    public Adapter(List<Articles> articlesList, Context context, int typeOfNews) {
        this.articlesList = articlesList;
        this.context = context;
        this.typeOfNews = typeOfNews;
        isArrayList = false;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_list, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Articles article;
        holder.tvNews.setTypeface(holder.typeface);
        if (!isArrayList) {
            article = articlesList.get(position);
            holder.tvListPublisher.setText(article.getName());
            typeOfNews = article.getTypeOfNews();
        } else {
            holder.tvListPublisher.setVisibility(View.INVISIBLE);
            article = articlesArrayList.get(holder.getAdapterPosition());
        }
        Log.e("TAG", "onBindViewHolder: " + typeOfNews);
        holder.tvNews.setText(article.getTitle());
        String[] date = article.getPublishedAt().split("T");
        holder.tvDate.setText(date[0]);

        switch (typeOfNews) {
            case News_Constants.NEWS_INDIA:
                holder.cvList.setCardBackgroundColor(context.getResources().getColor(R.color.color_news));
                holder.typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Merriweather-Regular.ttf");
                break;
            case News_Constants.NEWS_ENT:
                holder.typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Merienda-Regular.ttf");
                holder.cvList.setCardBackgroundColor(context.getResources().getColor(R.color.color_ent));
                break;
            case News_Constants.NEWS_SPORTS:
                holder.typeface = Typeface.createFromAsset(context.getAssets(), "fonts/BreeSerif-Regular.ttf");
                holder.cvList.setCardBackgroundColor(context.getResources().getColor(R.color.color_sports));
                break;
            case News_Constants.NEWS_TECH:
                holder.typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Ubuntu-Regular.ttf");
                holder.cvList.setCardBackgroundColor(context.getResources().getColor(R.color.color_tech));
                break;
        }
        Picasso.get()
                .load(article.getUrlToImage())
                .placeholder(R.drawable.ic_wallpaper)
                .error(R.drawable.ic_report_problem)
                .resize(2000, 2000)
                .centerCrop()
                .into(holder.ivNews);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("title", article.getTitle());
                intent.putExtra("desc", article.description);
                intent.putExtra("url", article.getUrl());
                intent.putExtra("image", article.getUrlToImage());
                if(isArrayList)
                    intent.putExtra("type", typeOfNews);
                else
                    intent.putExtra("type",article.getTypeOfNews());
                context.startActivity(intent);
            }
        });

        final AlertDialog alertDialog_Bookmark = new AlertDialog.Builder(context)
                .setTitle("DO YOU WANT TO DELETE THIS NEWS?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        NewsApplication.getDB().getNewsDao().deleteNews(article);
                        articlesList.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(context, "NEWS REMOVED", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();

        final AlertDialog alertDialog_MainActivity = new AlertDialog.Builder(context)
                .setTitle("DO YOU WANT TO BOOKMARK THIS NEWS?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean flag = false;
                        for (Articles currentArticle : NewsApplication.getDB().getNewsDao().getAllNews()) {
                            if (currentArticle.getTitle().equals(article.getTitle()) && currentArticle.getName().equals(article.getSource().getName()))
                                flag = true;
                        }
                        if (!flag) {
                            article.setTypeOfNews(typeOfNews);
                            article.setName(article.getSource().getName().split("\\(")[0]);
                            NewsApplication.getDB().getNewsDao().insertNews(article);
                            Toast.makeText(context, "NEWS BOOKMARKED", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(context, "NEWS IS ALREADY BOOKMARKED", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (context instanceof BookmarkActivity)
                    alertDialog_Bookmark.show();
                else
                    alertDialog_MainActivity.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {

        if (isArrayList)
            return articlesArrayList.size();
        else
            return articlesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate;
        TextView tvNews;
        Typeface typeface;
        ImageView ivNews;
        CardView cvList;
        TextView tvListPublisher;

        public ViewHolder(View itemView) {
            super(itemView);

            cvList = itemView.findViewById(R.id.cvList);
            tvDate = itemView.findViewById(R.id.tvpublishedAt);
            ivNews = itemView.findViewById(R.id.ivNews);
            tvNews = itemView.findViewById(R.id.tvNews);
            tvListPublisher = itemView.findViewById(R.id.tvListPublisher);

        }
    }
}
