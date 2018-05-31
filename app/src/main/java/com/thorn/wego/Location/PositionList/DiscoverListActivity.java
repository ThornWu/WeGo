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

public class DiscoverListActivity extends AppCompatActivity implements IPositionListView, AdapterView.OnItemClickListener {
    private ListView listView;
    private RelativeLayout positionListSearchArea;
    private EditText discoverLat, discoverLon;
    private Button discoverSearchButton;
    private Spinner discoverWeek, discoverTime;
    private List<String> weeklist, timelist;
    private IPositionListPresenter iPositionListPresenter;
    private PositionListItemAdapter adapter;
    private int discoverWeekSelected, discoverTimeSelected;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position_list);

        positionListSearchArea = (RelativeLayout) findViewById(R.id.position_list_search_area);
        positionListSearchArea.setVisibility(View.GONE);

        listView = (ListView) this.findViewById(R.id.position_list_view);

        discoverWeek = (Spinner) this.findViewById(R.id.discover_week);
        discoverTime = (Spinner) this.findViewById(R.id.discover_time);
        discoverLat = (EditText) this.findViewById(R.id.discover_lat);
        discoverLon = (EditText) this.findViewById(R.id.discover_lon);
        discoverSearchButton = (Button) this.findViewById(R.id.discover_search_submit);

        listView.setOnItemClickListener(this);

        iPositionListPresenter = new PositionListPresenter(this);

        adapter = new PositionListItemAdapter(iPositionListPresenter);
        listView.setAdapter(adapter);


        weeklist = new ArrayList<String>();
        timelist = new ArrayList<String>();
        weeklist.add("Weekday");
        weeklist.add("Weekend");
        timelist.add("Morning");
        timelist.add("Afternoon");
        timelist.add("Evening");
        timelist.add("Midnight");

        final ArrayAdapter<String> weekListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, weeklist);
        final ArrayAdapter<String> timeListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, timelist);

        weekListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        discoverWeek.setAdapter(weekListAdapter);
        discoverTime.setAdapter(timeListAdapter);

        discoverWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                discoverWeekSelected = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        discoverTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                discoverTimeSelected = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        discoverLat.setText(sp.getString("lat",""));
        discoverLon.setText(sp.getString("lon",""));

        discoverSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getSharedPreferences("User", Context.MODE_PRIVATE);
                int discoverTimeId = discoverWeekSelected*4 + discoverTimeSelected;
                String userid = sp.getString("userid","Null");
                String city = sp.getString("city","null");
                if(discoverLat.getText().length()!=0 && discoverLon.getText().length()!=0){
                    if(userid!="Null"){
                        String url = getResources().getString(R.string.service_url) + "recommend" +
                                "?userid=" + userid + "&city=" + city + "&lat=" + discoverLat.getText() +
                                "&lon=" + discoverLon.getText() + "&timeid=" + discoverTimeId;
                        iPositionListPresenter.loadDatas(url);
                        adapter.notifyDataSetChanged();
                    }
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
