package com.thorn.wego.Element;

import java.util.List;

public class UserHomeJson {
    private String isfriend;
    private long following;
    private long followers;
    private String username;
    private String gender;
    private long userid;
    private String city;
    private List<PositionListItem> history;

    public String getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(String isfriend) {
        this.isfriend = isfriend;
    }

    public long getFollowing() {
        return following;
    }

    public void setFollowing(long following) {
        this.following = following;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<PositionListItem> getHistory() {
        return history;
    }

    public void setHistory(List<PositionListItem> history) {
        this.history = history;
    }
}
