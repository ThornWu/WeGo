package com.thorn.wego.Login.Model;

import com.google.gson.Gson;
import com.thorn.wego.JsonObject.BasicNetworkJson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LoginUser implements ILoginUser {
    private String username;
    private String password;
    private BasicNetworkJson basicNetworkJson = new BasicNetworkJson();

    public LoginUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public void setUsername(String username){ this.username = username;}

    @Override
    public void setPassword(String password){ this.password = password;}

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getLoginText(){ return basicNetworkJson.getText();}

    @Override
    public String getLoginCode(){ return basicNetworkJson.getCode();}

    @Override
    public int checkUser(String url){
        if(getUsername() == null || getPassword() == null || getUsername().length() == 0 || getPassword().length() == 0){
            return -1;
        }else{
            sendRequest(getUsername(), getPassword(),url);
            return 0;
        }
    }

    private void sendRequest(final String username, final String password, final String url){
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection = null;
                    try{

                        URL format_url = new URL(url);
                        connection = (HttpURLConnection) format_url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setConnectTimeout(5000);
                        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        String data = "username="+ URLEncoder.encode(username,"utf-8")+"&password=" + URLEncoder.encode(password,"utf-8");
                        connection.setRequestProperty("Content-Length",String.valueOf(data.length()));
                        connection.setDoOutput(true);
                        connection.getOutputStream().write(data.getBytes());

                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        basicNetworkJson = (BasicNetworkJson) new Gson().fromJson(response.toString(),BasicNetworkJson.class);

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        if(connection != null){ connection.disconnect(); }
                    }
                }
            });
            thread.start();
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
