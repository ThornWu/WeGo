package com.thorn.wego.Element;

public class PositionDetailJson {
    private String category;
    private String venueid;
    private String venuename;
    private double latitude;
    private double longitude;
    private String address;
    private String isused;
    private int lastvisited;
    private String isstarred;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVenueid() {
        return venueid;
    }

    public void setVenueid(String venueid) {
        this.venueid = venueid;
    }

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }

    public int getLastvisited() {
        return lastvisited;
    }

    public void setLastvisited(int lastvisited) {
        this.lastvisited = lastvisited;
    }

    public String getIsstarred() {
        return isstarred;
    }

    public void setIsstarred(String isstarred) {
        this.isstarred = isstarred;
    }
}