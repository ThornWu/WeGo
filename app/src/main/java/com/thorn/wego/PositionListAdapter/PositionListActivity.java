package com.thorn.wego.PositionListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private RelativeLayout positionListSearchArea;
    private TextView positionListSearchText;
    private Button positionListSearchButton;
    private IPositionListItemAdapterPresenter iPositionListItemAdapterPresenter;
    private PositionListItemAdapter adapter;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_list);

        positionListSearchArea = (RelativeLayout) findViewById(R.id.position_list_search_area);
        listView = (ListView) this.findViewById(R.id.position_list_view);
        positionListSearchText = (TextView) this.findViewById(R.id.position_list_search_text);
        positionListSearchButton = (Button)this.findViewById(R.id.position_list_search_submit);

        listView.setOnItemClickListener(this);

        iPositionListItemAdapterPresenter = new PositionListItemAdapterPresenter(this);

        adapter = new PositionListItemAdapter(iPositionListItemAdapterPresenter);
        listView.setAdapter(adapter);

        if(getIntent().getExtras().get("searcharea").toString().equals("false")){
            positionListSearchArea.setVisibility(View.GONE);
        }else{
            positionListSearchText.setText(getIntent().getExtras().get("keyword").toString());
        }

        String function = getIntent().getExtras().get("function").toString();

        if(function.equals("search")){
            String keyword = getIntent().getExtras().get("keyword").toString().toLowerCase();
            url = getResources().getString(R.string.service_url) + function + "?keyword=" + keyword;
            iPositionListItemAdapterPresenter.loadDatas(url);
        }else if(function.equals("history")){
            String userid = getIntent().getExtras().get("userid").toString();
            url = getResources().getString(R.string.service_url) + function + "?userid=" + userid;
            iPositionListItemAdapterPresenter.loadDatas(url);
        }else if(function.equals("favorite")){
            String userid = getIntent().getExtras().get("userid").toString();
            url = getResources().getString(R.string.service_url) + function + "?userid=" + userid;
            iPositionListItemAdapterPresenter.loadDatas(url);
        }
        positionListSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(positionListSearchText.getText().length()!=0){
                    String url = getResources().getString(R.string.service_url) + "search" + "?keyword=" + positionListSearchText.getText();
                    iPositionListItemAdapterPresenter.loadDatas(url);
                }
            }
        });
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
