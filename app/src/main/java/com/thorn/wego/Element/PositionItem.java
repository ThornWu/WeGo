package com.thorn.wego.Element;

public class PositionItem {
    private int pId;
    private int picId;
    private String pName;
    private String pAddress;
    private String pCategory;
    private boolean pIsStarred;
    private double pLatitude;
    private double pLongitude;

    public PositionItem(){}
    //    public PositionItem(int pId, int picId, String pName, String pAddress, String pCategory){
//        this.pId = pId;
//        this.picId = picId;
//        this.pName = pName;
//        this.pAddress = pAddress;
//        this.pCategory = pCategory;
//    }
    public PositionItem(int pId, int picId, String pName, String pAddress, String pCategory,boolean pIsStarred, double pLatitude, double pLongitude){
        this.pId = pId;
        this.picId = picId;
        this.pName = pName;
        this.pAddress = pAddress;
        this.pCategory = pCategory;
        this.pIsStarred = pIsStarred;
        this.pLatitude = pLatitude;
        this.pLongitude = pLongitude;
    }

    public int getpId() {
        return pId;
    }
    public int getpicId(){
        return picId;
    }
    public String getpName(){
        return pName;
    }
    public String getpAddress(){
        return pAddress;
    }
    public String getpCategory() {
        return pCategory;
    }
    public boolean pIsStarred(){
        return pIsStarred;
    }
    public double getpLatitude(){
        return pLatitude;
    }
    public double getpLongitude(){
        return pLongitude;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
    public void setpicId(int picId){
        this.picId = picId;
    }
    public void setpName(String pName){
        this.pName = pName;
    }
    public void setpAddress(String pAddress){
        this.pAddress = pAddress;
    }
    public void setpCategory(String pCategory){
        this.pCategory = pCategory;
    }
    public void setpIsStarred(boolean pIsStarred){
        this.pIsStarred = pIsStarred;
    }
    public void setpLatitude(double pLatitude){
        this.pLatitude = pLatitude;
    }
    public void setpLongitude(double pLongitude){
        this.pLongitude = pLongitude;
    }
}