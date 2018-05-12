package com.thorn.wego.UserHome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Element.UserHomeJson;
import com.thorn.wego.PositionDetail.PositionDetailActivity;
import com.thorn.wego.PositionListAdapter.Adapter.PositionListItemAdapter;
import com.thorn.wego.PositionListAdapter.PositionListActivity;
import com.thorn.wego.PositionListAdapter.Presenter.IPositionListItemAdapterPresenter;
import com.thorn.wego.PositionListAdapter.Presenter.PositionListItemAdapterPresenter;
import com.thorn.wego.PositionListAdapter.View.IPositionListView;
import com.thorn.wego.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UserHomeActivity extends Activity implements IPositionListView, AdapterView.OnItemClickListener{
    private TextView userHomeNickname, userHomeCity, userHomeGender, userHomeFollowing, userHomeFollowers;
    private ListView historyList;
    private String requestUserId;
    private UserHomeJson userHomeJson = new UserHomeJson();
    private SharedPreferences sp;
    private IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter;
    private PositionListItemAdapter historyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        userHomeNickname = (TextView) findViewById(R.id.userhome_nickname);
        userHomeCity = (TextView) findViewById(R.id.userhome_city);
        userHomeGender = (TextView) findViewById(R.id.userhome_gender);
        userHomeFollowing = (TextView) findViewById(R.id.userhome_following_text);
        userHomeFollowers = (TextView) findViewById(R.id.userhome_followers_text);
        historyList = (ListView) findViewById(R.id.userhome_history);
        historyList.setOnItemClickListener(this);

        iPositionListItemAdapterPresenter = new PositionListItemAdapterPresenter(this);

        historyListAdapter = new PositionListItemAdapter(iPositionListItemAdapterPresenter);
        historyList.setAdapter(historyListAdapter);

        requestUserId = getIntent().getExtras().get("userid").toString();
        String url = getResources().getString(R.string.service_url)+"userhome?userid="+requestUserId;
        sendRequest(url);
        userHomeNickname.setText(userHomeJson.getUsername());
        userHomeCity.setText(userHomeJson.getCity());
        userHomeGender.setText(userHomeJson.getGender());
        userHomeFollowing.setText(String.valueOf(userHomeJson.getFollowing()));
        userHomeFollowers.setText(String.valueOf(userHomeJson.getFollowers()));
        historyListAdapter.setDatas(userHomeJson.getHistory());
    }


    private void sendRequest(final String url){
        try{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection = null;
                    try{

                        URL format_url = new URL(url);
                        connection = (HttpURLConnection) format_url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(5000);

                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        userHomeJson = (UserHomeJson) new Gson().fromJson(response.toString(),UserHomeJson.class);

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        if(connection != null){ connection.disconnect(); }
                    }
                }
            });
            thread.start();
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

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
