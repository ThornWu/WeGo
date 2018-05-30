package com.thorn.wego.PositionList.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.PositionList.Presenter.IPositionListPresenter;
import com.thorn.wego.R;

import java.util.ArrayList;
import java.util.List;

public class PositionListItemAdapter extends BaseAdapter{
    IPositionListPresenter iPositionListPresenter;
    List<PositionListItem> datas;

    public PositionListItemAdapter(IPositionListPresenter iPositionListPresenter){
        this.iPositionListPresenter = iPositionListPresenter;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<PositionListItem> datas){
        this.datas.clear();
        if(datas!=null && datas.size()>0){
            this.datas.addAll(datas);
        }
    }

    @Override
    public int getCount(){return datas.size();}

    @Override
    public PositionListItem getItem(int position){return datas.get(position);}

    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        PositionListItem positionItem = (PositionListItem) getItem(position); //获取当前项的 ListItem 实例
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.position_list_item, parent, false); // 实例化一个对象
        TextView positionId = (TextView) view.findViewById(R.id.position_list_id);
        ImageView positinImage = (ImageView) view.findViewById(R.id.position_list_pic);
        TextView positionName = (TextView) view.findViewById(R.id.position_list_name);
        TextView positionAddress = (TextView) view.findViewById(R.id.position_list_address);
        TextView positionCategory = (TextView) view.findViewById(R.id.position_list_category);

        positionId.setText(String.valueOf(positionItem.getVenueid()));
        positionName.setText(positionItem.getVenuename());
        positionAddress.setText(positionItem.getAddress());
        positionCategory.setText(positionItem.getCategory());

        return view;
    }
}
