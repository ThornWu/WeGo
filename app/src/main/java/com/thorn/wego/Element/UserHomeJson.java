package com.thorn.wego.Element;

import java.util.List;

public class UserHomeJson {
    /**
     * userid : 32
     * username : 32
     * gender : Male
     * city : New York
     * history : [{"category":"Church","venueid":"4b8c1edef964a52028bf32e3","venuename":"RL Restaurant","latitude":41.8967188,"longitude":-87.6248655,"address":"115 E Chicago Ave"},{"category":"Pub","venueid":"40b28c80f964a520a7fb1ee3","venuename":"Fado Irish Pub & Restaurant Chicago","latitude":41.891688,"longitude":-87.631271,"address":"100 W Grand Ave"},{"category":"Breakfast Spot","venueid":"49f3473cf964a5207f6a1fe3","venuename":"Portillo's","latitude":41.89343669,"longitude":-87.63143241,"address":"100 W Ontario St."},{"category":"Fast Food Restaurant","venueid":"4d017e6ae0c5a1cd018777ae","venuename":"El Cobre","latitude":40.725658,"longitude":-73.98412,"address":"95 Ave A"},{"category":"Strip Club","venueid":"4dfb92ccae60c9cdd38a4bf8","venuename":"The Consummation Room","latitude":42.220052,"longitude":-88.285077,"address":"null"},{"category":"Coffee Shop","venueid":"49d376a1f964a520fa5b1fe3","venuename":"Everyman Espresso","latitude":40.7327659,"longitude":-73.9882503,"address":"136 E 13th St"},{"category":"Wine Bar","venueid":"3fd66200f964a520b8ea1ee3","venuename":"Veselka","latitude":40.729107,"longitude":-73.987061,"address":"144 2nd Ave"},{"category":"Boutique","venueid":"44dc96e4f964a520b0361fe3","venuename":"Think Coffee","latitude":40.728395,"longitude":-73.995489,"address":"248 Mercer St"},{"category":"Seafood Restaurant","venueid":"4a2bee9df964a520f3961fe3","venuename":"The Clam Bar","latitude":40.99841121,"longitude":-72.04370499,"address":"2025 Montauk Hwy"},{"category":"Train","venueid":"4a513b17f964a520d2b01fe3","venuename":"LIRR - Jamaica Station","latitude":40.69956029,"longitude":-73.80851269,"address":"Sutphin Blvd & Archer Ave"}]
     * following : 500
     * followers : 1559
     */

    private long userid;
    private String username;
    private String gender;
    private String city;
    private long following;
    private long followers;
    private List<PositionListItem> history;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public List<PositionListItem> getHistory() {
        return history;
    }

    public void setHistory(List<PositionListItem> history) {
        this.history = history;
    }

}
