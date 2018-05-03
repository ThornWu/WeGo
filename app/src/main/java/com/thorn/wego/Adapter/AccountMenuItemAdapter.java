package com.thorn.wego.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.thorn.wego.Element.MenuItem;
import com.thorn.wego.R;

import java.util.List;

public class AccountMenuItemAdapter extends ArrayAdapter {
    private final int resourceId;

    public AccountMenuItemAdapter(Context context, int textViewResourceId, List<MenuItem> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        MenuItem menuItem = (MenuItem) getItem(position); //获取当前项的 ListItem 实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null); // 实例化一个对象
        TextView menuName = (TextView) view.findViewById(R.id.account_menu_name);
        menuName.setText(menuItem.getMenuName());
        return view;
    }
}

