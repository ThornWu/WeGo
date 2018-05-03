package com.thorn.wego.PositionListAdapter.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.thorn.wego.Element.PositionItem;
import com.thorn.wego.PositionListAdapter.Presenter.IPositionListItemAdapterPresenter;
import com.thorn.wego.R;

import java.util.ArrayList;
import java.util.List;

public class PositionListItemAdapter extends BaseAdapter{
    IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter;
    List<PositionItem> datas;

    public PositionListItemAdapter(IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter){
        this.iPositionListItemAdapterPresenter = iPositionListItemAdapterPresenter;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<PositionItem> datas){
        if(datas!=null && datas.size()>0){
            this.datas.clear();
            this.datas.addAll(datas);
        }
        //TODO: 列表为空时的处理
    }

    @Override
    public int getCount(){return datas.size();}

    @Override
    public PositionItem getItem(int position){return datas.get(position);}

    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.position_list_item, parent, false);
        }
        return convertView;
    }
}
