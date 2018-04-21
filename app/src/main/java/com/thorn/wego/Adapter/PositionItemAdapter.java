package com.thorn.wego.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.Element.PositionItem;
import com.thorn.wego.R;

import java.util.List;

public class PositionItemAdapter extends ArrayAdapter {
    private final int resourceId;

    public PositionItemAdapter(Context context, int textViewResourceId, List<PositionItem> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        PositionItem positionItem = (PositionItem) getItem(position); //获取当前项的 ListItem 实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null); // 实例化一个对象
        TextView positionId = (TextView) view.findViewById(R.id.position_list_id);
        ImageView positinImage = (ImageView) view.findViewById(R.id.position_list_pic);
        TextView positionName = (TextView) view.findViewById(R.id.position_list_name);
        TextView positionAddress = (TextView) view.findViewById(R.id.position_list_address);
        TextView positionCategory = (TextView) view.findViewById(R.id.position_list_category);

        positionId.setText(String.valueOf(positionItem.getpId()));
        positinImage.setImageResource(positionItem.getpicId());
        positionName.setText(positionItem.getpName());
        positionAddress.setText(positionItem.getpAddress());
        positionCategory.setText(positionItem.getpCategory());

        return view;
    }
}
