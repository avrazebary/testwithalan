package com.example.avraz.networkingarraylist.JSON;

import com.google.gson.annotations.SerializedName;

class ArticlesBean {
    /**
     * source : {"id":"google-news","name":"Google News"}
     * author : Elizabeth Weise
     * title : Five killed in plane crash in shopping complex parking lot near Los Angeles
     * description : A small, twin-engine Cessna bound for John Wayne Airport in Orange County crashed into the parking lot of a Staples office supply store on Sunday, killing all five people aboard, Orange County fire officials said.
     * url : https://www.usatoday.com/story/news/2018/08/05/plane-crash-staples-parking-lot-kills-five-near-los-angeles/910916002/?utm_source=google&utm_medium=amp&utm_campaign=speakable
     * urlToImage : https://www.gannett-cdn.com/-mm-/e937d32fb31bfc7a1b9df21c3dd2f3bc5bdbef22/c=0-266-1534-1133/local/-/media/2018/08/05/USATODAY/USATODAY/636690836023040486-Dj3D32qVsAEruOM.jpg-large.jpg?width=3200&height=1680&fit=crop
     * publishedAt : 2018-08-06T11:45:22+00:00
     */

    @SerializedName("source")
    private SourceBean source;
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    private String publishedAt;

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
