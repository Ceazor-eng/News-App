package com.example.newsapp;

import java.util.ArrayList;

public class NewsModel {
    public int totalResults;
    public String status;
    public ArrayList<Articles> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "totalResults=" + totalResults +
                ", status='" + status + '\'' +
                ", articles=" + articles +
                '}';
    }
}
