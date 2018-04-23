package com.thorn.wego.Register.Model;

import com.thorn.wego.JsonObject.BasicNetworkJson;

public class RegUser implements IRegUser {
    private String username;
    private String password;
    private String email;
    private BasicNetworkJson basicNetworkJson = new BasicNetworkJson();

    public RegUser(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public void setUsername(String username){this.username = username;}

    @Override
    public void setPassword(String password){this.password = password;}

    @Override
    public void setEmail(String email){this.email = email;}

    @Override
    public String getUsername(){return username;}

    @Override
    public String getPassword(){return password;}

    @Override
    public String getEmail(){return email;}

    @Override
    public String getRegisterCode(){return basicNetworkJson.getCode();}

    @Override
    public String getRegisterText(){return basicNetworkJson.getText();}

    @Override
    public int checkPassword(String repeat){
        return 0;
    }

    @Override
    public int doRegister(){
        return 0;
    }
}
