package com.thorn.wego.Element;

import java.util.List;

public class NewsListJson {
    private String status;
    private int totalResults;
    private List<NewsListItem> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsListItem> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsListItem> articles) {
        this.articles = articles;
    }

}
