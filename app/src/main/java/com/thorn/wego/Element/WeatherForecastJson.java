package com.thorn.wego.Element;

import java.util.List;

public class WeatherForecastJson {


    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101010100","location":"beijing","parent_city":"beijing","admin_area":"beijing","cnty":"China","lat":"39.90498734","lon":"116.4052887","tz":"+8.00"}
         * update : {"loc":"2018-05-08 22:47","utc":"2018-05-08 14:47"}
         * status : ok
         * now : {"cloud":"0","cond_code":"100","cond_txt":"Sunny/Clear","fl":"17","hum":"29","pcpn":"0.0","pres":"1019","tmp":"19","vis":"10","wind_deg":"185","wind_dir":"S","wind_sc":"2","wind_spd":"6"}
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"Cloudy","cond_txt_n":"Sunny/Clear","date":"2018-05-08","hum":"22","mr":"01:16","ms":"11:38","pcpn":"0.0","pop":"0","pres":"1017","sr":"05:08","ss":"19:16","tmp_max":"27","tmp_min":"13","uv_index":"8","vis":"20","wind_deg":"180","wind_dir":"S","wind_sc":"1-2","wind_spd":"5"},{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"Sunny/Clear","cond_txt_n":"Cloudy","date":"2018-05-09","hum":"29","mr":"01:52","ms":"12:36","pcpn":"0.0","pop":"0","pres":"1020","sr":"05:06","ss":"19:17","tmp_max":"29","tmp_min":"17","uv_index":"8","vis":"20","wind_deg":"186","wind_dir":"S","wind_sc":"1-2","wind_spd":"9"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"Cloudy","cond_txt_n":"Cloudy","date":"2018-05-10","hum":"28","mr":"02:24","ms":"13:35","pcpn":"0.0","pop":"0","pres":"1020","sr":"05:05","ss":"19:18","tmp_max":"26","tmp_min":"18","uv_index":"7","vis":"20","wind_deg":"175","wind_dir":"S","wind_sc":"1-2","wind_spd":"3"}]
         * hourly : [{"cloud":"0","cond_code":"100","cond_txt":"Sunny/Clear","dew":"1","hum":"61","pop":"0","pres":"1018","time":"2018-05-09 01:00","tmp":"14","wind_deg":"182","wind_dir":"S","wind_sc":"1-2","wind_spd":"2"},{"cloud":"0","cond_code":"100","cond_txt":"Sunny/Clear","dew":"1","hum":"68","pop":"0","pres":"1018","time":"2018-05-09 04:00","tmp":"13","wind_deg":"179","wind_dir":"S","wind_sc":"1-2","wind_spd":"11"},{"cloud":"0","cond_code":"100","cond_txt":"Sunny/Clear","dew":"4","hum":"61","pop":"0","pres":"1020","time":"2018-05-09 07:00","tmp":"15","wind_deg":"116","wind_dir":"SE","wind_sc":"1-2","wind_spd":"5"},{"cloud":"0","cond_code":"100","cond_txt":"Sunny/Clear","dew":"4","hum":"54","pop":"0","pres":"1020","time":"2018-05-09 10:00","tmp":"23","wind_deg":"257","wind_dir":"SW","wind_sc":"1-2","wind_spd":"2"},{"cloud":"4","cond_code":"100","cond_txt":"Sunny/Clear","dew":"4","hum":"48","pop":"0","pres":"1017","time":"2018-05-09 13:00","tmp":"27","wind_deg":"209","wind_dir":"SW","wind_sc":"1-2","wind_spd":"9"},{"cloud":"27","cond_code":"100","cond_txt":"Sunny/Clear","dew":"1","hum":"45","pop":"0","pres":"1016","time":"2018-05-09 16:00","tmp":"29","wind_deg":"225","wind_dir":"SW","wind_sc":"3-4","wind_spd":"22"},{"cloud":"79","cond_code":"100","cond_txt":"Sunny/Clear","dew":"4","hum":"41","pop":"0","pres":"1016","time":"2018-05-09 19:00","tmp":"26","wind_deg":"208","wind_dir":"SW","wind_sc":"1-2","wind_spd":"2"},{"cloud":"94","cond_code":"101","cond_txt":"Cloudy","dew":"5","hum":"54","pop":"0","pres":"1017","time":"2018-05-09 22:00","tmp":"22","wind_deg":"177","wind_dir":"S","wind_sc":"1-2","wind_spd":"10"}]
         * lifestyle : [{"type":"comf","brf":"较舒适","txt":"今天夜间天气晴好，您在这种天气条件下，会感觉凉爽、舒适，偏热。"},{"type":"drsg","brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},{"type":"flu","brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},{"type":"sport","brf":"较适宜","txt":"天气较好，但由于风力较大，推荐您在室内进行低强度运动，若在户外运动请注意避风。"},{"type":"trav","brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"},{"type":"uv","brf":"强","txt":"紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。"},{"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"type":"air","brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyBean> hourly;
        private List<LifestyleBean> lifestyle;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public static class BasicBean {
            /**
             * cid : CN101010100
             * location : beijing
             * parent_city : beijing
             * admin_area : beijing
             * cnty : China
             * lat : 39.90498734
             * lon : 116.4052887
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-05-08 22:47
             * utc : 2018-05-08 14:47
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            /**
             * cloud : 0
             * cond_code : 100
             * cond_txt : Sunny/Clear
             * fl : 17
             * hum : 29
             * pcpn : 0.0
             * pres : 1019
             * tmp : 19
             * vis : 10
             * wind_deg : 185
             * wind_dir : S
             * wind_sc : 2
             * wind_spd : 6
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 101
             * cond_code_n : 100
             * cond_txt_d : Cloudy
             * cond_txt_n : Sunny/Clear
             * date : 2018-05-08
             * hum : 22
             * mr : 01:16
             * ms : 11:38
             * pcpn : 0.0
             * pop : 0
             * pres : 1017
             * sr : 05:08
             * ss : 19:16
             * tmp_max : 27
             * tmp_min : 13
             * uv_index : 8
             * vis : 20
             * wind_deg : 180
             * wind_dir : S
             * wind_sc : 1-2
             * wind_spd : 5
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class HourlyBean {
            /**
             * cloud : 0
             * cond_code : 100
             * cond_txt : Sunny/Clear
             * dew : 1
             * hum : 61
             * pop : 0
             * pres : 1018
             * time : 2018-05-09 01:00
             * tmp : 14
             * wind_deg : 182
             * wind_dir : S
             * wind_sc : 1-2
             * wind_spd : 2
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getDew() {
                return dew;
            }

            public void setDew(String dew) {
                this.dew = dew;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class LifestyleBean {
            /**
             * type : comf
             * brf : 较舒适
             * txt : 今天夜间天气晴好，您在这种天气条件下，会感觉凉爽、舒适，偏热。
             */

            private String type;
            private String brf;
            private String txt;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }
}
