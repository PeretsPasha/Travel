package com.example.travel.models;

public class News {

    String newsTitle, news;

    public News(String newsTitle, String news) {
        this.newsTitle = newsTitle;
        this.news = news;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNews() {
        return news;
    }
}
