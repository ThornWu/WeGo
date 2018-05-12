package com.thorn.wego.News.Presenter;

import android.app.Activity;

public interface INewsListPresenter {
    public void loadDatas(String url);
    public Activity getActivity();
}
