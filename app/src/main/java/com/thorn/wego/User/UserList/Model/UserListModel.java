package com.thorn.wego.User.UserList.Model;

import com.google.gson.Gson;
import com.thorn.wego.Element.UserListItem;
import com.thorn.wego.Element.UserListJson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserListModel implements IUserListModel {
    private List<UserListItem> datas = new ArrayList<UserListItem>();
    private UserListJson userListJson = new UserListJson();

    public List<UserListItem> getUserList(String url){
        sendRequest(url);
        return datas;
    }

    private void sendRequest(final String url){
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection = null;
                    try{

                        URL format_url = new URL(url);
                        connection = (HttpURLConnection) format_url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(5000);

                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        userListJson = (UserListJson) new Gson().fromJson(response.toString(),UserListJson.class);
                        List<UserListItem> lists = userListJson.getResult();

                        datas.clear();
                        for(UserListItem item: lists){
                            datas.add(item);
                        }

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
