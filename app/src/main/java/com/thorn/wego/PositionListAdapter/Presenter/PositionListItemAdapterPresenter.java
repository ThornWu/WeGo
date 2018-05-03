package com.thorn.wego.PositionListAdapter.Presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.thorn.wego.Element.PositionItem;
import com.thorn.wego.PositionListAdapter.View.IPositionListView;
import com.thorn.wego.R;

import java.util.ArrayList;
import java.util.List;

public class PositionListItemAdapterPresenter implements IPositionListItemAdapterPresenter {
    List<PositionItem> datas;
    IPositionListView iPositionListView;

    public PositionListItemAdapterPresenter (IPositionListView iPositionListView){
        this.iPositionListView = iPositionListView;
    }

    @Override
    public void loadDatas(){
        datas = new ArrayList<PositionItem>();

        datas.add(new PositionItem(1, R.drawable.ic_shop,"Los Angeles International Airport (LAX)","1 World Way","Airport",true,33.94389398,-118.4050226));
        datas.add(new PositionItem(2,R.drawable.ic_shop,"Disneyland","1313 S. Harbor Blvd","Theme Park",true,33.8093194,-117.9199505));
        datas.add(new PositionItem(3,R.drawable.ic_shop,"San Francisco International Airport (SFO)","275 S. Airport Blvd","Airport",true,37.61637306,-122.3861074));
        datas.add(new PositionItem(4,R.drawable.ic_shop,"987 FM","3400 W. Olive Ave","Airport",true,34.15325969,-118.3358216));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                iPositionListView.onGetDataList(datas);
            }
        });
        thread.start();
    }

    @Override
    public Activity getActivity(){
        return iPositionListView.onGetActivity();
    }
}
