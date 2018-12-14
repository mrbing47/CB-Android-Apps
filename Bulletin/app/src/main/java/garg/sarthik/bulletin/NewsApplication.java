package garg.sarthik.bulletin;

import android.app.Application;
import android.arch.persistence.room.Room;

import garg.sarthik.bulletin.db.NewsDatabase;

public class NewsApplication extends Application {

    static NewsDatabase newsDatabase;

    public static NewsDatabase getDB() {
        return newsDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        newsDatabase = Room.databaseBuilder(getApplicationContext(),
                NewsDatabase.class,
                "news-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
