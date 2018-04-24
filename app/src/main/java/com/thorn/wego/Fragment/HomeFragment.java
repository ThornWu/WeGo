package com.thorn.wego.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.thorn.wego.Adapter.HomeNavigationIconAdapter;
import com.thorn.wego.Element.ImageTextIcon;
import com.thorn.wego.R;

import java.util.LinkedList;

public class HomeFragment extends Fragment {
    private View rootView;
    private GridView gridNavigation;
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
        imageTextIconList = new LinkedList<ImageTextIcon>();

        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_restaurant,"Restaurant"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_mall,"Mall"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_nightlife,"Nightlife"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_hotel,"Hotel"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_park,"Park"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_movie,"Movie"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_museum,"Museum"));
        imageTextIconList.add(new ImageTextIcon(R.drawable.ic_stadium,"Stadium"));

        homeNavigationIconAdapter = new HomeNavigationIconAdapter(getContext(), imageTextIconList);
        gridNavigation.setAdapter(homeNavigationIconAdapter);
    }

}
