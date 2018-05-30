package com.thorn.wego.UserList.Model;

import com.thorn.wego.Element.UserListItem;

import java.util.List;

public interface IUserListModel {
    List<UserListItem> getUserList(String url);
}
