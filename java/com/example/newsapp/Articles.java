package com.example.newsapp;

import java.util.ArrayList;

public class Articles {
    private String title,description,url,content,urlToImage,publishedAt;
    private ArrayList<Articles> articles;


    @Override
    public String toString() {
        return "Articles{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }

    public Articles(String title, String description, String url, String content, String urlToImage, String publishedAt) {

            this.title = title;
            this.description = description;
            this.url = url;
            this.content = content;
            this.urlToImage = urlToImage;
            this.publishedAt = publishedAt;



        }


    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt= publishedAt;
    }


    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

}
