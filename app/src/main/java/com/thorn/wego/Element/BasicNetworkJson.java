package com.thorn.wego.Element;

public class BasicNetworkJson {

    /**
     * text : Login successful
     * code : OK
     * user : {"userid":1525659142393,"username":"thorn"}
     */

    private String text;
    private String code;
    private UserBean user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userid : 1525659142393
         * username : thorn
         */

        private long userid;
        private String username;

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
    }
}
