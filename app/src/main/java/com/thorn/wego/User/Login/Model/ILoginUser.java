package com.thorn.wego.User.Login.Model;

public interface ILoginUser {
    void setUsername(String username);
    void setPassword(String password);
    String getUsername();
    String getPassword();
    String getLoginText();
    String getLoginCode();
    long getUserId();
    int checkUser(String url);
}

