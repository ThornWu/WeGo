package com.thorn.wego.News.Model;

import com.thorn.wego.Element.NewsListItem;

import java.util.List;

public interface INewsList {
    List<NewsListItem> getNewsList(String url);
}
