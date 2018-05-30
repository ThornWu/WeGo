package com.thorn.wego.News.Presenter;

import android.app.Activity;

import com.google.gson.Gson;
import com.thorn.wego.Element.NewsListItem;
import com.thorn.wego.Element.NewsListJson;
import com.thorn.wego.News.Model.INewsList;
import com.thorn.wego.News.Model.NewsList;
import com.thorn.wego.News.View.INewsListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsListPresenter implements INewsListPresenter{
    private List<NewsListItem> datas;
    private INewsListView iNewsListView;
    private INewsList iNewsList;

    public NewsListPresenter (INewsListView iNewsListView){
        this.iNewsListView = iNewsListView;
        iNewsList = new NewsList();
    }

    @Override
    public void loadDatas(String url){
        datas = iNewsList.getNewsList(url);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                iNewsListView.onGetDataList(datas);
            }
        });
        thread.start();
    }

    @Override
    public Activity getActivity(){
        return iNewsListView.onGetActivity();
    }


}
