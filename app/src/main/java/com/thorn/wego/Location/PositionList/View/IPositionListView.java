package com.thorn.wego.Location.PositionList.View;

import android.app.Activity;

import com.thorn.wego.Element.PositionListItem;

import java.util.List;

public interface IPositionListView {
    public void onGetDataList(List<PositionListItem> datas);
    public Activity onGetActivity();
}
