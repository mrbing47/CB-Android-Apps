package garg.sarthik.bulletin.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import garg.sarthik.bulletin.Articles;
import garg.sarthik.bulletin.Quotes;

@Database(entities = {Articles.class, Quotes.class}, version = 4, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDao getNewsDao();
}
