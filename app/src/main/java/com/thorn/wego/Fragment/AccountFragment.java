package com.thorn.wego.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.thorn.wego.Adapter.AccountMenuItemAdapter;
import com.thorn.wego.Element.MenuItem;
import com.thorn.wego.Login.LoginActivity;
import com.thorn.wego.PositionList.FavoriteListActivity;
import com.thorn.wego.PositionList.HistoryListAcitivity;
import com.thorn.wego.R;
import com.thorn.wego.UserHome.UserHomeActivity;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {
    private View rootView;
    private List<MenuItem> menuItems;
    private ListView listView;
    private TextView nickname;
    private ImageView accountAvater;
    private SharedPreferences sp;

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
        nickname = (TextView) rootView.findViewById(R.id.account_nickname);
        accountAvater = (ImageView) rootView.findViewById(R.id.account_avater);

        sp = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        nickname.setText(sp.getString("username",""));

        menuItems = new ArrayList<MenuItem>();

        menuItems.add(new MenuItem("History"));
        menuItems.add(new MenuItem("Favorite"));
        menuItems.add(new MenuItem("Log Out"));

        AccountMenuItemAdapter adapter = new AccountMenuItemAdapter(getContext(),R.layout.account_menu_item,menuItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(menuItems.get(position).getMenuName().equals("Log Out")){
                    sp = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.remove("userid");
                    editor.commit();
                    Toast.makeText(getContext(), "Log Out", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else if(menuItems.get(position).getMenuName().equals("History")){
                    Intent intent = new Intent(AccountFragment.this.getActivity(), HistoryListAcitivity.class);
                    startActivity(intent);
                }else if(menuItems.get(position).getMenuName().equals("Favorite")){
                    Intent intent = new Intent(AccountFragment.this.getActivity(), FavoriteListActivity.class);
                    startActivity(intent);
                }
            }
        });
        accountAvater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserHomeActivity.class);
                sp = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
                intent.putExtra("currentuser",sp.getString("userid",""));
                intent.putExtra("targetuser",sp.getString("userid",""));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden){
        if(!hidden){
            sp = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
            nickname.setText(sp.getString("username",""));
        }
    }
}