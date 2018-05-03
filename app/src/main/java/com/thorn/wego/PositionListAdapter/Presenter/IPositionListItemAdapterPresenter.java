package com.thorn.wego.PositionListAdapter.Presenter;

import android.app.Activity;

public interface IPositionListItemAdapterPresenter {
    public void loadDatas(String keyword,String url);
    public Activity getActivity();
}
