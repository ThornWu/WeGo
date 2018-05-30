package com.thorn.wego.PositionList.Presenter;

import android.app.Activity;

import com.google.gson.Gson;
import com.thorn.wego.Element.PositionListItem;
import com.thorn.wego.Element.PositionListJson;
import com.thorn.wego.PositionList.Model.IPositionListModel;
import com.thorn.wego.PositionList.Model.PositionListModel;
import com.thorn.wego.PositionList.View.IPositionListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
