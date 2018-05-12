package com.thorn.wego.UserListAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.thorn.wego.Element.UserListItem;
import com.thorn.wego.R;
import com.thorn.wego.UserHome.UserHomeActivity;
import com.thorn.wego.UserListAdapter.Adapter.UserListItemAdapter;
import com.thorn.wego.UserListAdapter.Presenter.IUserListAdapterPresenter;
import com.thorn.wego.UserListAdapter.Presenter.UserListAdapterPresenter;
import com.thorn.wego.UserListAdapter.View.IUserListView;

import java.util.List;

public class UserListActivity extends AppCompatActivity implements IUserListView, AdapterView.OnItemClickListener{
    private ListView userList;
    private RelativeLayout userListSearchArea;
    private EditText userListSearchText;
    private Button userListSearchButton;
    private IUserListAdapterPresenter iUserListAdapterPresenter;
    private UserListItemAdapter userListItemAdapter;
    private String userListUrl;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        userListSearchArea =(RelativeLayout) findViewById(R.id.userlist_search_area);
        userList = (ListView) findViewById(R.id.userlist_view);
        userListSearchText = (EditText) findViewById(R.id.userlist_search_text);
        userListSearchButton = (Button) findViewById(R.id.userlist_search_submit);
        userList.setOnItemClickListener(this);

        iUserListAdapterPresenter = new UserListAdapterPresenter(this);

        userListItemAdapter = new UserListItemAdapter(iUserListAdapterPresenter);
        userList.setAdapter(userListItemAdapter);

        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String action = getIntent().getExtras().get("action").toString();
        String targetUser = getIntent().getExtras().get("userid").toString();

        if(action.equals("followers")){
            userListSearchArea.setVisibility(View.GONE);
        }

        if(targetUser!="" && action!=""){
            userListUrl = getResources().getString(R.string.service_url) + "friendlist" + "?userid=" + targetUser + "&action=" + action;
            iUserListAdapterPresenter.loadDatas(userListUrl);
        }
        userListSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userListSearchText.getText().length()!=0){
                    userListUrl = getResources().getString(R.string.service_url) + "searchfriend" + "?keyword=" + userListSearchText.getText();
                    iUserListAdapterPresenter.loadDatas(userListUrl);
                }
            }
        });
    }

    @Override
    public void onGetDataList(List<UserListItem> datas){
        userListItemAdapter.setDatas(datas);
    }

    @Override
    public Activity onGetActivity(){return this;}


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent intent = new Intent(this, UserHomeActivity.class);
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        intent.putExtra("currentuser",sp.getString("userid",""));
        intent.putExtra("targetuser", String.valueOf(userListItemAdapter.getItem(position).getUserid()));
        startActivity(intent);
    }
}
