package com.thorn.wego.Register.Model;

import com.google.gson.Gson;
import com.thorn.wego.Element.BasicNetworkJson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RegUser implements IRegUser {
    private String username;
    private String password;
    private String repeat;
    private String email;
    private BasicNetworkJson basicNetworkJson = new BasicNetworkJson();

    public RegUser(String username, String password, String repeat, String email){
        this.username = username;
        this.password = password;
        this.repeat = repeat;
        this.email = email;
    }

    @Override
    public void setUsername(String username){this.username = username;}

    @Override
    public void setPassword(String password){this.password = password;}

    @Override
    public void setRepeat(String repeat){this.repeat = repeat;}

    @Override
    public void setEmail(String email){this.email = email;}

    @Override
    public String getUsername(){return username;}

    @Override
    public String getPassword(){return password;}

    @Override
    public String getRepeat(){return repeat;}

    @Override
    public String getEmail(){return email;}

    @Override
    public String getRegisterCode(){return basicNetworkJson.getCode();}

    @Override
    public String getRegisterText(){return basicNetworkJson.getText();}

    @Override
    public int handleRegister(String url){
        if(getUsername() == null || getUsername().length() == 0){
            basicNetworkJson.setText("Please enter your username");
            basicNetworkJson.setCode("Error");
            return -1;
        }else if(getPassword() == null || getPassword().length() == 0){
            basicNetworkJson.setText("Please enter your password");
            basicNetworkJson.setCode("Error");
            return -1;
        }else if(getRepeat() == null || getRepeat().length() == 0){
            basicNetworkJson.setText("Please repeat your password");
            basicNetworkJson.setCode("Error");
            return -1;
        }else if(getEmail() == null || getEmail().length() == 0){
            basicNetworkJson.setText("Please enter your email");
            basicNetworkJson.setCode("Error");
            return -1;
        }else if(!getPassword().equals(getRepeat())){
            basicNetworkJson.setText("Password and repeat are different");
            basicNetworkJson.setCode("Error");
            return -1;
        } else{
            sendRequest(getUsername(), getPassword(), getEmail(), url);
            return 0;
        }
    }

    private void sendRequest(final String username, final String password, final String email, final String url){
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
                        String data = "username="+ URLEncoder.encode(username,"utf-8")+"&password=" +
                                URLEncoder.encode(password,"utf-8")+"&email=" + URLEncoder.encode(email,"utf-8");
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
