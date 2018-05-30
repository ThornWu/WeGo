package com.thorn.wego.Location.PositionList.Presenter;

import android.app.Activity;

import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Location.PositionList.Model.IPositionListModel;
import com.thorn.wego.Location.PositionList.View.IPositionListView;
import com.thorn.wego.Location.PositionList.Model.PositionListModel;

import java.util.List;

public class PositionListPresenter implements IPositionListPresenter {
    private IPositionListView iPositionListView;
    private IPositionListModel iPositionListModel;
    private List<PositionListItem> datas;

    public PositionListPresenter(IPositionListView iPositionListView){
        this.iPositionListView = iPositionListView;
        iPositionListModel = new PositionListModel();
    }

    @Override
    public void loadDatas(String url){
        datas = iPositionListModel.getPositionList(url);
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
