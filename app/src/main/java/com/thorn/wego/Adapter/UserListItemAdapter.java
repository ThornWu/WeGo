package com.thorn.wego.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thorn.wego.Element.UserListItem;
import com.thorn.wego.R;
import com.thorn.wego.UserList.Presenter.IUserListAdapterPresenter;

import java.util.ArrayList;
import java.util.List;

public class UserListItemAdapter extends BaseAdapter {
    IUserListAdapterPresenter iUserListAdapterPresenter;
    List<UserListItem> datas;

    public UserListItemAdapter(IUserListAdapterPresenter iUserListAdapterPresenter){
        this.iUserListAdapterPresenter = iUserListAdapterPresenter;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<UserListItem> datas){
        this.datas.clear();
        if(datas!=null && datas.size()>0){
            this.datas.addAll(datas);
        }
    }

    @Override
    public int getCount(){return datas.size();}

    @Override
    public UserListItem getItem(int position){return datas.get(position);}

    @Override
    public long getItemId(int position){return position;}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        UserListItem userItem = (UserListItem) getItem(position); //获取当前项的 ListItem 实例
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        TextView userId = (TextView) view.findViewById(R.id.useritem_userid);
        TextView userName = (TextView) view.findViewById(R.id.useritem_username);
        TextView userCity = (TextView) view.findViewById(R.id.useritem_city);
        TextView userGender = (TextView) view.findViewById(R.id.useritem_gender);

        userId.setText(String.valueOf(userItem.getUserid()));
        userName.setText(userItem.getUsername());
        userCity.setText(userItem.getHomecity());
        userGender.setText(userItem.getGender());

        return view;
    }
}
