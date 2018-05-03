package com.thorn.wego.PositionListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.thorn.wego.Element.PositionItem;
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
        iPositionListItemAdapterPresenter.loadDatas();
    }

    @Override
    public void onGetDataList(List<PositionItem> datas){
        adapter.setDatas(datas);
    }

    @Override
    public Activity onGetActivity(){return this;}


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(PositionListActivity.this, String.valueOf(adapter.getItem(position).getpName()), Toast.LENGTH_SHORT).show();
    }
}
