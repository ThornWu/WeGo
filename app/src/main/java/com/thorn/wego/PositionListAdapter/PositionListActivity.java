package com.thorn.wego.PositionListAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thorn.wego.PositionListAdapter.Adapter.PositionListItemAdapter;
import com.thorn.wego.PositionListAdapter.Presenter.IPositionListItemAdapterPresenter;
import com.thorn.wego.PositionListAdapter.View.IPositionListView;
import com.thorn.wego.R;

public class PositionListActivity extends AppCompatActivity{
    private ListView listView;
    private IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter;
    private PositionListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_list);

    }
}
