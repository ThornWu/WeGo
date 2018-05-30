package com.thorn.wego.PositionList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.PositionDetail.PositionDetailActivity;
import com.thorn.wego.PositionList.Adapter.PositionListItemAdapter;
import com.thorn.wego.PositionList.Presenter.IPositionListItemAdapterPresenter;
import com.thorn.wego.PositionList.Presenter.PositionListItemAdapterPresenter;
import com.thorn.wego.PositionList.View.IPositionListView;
import com.thorn.wego.R;

import java.util.List;

public class HistoryListAcitivity extends AppCompatActivity implements IPositionListView, AdapterView.OnItemClickListener {
    private ListView listView;
    private RelativeLayout positionListSearchArea, discoverArea;
    private IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter;
    private PositionListItemAdapter adapter;
    private String url;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_list);

        positionListSearchArea = (RelativeLayout) findViewById(R.id.position_list_search_area);
        discoverArea = (RelativeLayout) findViewById(R.id.position_list_discover_area);
        positionListSearchArea.setVisibility(View.GONE);
        discoverArea.setVisibility(View.GONE);
        listView = (ListView) this.findViewById(R.id.position_list_view);


        listView.setOnItemClickListener(this);

        iPositionListItemAdapterPresenter = new PositionListItemAdapterPresenter(this);

        adapter = new PositionListItemAdapter(iPositionListItemAdapterPresenter);
        listView.setAdapter(adapter);


        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String userid = sp.getString("userid","Null");
        if(userid!="Null"){
            url = getResources().getString(R.string.service_url) + "history" + "?userid=" + userid;
            iPositionListItemAdapterPresenter.loadDatas(url);
        }

    }

    @Override
    public void onGetDataList(List<PositionListItem> datas){
        adapter.setDatas(datas);
    }

    @Override
    public Activity onGetActivity(){return this;}


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent intent = new Intent(this, PositionDetailActivity.class);
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String userid = sp.getString("userid","Null");
        intent.putExtra("userid", userid);//给intent添加额外数据
        intent.putExtra("venueid", String.valueOf(adapter.getItem(position).getVenueid()));//给intent添加额外数据
        if(userid!="Null"){
            startActivity(intent);
        }
    }
}
