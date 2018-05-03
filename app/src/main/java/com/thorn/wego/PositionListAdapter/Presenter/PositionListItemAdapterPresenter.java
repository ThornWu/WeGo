package com.thorn.wego.PositionListAdapter.Presenter;

import android.app.Activity;

import com.google.gson.Gson;
import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Element.PositionListJson;
import com.thorn.wego.PositionListAdapter.View.IPositionListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PositionListItemAdapterPresenter implements IPositionListItemAdapterPresenter {
    List<PositionListItem> datas = new ArrayList<PositionListItem>();
    IPositionListView iPositionListView;
    private PositionListJson positionListJson = new PositionListJson();

    public PositionListItemAdapterPresenter (IPositionListView iPositionListView){
        this.iPositionListView = iPositionListView;
    }

    @Override
    public void loadDatas(String keyword,String url){
        String format_url = url + "?keyword=" + keyword;
        sendRequest(format_url);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                iPositionListView.onGetDataList(datas);
            }
        });
        thread.start();
    }

    @Override
    public Activity getActivity(){
        return iPositionListView.onGetActivity();
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
                        positionListJson = (PositionListJson) new Gson().fromJson(response.toString(),PositionListJson.class);
                        List<PositionListItem> lists = positionListJson.getResult();

                        for(PositionListItem item: lists){
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
