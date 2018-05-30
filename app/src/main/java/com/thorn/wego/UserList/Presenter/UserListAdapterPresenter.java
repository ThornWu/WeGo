package com.thorn.wego.UserList.Presenter;

import android.app.Activity;

import com.google.gson.Gson;
import com.thorn.wego.Element.UserListItem;
import com.thorn.wego.Element.UserListJson;
import com.thorn.wego.UserList.Model.IUserListModel;
import com.thorn.wego.UserList.Model.UserListModel;
import com.thorn.wego.UserList.View.IUserListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserListAdapterPresenter implements IUserListAdapterPresenter {
    List<UserListItem> datas;
    IUserListView iUserListView;
    IUserListModel iUserListModel;

    public UserListAdapterPresenter (IUserListView iUserListView){
        this.iUserListView = iUserListView;
        iUserListModel = new UserListModel();
    }

    @Override
    public void loadDatas(String url){
        datas = iUserListModel.getUserList(url);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                iUserListView.onGetDataList(datas);
            }
        });
        thread.start();
    }

    @Override
    public Activity getActivity(){
        return iUserListView.onGetActivity();
    }


}
