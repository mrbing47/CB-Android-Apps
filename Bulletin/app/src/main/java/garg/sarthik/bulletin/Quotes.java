package garg.sarthik.bulletin;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Quotes {

    @PrimaryKey @NonNull
    String quote;
    String author;


    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Quotes(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }
    public Quotes() {

    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}
