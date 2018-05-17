package com.thorn.wego.UserListAdapter.View;

import android.app.Activity;

import com.thorn.wego.Element.UserListItem;

import java.util.List;

public interface IUserListView {
    public void onGetDataList(List<UserListItem> datas);
    public Activity onGetActivity();
}