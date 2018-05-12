package com.thorn.wego.News.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.Element.NewsListItem;
import com.thorn.wego.News.Presenter.INewsListPresenter;
import com.thorn.wego.R;

import java.util.ArrayList;
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
        TextView newsDescription = (TextView) view.findViewById(R.id.news_item_description);
        TextView newsPublishtime = (TextView) view.findViewById(R.id.news_item_publishtime);

        newsTitle.setText(String.valueOf(newsListItem.getTitle()));
        newsDescription.setText(newsListItem.getDescription());
        newsPublishtime.setText(newsListItem.getPublishedAt());

        return view;
    }
}
