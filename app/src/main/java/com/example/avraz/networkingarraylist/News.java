package com.example.avraz.networkingarraylist;

public class News {
    private  String author;
    private  String title;
    private  String image;
    private String description;
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public News(String author, String title, String image, String description) {
        this.author = author;
        this.title = title;
        this.image = image;
        this.description = description;
    }

}
