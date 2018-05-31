package com.thorn.wego.User.UserHome.Model;

import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.UserHomeJson;

public interface IUserHomeModel {
    UserHomeJson getUserHome(String url);
    BasicNetworkJson manageFriend(String url);
}
