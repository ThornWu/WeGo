package com.thorn.wego.Location.PositionList;
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

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Location.PositionDetail.PositionDetailActivity;
import com.thorn.wego.Adapter.PositionListItemAdapter;
import com.thorn.wego.Location.PositionList.Presenter.IPositionListPresenter;
import com.thorn.wego.Location.PositionList.Presenter.PositionListPresenter;
import com.thorn.wego.Location.PositionList.View.IPositionListView;
import com.thorn.wego.R;

import java.util.List;

public class SearchListActivity extends AppCompatActivity implements IPositionListView, AdapterView.OnItemClickListener {
    private ListView listView;
    private RelativeLayout discoverArea;
    private EditText positionListSearchText;
    private Button positionListSearchButton;
    private IPositionListPresenter iPositionListPresenter;
    private PositionListItemAdapter adapter;
    private String url;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_list);

        discoverArea = (RelativeLayout) findViewById(R.id.position_list_discover_area);
        discoverArea.setVisibility(View.GONE);

        listView = (ListView) this.findViewById(R.id.position_list_view);
        positionListSearchText = (EditText) this.findViewById(R.id.position_list_search_text);
        positionListSearchButton = (Button)this.findViewById(R.id.position_list_search_submit);

        listView.setOnItemClickListener(this);

        iPositionListPresenter = new PositionListPresenter(this);

        adapter = new PositionListItemAdapter(iPositionListPresenter);
        listView.setAdapter(adapter);

        positionListSearchText.setText(getIntent().getExtras().get("keyword").toString());

        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String city = sp.getString("city","null");
        String lat = sp.getString("lat","");
        String lon = sp.getString("lon","");
        String keyword = getIntent().getExtras().get("keyword").toString().toLowerCase();
        url = getResources().getString(R.string.service_url) + "search" + "?keyword=" + keyword + "&city=" + city + "&lat=" + lat +"&lon=" + lon;
        iPositionListPresenter.loadDatas(url);


        positionListSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(positionListSearchText.getText().length()!=0){
                    String url = getResources().getString(R.string.service_url) + "search" + "?keyword=" + positionListSearchText.getText();
                    iPositionListPresenter.loadDatas(url);
                    adapter.notifyDataSetChanged();
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
