package com.thorn.wego.Login.Model;

public interface IUser {
    void setUsername(String username);
    void setPassword(String password);
    String getUsername();
    String getPassword();
    String getLoginText();
    String getLoginCode();
    int checkUser(String url);
}

