package com.thorn.wego.PositionListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.PositionDetail.PositionDetailActivity;
import com.thorn.wego.PositionListAdapter.Adapter.PositionListItemAdapter;
import com.thorn.wego.PositionListAdapter.Presenter.IPositionListItemAdapterPresenter;
import com.thorn.wego.PositionListAdapter.Presenter.PositionListItemAdapterPresenter;
import com.thorn.wego.PositionListAdapter.View.IPositionListView;
import com.thorn.wego.R;

import java.util.List;

public class PositionListActivity extends AppCompatActivity implements IPositionListView, AdapterView.OnItemClickListener{
    private ListView listView;
    private IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter;
    private PositionListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_list);
        listView = (ListView) this.findViewById(R.id.position_list_view);
        listView.setOnItemClickListener(this);

        iPositionListItemAdapterPresenter = new PositionListItemAdapterPresenter(this);

        adapter = new PositionListItemAdapter(iPositionListItemAdapterPresenter);
        listView.setAdapter(adapter);

        String keyword = getIntent().getExtras().get("keyword").toString().toLowerCase();
        String url = getResources().getString(R.string.service_url) + "search";
        iPositionListItemAdapterPresenter.loadDatas(keyword,url);
    }

    @Override
    public void onGetDataList(List<PositionListItem> datas){
        adapter.setDatas(datas);
    }

    @Override
    public Activity onGetActivity(){return this;}


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent intent = new Intent(PositionListActivity.this, PositionDetailActivity.class);
        //TODO: user_id 更换
        intent.putExtra("userid", "33");//给intent添加额外数据
        intent.putExtra("venueid", String.valueOf(adapter.getItem(position).getVenueid()));//给intent添加额外数据
        startActivity(intent);
    }
}
