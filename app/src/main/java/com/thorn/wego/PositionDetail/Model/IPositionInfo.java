package com.thorn.wego.PositionDetail.Model;

public interface IPositionInfo {
    String getCategory();
    String getVenueid();
    String getVenuename();
    double getLatitude();
    double getLongitude();
    String getAddress();
    String getIsused();
    double getLastvisited();
    String getIsstarred();
}
