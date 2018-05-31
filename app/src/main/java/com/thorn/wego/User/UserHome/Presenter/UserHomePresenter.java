package com.thorn.wego.User.UserHome.Presenter;

import android.app.Activity;

import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.UserHomeJson;
import com.thorn.wego.User.UserHome.Model.IUserHomeModel;
import com.thorn.wego.User.UserHome.Model.UserHomeModel;
import com.thorn.wego.User.UserHome.View.IUserHomeView;

public class UserHomePresenter implements IUserHomePresenter {
    private UserHomeJson userHomeJson;
    private BasicNetworkJson basicNetworkJson;
    private IUserHomeModel iUserHomeModel;
    private IUserHomeView iUserHomeView;

    public UserHomePresenter (IUserHomeView iUserHomeView){
        this.iUserHomeView = iUserHomeView;
        iUserHomeModel = new UserHomeModel();
    }


    @Override
    public UserHomeJson getUserHome(String url){
        userHomeJson = iUserHomeModel.getUserHome(url);
        return userHomeJson;
    }

    @Override
    public BasicNetworkJson manageFriend(String url){
        basicNetworkJson = iUserHomeModel.manageFriend(url);
        return basicNetworkJson;
    }

    @Override
    public Activity getActivity(){
        return iUserHomeView.onGetActivity();
    }
}
