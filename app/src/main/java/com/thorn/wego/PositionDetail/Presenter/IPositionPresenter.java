package com.thorn.wego.PositionDetail.Presenter;

import android.app.Activity;

import com.thorn.wego.Element.BasicNetworkJson;
import com.thorn.wego.Element.PositionDetailJson;

public interface IPositionPresenter {
    Activity getActivity();
    PositionDetailJson getPositionDetail(String url);
    BasicNetworkJson doOperation(String url);
}
