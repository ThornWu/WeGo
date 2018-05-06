package com.thorn.wego.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.thorn.wego.Adapter.AccountMenuItemAdapter;
import com.thorn.wego.Element.MenuItem;
import com.thorn.wego.Login.LoginActivity;
import com.thorn.wego.PositionListAdapter.PositionListActivity;
import com.thorn.wego.R;
import com.thorn.wego.Register.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {
    private View rootView;
    private List<MenuItem> menuItems;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(null == rootView){
            rootView = inflater.inflate(R.layout.account_fragment,container,false);
            initView(rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if(null != parent){
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View view){
        listView = (ListView) rootView.findViewById(R.id.account_list);

        menuItems = new ArrayList<MenuItem>();

        menuItems.add(new MenuItem("History"));
        menuItems.add(new MenuItem("Favorite"));
        menuItems.add(new MenuItem("Register"));
        menuItems.add(new MenuItem("Log In"));
        menuItems.add(new MenuItem("Log Out"));

        AccountMenuItemAdapter adapter = new AccountMenuItemAdapter(getContext(),R.layout.account_menu_item,menuItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ListItem listItem = listItems.get(position);
                if(menuItems.get(position).getMenuName().equals("Register")){
                    Intent intent = new Intent(AccountFragment.this.getActivity(), RegisterActivity.class);
                    startActivity(intent);
                }else if(menuItems.get(position).getMenuName().equals("Log In")){
                    Intent intent = new Intent(AccountFragment.this.getActivity(), LoginActivity.class);
                    startActivity(intent);
                }else if(menuItems.get(position).getMenuName().equals("Log Out")){
                    Toast.makeText(getContext(), "Log Out", Toast.LENGTH_SHORT).show();
                }else if(menuItems.get(position).getMenuName().equals("History")){
                    Intent intent = new Intent(AccountFragment.this.getActivity(), PositionListActivity.class);
                    //TODO: Userid 动态化
                    intent.putExtra("userid","32");
                    intent.putExtra("function","history");
                    intent.putExtra("searcharea","false");
                    startActivity(intent);
                }else if(menuItems.get(position).getMenuName().equals("Favorite")){
                    Intent intent = new Intent(AccountFragment.this.getActivity(), PositionListActivity.class);
                    //TODO: Userid 动态化
                    intent.putExtra("userid","32");
                    intent.putExtra("function","favorite");
                    intent.putExtra("searcharea","false");
                    startActivity(intent);
                }else{
                    //TODO: Favorite, History 去重复用 PositionList(加上 ExtraData 区分)

                }
            }
        });
    }
}