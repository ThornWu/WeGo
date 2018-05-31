package com.thorn.wego.Location.PositionList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Location.PositionDetail.PositionDetailActivity;
import com.thorn.wego.Adapter.PositionListItemAdapter;
import com.thorn.wego.Location.PositionList.Presenter.IPositionListPresenter;
import com.thorn.wego.Location.PositionList.Presenter.PositionListPresenter;
import com.thorn.wego.Location.PositionList.View.IPositionListView;
import com.thorn.wego.R;

import java.util.ArrayList;
import java.util.List;

public class SearchListActivity extends AppCompatActivity implements IPositionListView, AdapterView.OnItemClickListener {
    private ListView listView;
    private RelativeLayout discoverArea;
    private EditText positionListSearchText;
    private Button positionListSearchButton;
    private Spinner searchDistance;
    private List<String> distanceChoiceList;
    private IPositionListPresenter iPositionListPresenter;
    private PositionListItemAdapter adapter;
    private String url, city, lat, lon, keyword;
    private SharedPreferences sp;
    private int searchDistanceSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_list);

        discoverArea = (RelativeLayout) findViewById(R.id.position_list_discover_area);
        discoverArea.setVisibility(View.GONE);

        listView = (ListView) this.findViewById(R.id.position_list_view);
        positionListSearchText = (EditText) this.findViewById(R.id.position_list_search_text);
        positionListSearchButton = (Button)this.findViewById(R.id.position_list_search_submit);
        searchDistance = (Spinner) this.findViewById(R.id.position_list_search_distance);

        listView.setOnItemClickListener(this);

        iPositionListPresenter = new PositionListPresenter(this);

        adapter = new PositionListItemAdapter(iPositionListPresenter);
        listView.setAdapter(adapter);

        distanceChoiceList = new ArrayList<String>();
        distanceChoiceList.add("No Limit");
        distanceChoiceList.add("5KM");
        distanceChoiceList.add("10KM");
        distanceChoiceList.add("15KM");
        distanceChoiceList.add("30KM");

        final ArrayAdapter<String> distanceChoicesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,distanceChoiceList);
        distanceChoicesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchDistance.setAdapter(distanceChoicesAdapter);

        searchDistance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    searchDistanceSelected = 5;
                }else if(position==2){
                    searchDistanceSelected = 10;
                }else if(position==3){
                    searchDistanceSelected = 15;
                }else if(position==4){
                    searchDistanceSelected = 30;
                }else{
                    searchDistanceSelected = 60;
                }
                if(positionListSearchText.getText().length()!=0){
                    url = getResources().getString(R.string.service_url) + "search" + "?keyword=" + positionListSearchText.getText() +
                            "&city=" + city + "&lat=" + lat +"&lon=" + lon + "&dmax=" + searchDistanceSelected;
                    iPositionListPresenter.loadDatas(url);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        city = sp.getString("city","null");
        lat = sp.getString("lat","");
        lon = sp.getString("lon","");
        keyword = getIntent().getExtras().get("keyword").toString().toLowerCase();
        positionListSearchText.setText(keyword);


        url = getResources().getString(R.string.service_url) + "search" + "?keyword=" + keyword + "&city=" +
                city + "&lat=" + lat +"&lon=" + lon + "&dmax=" + searchDistanceSelected;
        iPositionListPresenter.loadDatas(url);


        positionListSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(positionListSearchText.getText().length()!=0){
                    url = getResources().getString(R.string.service_url) + "search" + "?keyword=" + positionListSearchText.getText() +
                            "&city=" + city + "&lat=" + lat +"&lon=" + lon + "&dmax=" + searchDistanceSelected;
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
