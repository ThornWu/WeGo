package com.thorn.wego.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Location.PositionList.Presenter.IPositionListPresenter;
import com.thorn.wego.R;

import java.text.SimpleDateFormat;
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
        TextView positionAddition = (TextView) view.findViewById(R.id.position_list_addition);

        positionId.setText(String.valueOf(positionItem.getVenueid()));
        positionName.setText(positionItem.getVenuename());
        positionAddress.setText(positionItem.getAddress());
        positionCategory.setText(positionItem.getCategory());

        // 判断有没有 distance 字段
        if(positionItem.getDistance()!=0){
            // 判断 distance 字符是否异常
            if(positionItem.getDistance()>0){
                Double distance = (double) Math.round(positionItem.getDistance()*100)/100;
                String text = distance.toString() + "KM";
                positionAddition.setText(text);
            }
        }else{
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long time= Math.round(positionItem.getCreatetime()*1000);
            String d = format.format(time);
            System.out.println("Format To String(Date):"+d);
            positionAddition.setText(d);
        }

        return view;
    }
}
