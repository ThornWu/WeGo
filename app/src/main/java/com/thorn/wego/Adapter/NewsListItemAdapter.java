package com.thorn.wego.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.Element.NewsListItem;
import com.thorn.wego.News.Presenter.INewsListPresenter;
import com.thorn.wego.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsListItemAdapter extends BaseAdapter {
    INewsListPresenter iNewsListPresenter;
    List<NewsListItem> datas;

    public NewsListItemAdapter(INewsListPresenter iNewsListPresenter){
        this.iNewsListPresenter = iNewsListPresenter;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<NewsListItem> datas){
        this.datas.clear();
        if(datas!=null && datas.size()>0){
            this.datas.addAll(datas);
        }
    }

    @Override
    public int getCount(){return datas.size();}

    @Override
    public NewsListItem getItem(int position){return datas.get(position);}

    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        NewsListItem newsListItem = (NewsListItem) getItem(position); //获取当前项的 ListItem 实例
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false); // 实例化一个对象
        TextView newsTitle = (TextView) view.findViewById(R.id.news_item_title);
        TextView newsSource = (TextView) view.findViewById(R.id.news_item_source);
        TextView newsPublishtime = (TextView) view.findViewById(R.id.news_item_publishtime);

        newsTitle.setText(String.valueOf(newsListItem.getTitle()));
        newsSource.setText(newsListItem.getSource().getName());
        try{
            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("MM-dd HH:mm");
            Date date = null;
            date = (Date) sdfInput.parse(newsListItem.getPublishedAt());
            newsPublishtime.setText(sdfOutput.format(date));
        }catch (Exception e){
            e.printStackTrace();
        }



        return view;
    }
}
