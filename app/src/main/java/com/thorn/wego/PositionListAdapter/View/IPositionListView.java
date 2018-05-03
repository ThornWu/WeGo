package com.thorn.wego.PositionListAdapter.View;

import android.app.Activity;

import com.thorn.wego.Element.PositionItem;

import java.util.List;

public interface IPositionListView {
    public void onGetDataList(List<PositionItem> datas);
    public Activity onGetActivity();
}
