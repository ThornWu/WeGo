package com.thorn.wego.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.thorn.wego.Adapter.ToolNavigationIconAdapter;
import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.R;

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
    }
}

