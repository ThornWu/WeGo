package com.thorn.wego.Life.News.Presenter;

import android.app.Activity;

import com.thorn.wego.Element.NewsListItem;
import com.thorn.wego.Life.News.Model.INewsList;
import com.thorn.wego.Life.News.Model.NewsList;
import com.thorn.wego.Life.News.View.INewsListView;

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
