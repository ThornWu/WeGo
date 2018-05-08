package com.thorn.wego.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.thorn.wego.Adapter.ToolNavigationIconAdapter;
import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.R;
import com.thorn.wego.Register.RegisterActivity;
import com.thorn.wego.Translation.TranslationActivity;
import com.thorn.wego.Uber.UberActivity;
import com.thorn.wego.WeatherForecast.WeatherForecastActivity;

import java.util.LinkedList;

public class ToolFragment extends Fragment {
    private View rootView;
    private GridView gridNavigation;
    private LinkedList<ImageTextIcon> imageTextIconList;
    private ToolNavigationIconAdapter toolNavigationIconAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(null == rootView){
            rootView = inflater.inflate(R.layout.tool_fragment,container,false);
            initView(rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if(null != parent){
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView(View view){
        gridNavigation = (GridView) rootView.findViewById(R.id.tool_grid_navigation);
        imageTextIconList = new LinkedList<ImageTextIcon>();

        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_weather,"Weather"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_translation,"Translation"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_choice,"Choice"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_news,"News"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_uber,"Uber"));

        toolNavigationIconAdapter = new ToolNavigationIconAdapter(getContext(), imageTextIconList);
        gridNavigation.setAdapter(toolNavigationIconAdapter);

        gridNavigation.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String function_name = String.valueOf(imageTextIconList.get(position).getIconName());
                if(function_name.equals("Weather")){
                    Intent intent = new Intent(getContext(), WeatherForecastActivity.class);
                    startActivity(intent);
                } else if(function_name.equals("Translation")){
                    Intent intent = new Intent(getContext(), TranslationActivity.class);
                    startActivity(intent);
                }else if(function_name.equals("Uber")){
                    Intent intent = new Intent(getContext(), UberActivity.class);
                    startActivity(intent);
                }
            }

        });
    }
}

