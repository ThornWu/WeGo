package com.thorn.wego.PositionDetail.Presenter;

import android.app.Activity;

import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.PositionDetailJson;
import com.thorn.wego.PositionDetail.Model.IPositionInfo;
import com.thorn.wego.PositionDetail.Model.PositionInfo;
import com.thorn.wego.PositionDetail.View.IPositionView;

public class PositionPresenter implements IPositionPresenter{
    private IPositionInfo iPositionInfo;
    private IPositionView iPositionView;
    private PositionDetailJson positionDetailJson;
    private BasicNetworkJson basicNetworkJson;

    public PositionPresenter(IPositionView iPositionView){
        this.iPositionView=iPositionView;
        this.iPositionInfo = new PositionInfo();
    }

    @Override
    public PositionDetailJson getPositionDetail(String url) {
        positionDetailJson = iPositionInfo.getPositionDetail(url);
        return positionDetailJson;
    }

    @Override
    public BasicNetworkJson doOperation(String url){
        basicNetworkJson = iPositionInfo.doOperation(url);
        return basicNetworkJson;
    }

    @Override
    public Activity getActivity(){
        return iPositionView.onGetActivity();
    }
}
