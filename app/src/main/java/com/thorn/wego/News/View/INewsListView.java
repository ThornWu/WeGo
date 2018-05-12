package com.thorn.wego.News.View;

import android.app.Activity;

import com.thorn.wego.Element.NewsListItem;

import java.util.List;

public interface INewsListView {
    public void onGetDataList(List<NewsListItem> datas);
    public Activity onGetActivity();
}
