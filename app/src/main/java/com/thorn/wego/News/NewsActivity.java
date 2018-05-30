package com.thorn.wego.News;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.thorn.wego.Element.NewsListItem;
import com.thorn.wego.Element.NewsListJson;
import com.thorn.wego.Adapter.NewsListItemAdapter;
import com.thorn.wego.News.Presenter.INewsListPresenter;
import com.thorn.wego.News.Presenter.NewsListPresenter;
import com.thorn.wego.News.View.INewsListView;
import com.thorn.wego.R;

import java.util.List;

public class NewsActivity extends AppCompatActivity implements INewsListView, AdapterView.OnItemClickListener {
    private TextView newsProvider;
    private ListView newsList;
    private String newsUrl;
    private NewsListJson newsListJson = new NewsListJson();
    private SharedPreferences sp;
    private INewsListPresenter iNewsListPresenter;
    private NewsListItemAdapter newsListItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list);
        newsProvider = (TextView) findViewById(R.id.news_list_provider);
        newsList = (ListView) findViewById(R.id.news_list_view);
        newsUrl = getResources().getString(R.string.news_url) +
                "?apiKey=" + getResources().getString(R.string.news_key) + "&country=us";

        newsList.setOnItemClickListener(this);

        iNewsListPresenter = new NewsListPresenter(this);

        newsListItemAdapter = new NewsListItemAdapter(iNewsListPresenter);
        newsList.setAdapter(newsListItemAdapter);

        iNewsListPresenter.loadDatas(newsUrl);
        newsProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this, NewsDetailActivity.class);
                intent.putExtra("newsurl", "https://newsapi.org/");//给intent添加额外数据
                startActivity(intent);
            }
        });

    }


    @Override
    public void onGetDataList(List<NewsListItem> datas){
        newsListItemAdapter.setDatas(datas);
    }

    @Override
    public Activity onGetActivity(){return this;}


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent intent = new Intent(NewsActivity.this, NewsDetailActivity.class);
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        intent.putExtra("newsurl", String.valueOf(newsListItemAdapter.getItem(position).getUrl()));//给intent添加额外数据
        startActivity(intent);
    }


}
