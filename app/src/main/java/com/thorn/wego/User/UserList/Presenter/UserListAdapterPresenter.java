package com.thorn.wego.User.UserList.Presenter;

import android.app.Activity;

import com.thorn.wego.Element.UserListItem;
import com.thorn.wego.User.UserList.Model.IUserListModel;
import com.thorn.wego.User.UserList.Model.UserListModel;
import com.thorn.wego.User.UserList.View.IUserListView;

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
