package com.thorn.wego.PositionDetail.Model;

import com.google.gson.Gson;
import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.PositionDetailJson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PositionInfo implements IPositionInfo{
    private PositionDetailJson positionDetailJson = new PositionDetailJson();
    private BasicNetworkJson basicNetworkJson = new BasicNetworkJson();

    @Override
    public PositionDetailJson getPositionDetail(String url){
        sendRequest(url);
        return positionDetailJson;
    }

    @Override
    public BasicNetworkJson doOperation(String url){
        signAndFavorite(url);
        return basicNetworkJson;
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
                        positionDetailJson = (PositionDetailJson) new Gson().fromJson(response.toString(),PositionDetailJson.class);

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

    private void signAndFavorite(final String url){
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
