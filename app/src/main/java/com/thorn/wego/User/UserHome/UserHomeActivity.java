package com.thorn.wego.User.UserHome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Element.UserHomeJson;
import com.thorn.wego.Location.PositionDetail.PositionDetailActivity;
import com.thorn.wego.Adapter.PositionListItemAdapter;
import com.thorn.wego.Location.PositionList.Presenter.IPositionListPresenter;
import com.thorn.wego.Location.PositionList.Presenter.PositionListPresenter;
import com.thorn.wego.Location.PositionList.View.IPositionListView;
import com.thorn.wego.R;
import com.thorn.wego.User.UserHome.Presenter.IUserHomePresenter;
import com.thorn.wego.User.UserHome.Presenter.UserHomePresenter;
import com.thorn.wego.User.UserHome.View.IUserHomeView;
import com.thorn.wego.User.UserList.UserListActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UserHomeActivity extends Activity implements IPositionListView, AdapterView.OnItemClickListener, IUserHomeView {
    private TextView userHomeNickname, userHomeCity, userHomeGender, userHomeFollowing, userHomeFollowers, userHomeAddFriend;
    private ListView historyList;
    private String currentUserId, targetUserId, userHomeUrl, addFriendUrl;
    private RelativeLayout followersArea, followingArea;
    private SharedPreferences sp;
    private IPositionListPresenter iPositionListPresenter;
    private PositionListItemAdapter historyListAdapter;
    private Boolean isFriend = Boolean.FALSE;
    private IUserHomePresenter iUserHomePresenter;
    private BasicNetworkJson basicNetworkJson;
    private UserHomeJson userHomeJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        userHomeNickname = (TextView) findViewById(R.id.userhome_nickname);
        userHomeCity = (TextView) findViewById(R.id.userhome_city);
        userHomeGender = (TextView) findViewById(R.id.userhome_gender);
        userHomeFollowing = (TextView) findViewById(R.id.userhome_following_text);
        userHomeFollowers = (TextView) findViewById(R.id.userhome_followers_text);
        userHomeAddFriend = (TextView) findViewById(R.id.userhome_add_friend);
        followersArea =(RelativeLayout) findViewById(R.id.userhome_followers_area);
        followingArea = (RelativeLayout) findViewById(R.id.userhome_following_area);

        historyList = (ListView) findViewById(R.id.userhome_history);
        historyList.setOnItemClickListener(this);

        iPositionListPresenter = new PositionListPresenter(this);
        iUserHomePresenter = new UserHomePresenter(this);

        historyListAdapter = new PositionListItemAdapter(iPositionListPresenter);
        historyList.setAdapter(historyListAdapter);


        currentUserId = getIntent().getExtras().get("currentuser").toString();
        targetUserId = getIntent().getExtras().get("targetuser").toString();

        if(currentUserId.equals(targetUserId)){
            userHomeAddFriend.setVisibility(View.GONE);
        }

        userHomeUrl = getResources().getString(R.string.service_url)+"userhome?currentuser=" + currentUserId + "&targetuser=" + targetUserId;
        userHomeJson = iUserHomePresenter.getUserHome(userHomeUrl);
        userHomeNickname.setText(userHomeJson.getUsername());
        userHomeCity.setText(userHomeJson.getCity());
        userHomeGender.setText(userHomeJson.getGender());
        userHomeFollowing.setText(String.valueOf(userHomeJson.getFollowing()));
        userHomeFollowers.setText(String.valueOf(userHomeJson.getFollowers()));
        historyListAdapter.setDatas(userHomeJson.getHistory());
        if(userHomeJson.getIsfriend()!=null && userHomeJson.getIsfriend().equals("True")){
            userHomeAddFriend.setText("Followed");
            isFriend = Boolean.TRUE;
        }else{
            userHomeAddFriend.setText("Follow");
            isFriend = Boolean.FALSE;
        }


        followingArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHomeActivity.this, UserListActivity.class);
                sp = getSharedPreferences("User", Context.MODE_PRIVATE);
                intent.putExtra("userid",sp.getString("userid",""));
                intent.putExtra("action","following");
                startActivity(intent);
            }
        });

        followersArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHomeActivity.this, UserListActivity.class);
                sp = getSharedPreferences("User", Context.MODE_PRIVATE);
                intent.putExtra("userid",sp.getString("userid",""));
                intent.putExtra("action","followers");
                startActivity(intent);
            }
        });

        userHomeAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFriend == Boolean.TRUE){
                    addFriendUrl = getResources().getString(R.string.service_url) + "friendship?" +
                            "usera=" + currentUserId + "&userb=" + targetUserId + "&action=" + "del";
                }else{
                    addFriendUrl = getResources().getString(R.string.service_url) + "friendship?" +
                            "usera=" + currentUserId + "&userb=" + targetUserId + "&action=" + "add";
                }
                basicNetworkJson = iUserHomePresenter.manageFriend(addFriendUrl);
                if(basicNetworkJson.getCode().equals("OK") && isFriend == Boolean.FALSE){
                    isFriend = Boolean.TRUE;
                    userHomeAddFriend.setText("Followed");

                }else if(basicNetworkJson.getCode().equals("OK") && isFriend == Boolean.TRUE){
                    isFriend = Boolean.FALSE;
                    userHomeAddFriend.setText("Follow");
                }
                Toast.makeText(UserHomeActivity.this, basicNetworkJson.getText() ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onGetDataList(List<PositionListItem> datas){
        historyListAdapter.setDatas(datas);
    }

    @Override
    public Activity onGetActivity(){return this;}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent intent = new Intent(UserHomeActivity.this, PositionDetailActivity.class);
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String userid = sp.getString("userid","Null");
        intent.putExtra("userid", userid);//给intent添加额外数据
        intent.putExtra("venueid", String.valueOf(historyListAdapter.getItem(position).getVenueid()));//给intent添加额外数据
        if(userid!="Null"){
            startActivity(intent);
        }
    }
}
