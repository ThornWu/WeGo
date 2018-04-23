package com.thorn.wego.Register.Model;

public interface IRegUser {
    void setUsername(String username);
    void setPassword(String password);
    void setEmail(String email);
    String getUsername();
    String getPassword();
    String getEmail();
    String getRegisterText();
    String getRegisterCode();
    int checkPassword(String repeat);
    int doRegister();
}
