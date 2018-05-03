package com.thorn.wego.PositionDetail.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.R;

import java.util.LinkedList;

public class PositionDetailIconAdapter extends BaseAdapter {
    private Context context;
    private LinkedList<ImageTextIcon> imageTextIconList;

    public PositionDetailIconAdapter(Context context, LinkedList<ImageTextIcon> imageTextIconList){
        super();
        this.imageTextIconList = imageTextIconList;
        this.context = context;
    }

    @Override
    public int getCount(){
        return imageTextIconList.size();
    }

    @Override
    public Object getItem(int postition){
        return imageTextIconList.get(postition);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.position_detail_icon, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.position_detail_icon);
            holder.textView = (TextView) convertView.findViewById(R.id.position_detail_text);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setBackgroundResource(imageTextIconList.get(position).getIconId());
        holder.textView.setText(imageTextIconList.get(position).getIconName());
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
