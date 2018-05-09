package com.thorn.wego.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.thorn.wego.Adapter.HomeNavigationIconAdapter;
import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.PositionListAdapter.PositionListActivity;
import com.thorn.wego.R;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View rootView;
    private GridView gridNavigation;
    private TextView homeSearchText, homeDate, homeDay;
    private Button homeSearchSubmit;
    private LinkedList<ImageTextIcon> imageTextIconList;
    private HomeNavigationIconAdapter homeNavigationIconAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(null == rootView){
            rootView = inflater.inflate(R.layout.home_fragment,container,false);
            initView(rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if(null != parent){
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View view){
        gridNavigation = (GridView) rootView.findViewById(R.id.home_grid_navigation);

        homeDate = (TextView) rootView.findViewById(R.id.home_date);
        homeDay = (TextView) rootView.findViewById(R.id.home_day);

        homeSearchText = (TextView) rootView.findViewById(R.id.home_search_text);
        homeSearchSubmit = (Button) rootView.findViewById(R.id.home_search_submit);

        imageTextIconList = new LinkedList<ImageTextIcon>();

        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_restaurant,"Restaurant"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_nightlife,"Nightlife"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_mall,"Mall"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_park,"Park"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_movie,"Movie"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_hotel,"Hotel"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_museum,"Museum"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_stadium,"Stadium"));

        homeNavigationIconAdapter = new HomeNavigationIconAdapter(getContext(), imageTextIconList);
        gridNavigation.setAdapter(homeNavigationIconAdapter);

        gridNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getContext(), PositionListActivity.class);
                intent.putExtra("function","search");
                intent.putExtra("searcharea","true");
                intent.putExtra("keyword", String.valueOf(imageTextIconList.get(position).getIconName()));//给intent添加额外数据
                startActivity(intent);
            }

        });

        homeSearchSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeSearchText.getText().length()!=0){
                    Intent intent = new Intent(getContext(), PositionListActivity.class);
                    intent.putExtra("function","search");
                    intent.putExtra("searcharea","true");
                    intent.putExtra("keyword", homeSearchText.getText());//给intent添加额外数据
                    startActivity(intent);
                    homeSearchText.setText("");
                }
            }
        });

        Date date = new Date();
        String [] dateInfo = date.toString().split(" ");
        homeDate.setText(dateInfo[1] + " "+ dateInfo[2]);
        homeDay.setText(dateInfo[0]);
    }


    @Override
    public void onHiddenChanged(boolean hidden){
        if(!hidden){
            Date date = new Date();
            String [] dateInfo = date.toString().split(" ");
            homeDate.setText(dateInfo[1] + " "+ dateInfo[2]);
            homeDay.setText(dateInfo[0]);
        }
    }

}
