package com.thorn.wego.PositionListAdapter.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.PositionListAdapter.Presenter.IPositionListItemAdapterPresenter;
import com.thorn.wego.R;

import java.util.ArrayList;
import java.util.List;

public class PositionListItemAdapter extends BaseAdapter{
    IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter;
    List<PositionListItem> datas;

    public PositionListItemAdapter(IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter){
        this.iPositionListItemAdapterPresenter = iPositionListItemAdapterPresenter;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<PositionListItem> datas){
        if(datas!=null && datas.size()>0){
            this.datas.clear();
            this.datas.addAll(datas);
        }
        //TODO: 列表为空时的处理
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
