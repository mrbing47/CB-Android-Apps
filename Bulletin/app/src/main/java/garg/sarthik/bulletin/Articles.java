package garg.sarthik.bulletin;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Articles {

    String title;
    String description;
    @PrimaryKey
            @NonNull
    String url;
    String urlToImage;
    String publishedAt;
    String name;
    int typeOfNews;
    @Ignore
    Source source;

    public Articles() {

    }

    public void setTypeOfNews(int typeOfNews) {
        this.typeOfNews = typeOfNews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Articles(String title, String description, String url, String urlToImage, String publishedAt, Source source, String name, int typeOfNews) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.source = source;
        this.name = name;
        this.typeOfNews = typeOfNews;

    }

    public int getTypeOfNews() {
        return typeOfNews;
    }

    public String getName() {

        return name;
    }
    public String getPublishedAt() {
        return publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Source getSource() {
        return source;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
