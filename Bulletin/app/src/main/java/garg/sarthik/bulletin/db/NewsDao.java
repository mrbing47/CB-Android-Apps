package garg.sarthik.bulletin.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import garg.sarthik.bulletin.Articles;
import garg.sarthik.bulletin.Quotes;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM articles")
    List<Articles> getAllNews();

    @Query("SELECT * FROM quotes")
    List<Quotes> getAllQuotes();

    @Query("SELECT * FROM articles WHERE publishedAt LIKE :date")
    List<Articles> getDataWithDate(String date);

    @Update
    void updateNews(Articles articles);

    @Insert
    void insertNews(Articles... articles);

    @Insert
    void insertQuote(Quotes quotes);

    @Delete
    void deleteNews(Articles articles);

    @Query("DELETE FROM quotes")
    void deleteQuote();

}
