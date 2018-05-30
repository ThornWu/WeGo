package com.thorn.wego.Life.News.Model;

import com.google.gson.Gson;
import com.thorn.wego.Element.NewsListItem;
import com.thorn.wego.Element.NewsListJson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsList implements INewsList{
    List<NewsListItem> datas = new ArrayList<NewsListItem>();
    private NewsListJson newsListJson = new NewsListJson();

    public List<NewsListItem> getNewsList(String url){
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
                        newsListJson = (NewsListJson) new Gson().fromJson(response.toString(),NewsListJson.class);
                        List<NewsListItem> lists = newsListJson.getArticles();

                        datas.clear();
                        for(NewsListItem item: lists){
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
