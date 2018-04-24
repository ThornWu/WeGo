package com.thorn.wego.Register.Model;

public interface IRegUser {
    void setUsername(String username);
    void setPassword(String password);
    void setRepeat(String repeat);
    void setEmail(String email);
    String getUsername();
    String getPassword();
    String getRepeat();
    String getEmail();
    String getRegisterText();
    String getRegisterCode();
    int handleRegister(String url);
}
