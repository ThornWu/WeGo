package com.thorn.wego.User.UserHome.Presenter;

import android.app.Activity;

import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.UserHomeJson;

public interface IUserHomePresenter {
    UserHomeJson getUserHome(String url);
    BasicNetworkJson manageFriend(String url);
    Activity getActivity();
}
