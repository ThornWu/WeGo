package com.thorn.wego.Location.PositionList.Model;

import com.thorn.wego.Element.PositionListItem;

import java.util.List;

public interface IPositionListModel {
    List<PositionListItem> getPositionList(String url);
}
