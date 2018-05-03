package com.thorn.wego.PositionDetail.Model;

import com.thorn.wego.Element.PositionDetailJson;

public class PositionInfo implements IPositionInfo{
    private PositionDetailJson positionDetailJson = new PositionDetailJson();

    @Override
    public String getCategory() {return positionDetailJson.getCategory();}

    @Override
    public String getVenueid(){ return positionDetailJson.getVenueid();}

    @Override
    public String getVenuename(){return positionDetailJson.getVenuename();}

    @Override
    public double getLatitude(){return positionDetailJson.getLatitude();}

    @Override
    public double getLongitude(){return positionDetailJson.getLongitude();}

    @Override
    public String getAddress(){return positionDetailJson.getAddress();}

    @Override
    public String getIsused(){return positionDetailJson.getIsused();}

    @Override
    public int getLastvisited(){return positionDetailJson.getLastvisited();}

    @Override
    public String getIsstarred(){return positionDetailJson.getIsstarred();}
}
