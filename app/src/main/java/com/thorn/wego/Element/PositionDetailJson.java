package com.thorn.wego.Element;

public class PositionDetailJson {

    /**
     * isused : True
     * category : Caf
     * venuename : Times Square
     * address : Broadway & 7th Ave
     * longitude : -73.98652554
     * lastvisited : 1.5256743477141888E9
     * latitude : 40.75621355
     * venueid : 49b7ed6df964a52030531fe3
     * isstarred : False
     */

    private String isused;
    private String category;
    private String venuename;
    private String address;
    private double longitude;
    private double lastvisited;
    private double latitude;
    private String venueid;
    private String isstarred;

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLastvisited() {
        return lastvisited;
    }

    public void setLastvisited(double lastvisited) {
        this.lastvisited = lastvisited;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getVenueid() {
        return venueid;
    }

    public void setVenueid(String venueid) {
        this.venueid = venueid;
    }

    public String getIsstarred() {
        return isstarred;
    }

    public void setIsstarred(String isstarred) {
        this.isstarred = isstarred;
    }
}
