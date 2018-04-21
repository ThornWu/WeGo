package com.thorn.wego.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thorn.wego.Adapter.PositionItemAdapter;
import com.thorn.wego.Element.PositionItem;
import com.thorn.wego.R;

import java.util.ArrayList;
import java.util.List;

public class AccountMenuActivity extends AppCompatActivity {
    private Context mContext;
    private ListView listView;
    private List<PositionItem> positionItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_menu_fragment);
        initView();
    }

    private void initView(){
        mContext = AccountMenuActivity.this;
        listView = (ListView) (ListView)findViewById(R.id.account_position_list);
        positionItemList = new ArrayList<PositionItem>();

        positionItemList.add(new PositionItem(1,R.drawable.ic_shop,"Los Angeles International Airport (LAX)","1 World Way","Airport",true,33.94389398,-118.4050226));
        positionItemList.add(new PositionItem(2,R.drawable.ic_shop,"Disneyland","1313 S. Harbor Blvd","Theme Park",true,33.8093194,-117.9199505));
        positionItemList.add(new PositionItem(3,R.drawable.ic_shop,"San Francisco International Airport (SFO)","275 S. Airport Blvd","Airport",true,37.61637306,-122.3861074));
        positionItemList.add(new PositionItem(4,R.drawable.ic_shop,"987 FM","3400 W. Olive Ave","Airport",true,34.15325969,-118.3358216));


        PositionItemAdapter adapter = new PositionItemAdapter(mContext, R.layout.account_position_item, positionItemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AccountMenuActivity.this, PositionDetailActivity.class);
                intent.putExtra("position_id", String.valueOf(positionItemList.get(position).getpId()));//给intent添加额外数据
                startActivity(intent);
            }
        });
    }
}

