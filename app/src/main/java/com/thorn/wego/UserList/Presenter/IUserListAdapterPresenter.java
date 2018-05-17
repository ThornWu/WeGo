package com.thorn.wego.UserList.Presenter;

import android.app.Activity;

public interface IUserListAdapterPresenter {
    public void loadDatas(String url);
    public Activity getActivity();
}
