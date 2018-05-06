package com.thorn.wego.Element;

import java.util.List;

public class GoogleNavigationJson {
    /**
     * geocoded_waypoints : [{"geocoder_status":"OK","place_id":"ChIJZ14cl7pW8DURm4NfSvuSCeE","types":["street_address"]},{"geocoder_status":"OK","place_id":"ChIJjXmpdUxT8DUR9gIMrgLiS7Q","types":["street_address"]}]
     * routes : [{"bounds":{"northeast":{"lat":39.9972325,"lng":116.4154664},"southwest":{"lat":39.9380797,"lng":116.2975118}},"copyrights":"地图数据 ©2018 GS(2011)6020","legs":[{"distance":{"text":"17.8 公里","value":17840},"duration":{"text":"26分钟","value":1551},"end_address":"中国北京市东城区安定门东大街51号 邮政编码: 100009","end_location":{"lat":39.9491196,"lng":116.4154664},"start_address":"中国北京市海淀区颐和园路5号,北京大学内","start_location":{"lat":39.9971789,"lng":116.3124142},"steps":[{"distance":{"text":"0.1 公里","value":107},"duration":{"text":"1分钟","value":30},"end_location":{"lat":39.99624,"lng":116.3126731},"html_instructions":"向<b>南<\/b>行驶","polyline":{"points":"k}bsFqg|dUn@Kx@KpA["},"start_location":{"lat":39.9971789,"lng":116.3124142},"travel_mode":"DRIVING"},{"distance":{"text":"62 米","value":62},"duration":{"text":"1分钟","value":21},"end_location":{"lat":39.9963295,"lng":116.3133971},"html_instructions":"向<b>左<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-left","polyline":{"points":"owbsFei|dUQqC"},"start_location":{"lat":39.99624,"lng":116.3126731},"travel_mode":"DRIVING"},{"distance":{"text":"91 米","value":91},"duration":{"text":"1分钟","value":28},"end_location":{"lat":39.9971012,"lng":116.3130702},"html_instructions":"向<b>左<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-left","polyline":{"points":"axbsFwm|dUa@Xe@PWHUBc@F"},"start_location":{"lat":39.9963295,"lng":116.3133971},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":177},"duration":{"text":"1分钟","value":50},"end_location":{"lat":39.9972325,"lng":116.3151373},"html_instructions":"向<b>右<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-right","polyline":{"points":"{|bsFuk|dUSqIAOC{@"},"start_location":{"lat":39.9971012,"lng":116.3130702},"travel_mode":"DRIVING"},{"distance":{"text":"1.2 公里","value":1173},"duration":{"text":"3分钟","value":204},"end_location":{"lat":39.9867147,"lng":116.3161287},"html_instructions":"向<b>右<\/b>转，进入<b>中关村北大街<\/b>","maneuver":"turn-right","polyline":{"points":"u}bsFsx|dUJ?|EYxBK|F[n@CxCQVApCO^CJ?r@E|FUdAGD?RArCKVArAEXA~@Cx@E~AEnDK"},"start_location":{"lat":39.9972325,"lng":116.3151373},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":111},"duration":{"text":"1分钟","value":38},"end_location":{"lat":39.9857674,"lng":116.3162166},"html_instructions":"稍向<b>右<\/b>转，继续沿<b>中关村北大街<\/b>前行","maneuver":"turn-slight-right","polyline":{"points":"}{`sFy~|dUp@TjBI\\]"},"start_location":{"lat":39.9867147,"lng":116.3161287},"travel_mode":"DRIVING"},{"distance":{"text":"0.4 公里","value":369},"duration":{"text":"1分钟","value":55},"end_location":{"lat":39.9855952,"lng":116.3118907},"html_instructions":"在<b>中关村一桥<\/b>向<b>右<\/b>急转，进入<b>北四环西路辅路<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"av`sFk_}dU@v@PhK@|@FrD?b@BhC"},"start_location":{"lat":39.9857674,"lng":116.3162166},"travel_mode":"DRIVING"},{"distance":{"text":"0.9 公里","value":943},"duration":{"text":"1分钟","value":65},"end_location":{"lat":39.9850892,"lng":116.3009085},"html_instructions":"稍向<b>左<\/b>转，走<b>北四环西路<\/b>","polyline":{"points":"_u`sFid|dUb@|@FvG?J?H@t@@z@@f@BpABpCB`CHtH?X?\\@n@@`@BtBBnD@dADpCHhJ"},"start_location":{"lat":39.9855952,"lng":116.3118907},"travel_mode":"DRIVING"},{"distance":{"text":"2.6 公里","value":2631},"duration":{"text":"3分钟","value":170},"end_location":{"lat":39.96661,"lng":116.3072591},"html_instructions":"下<b>苏州桥/三环路<\/b>出口走<b>万泉河路<\/b>","maneuver":"ramp-right","polyline":{"points":"yq`sFu_zdU?RC`CAd@?d@GjGDf@Lz@DLBJDFHJJJJJLHVD@?P?JAB?FCNETMHKT]Te@FMb@}@\\u@`AyB`@w@Za@VWVQVQPKLGNEJENETE\\Ev@KxCUbDOtAGbGW`@CfBIv@C~AGjEUN?r@Ch@Ab@Ed@CPCr@IJANEB?\\Ir@WXOh@WXUZSZY^]f@i@\\a@f@w@t@qA^u@nBqD~@cBFMFKx@}A|@eBp@oADKh@s@LMDCHIJG@CRITILEXENCD?TAhBK`BIJArCQfAGvAK"},"start_location":{"lat":39.9850892,"lng":116.3009085},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2257},"duration":{"text":"3分钟","value":166},"end_location":{"lat":39.946444,"lng":116.3098532},"html_instructions":"下<b>左侧<\/b>出口，走<b>西三环北路<\/b>","maneuver":"ramp-left","polyline":{"points":"i~|rFkg{dUpBOxAQlBUbI}@zAOJAJAhAKZE\\CB?JAt@C|@?T@f@C^A\\C^Ar@KVCHENIdAOtDi@^Gf@Gx@KvB[nBWp@IBAdAGl@EpCMjFSH?bBGFAH?|@EjAG`@CfACXA~@CdCGNArDMNAhBG~AGr@EtDMvFMx@?h@@"},"start_location":{"lat":39.96661,"lng":116.3072591},"travel_mode":"DRIVING"},{"distance":{"text":"1.8 公里","value":1806},"duration":{"text":"2分钟","value":135},"end_location":{"lat":39.9387674,"lng":116.3253733},"html_instructions":"下<b>左侧<\/b>的<b>西直门外大街/白石新桥<\/b>出口，走<b>紫竹院路<\/b>","maneuver":"ramp-left","polyline":{"points":"g`yrFqw{dUbAQ`IOn@AVAZ?NAPARCNCREVG\\KPG`@MXM?ATKVOBC^Yp@m@\\_@LOBEDGFG?CRYJS@CBEJQJSTk@b@qA^sAv@qCZkAbAuDXcAZqANo@d@wBVi@He@V}A\\eCPsBFq@TqFJiCNaFD{ALiEJqB@a@@]BeAJcD"},"start_location":{"lat":39.946444,"lng":116.3098532},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2280},"duration":{"text":"2分钟","value":135},"end_location":{"lat":39.940089,"lng":116.3517242},"html_instructions":"继续前行，上<b>西直门外大街<\/b>","polyline":{"points":"ipwrFqx~dUBc@Ba@Bm@@m@FyAFoB@YLmELgDJyCFsBFwAB{@DqA@MDuAFgB?KD}@DkBHuC@eC?A?cB?s@AmBAoA?UI{CK}EG{DAi@E}AEwBIsDA}@?QC{@?UAYCcBAs@Ay@C_AGqAEk@?KACKqA?AE]EUE_@u@yDy@oDi@}BSkAYmBI}@MuAOqBEs@KoAS_C"},"start_location":{"lat":39.9387674,"lng":116.3253733},"travel_mode":"DRIVING"},{"distance":{"text":"5.6 公里","value":5593},"duration":{"text":"7分钟","value":402},"end_location":{"lat":39.9491173,"lng":116.4126744},"html_instructions":"下出口后走<b>北二环<\/b>","maneuver":"ramp-right","polyline":{"points":"qxwrFg}ceUBQ?C@O?U?Q?GGsBCgBE{AAi@AgACg@Ai@A[EYE]GWAAO]CESWACIGKICAMIUEUCg@Ai@?q@@k@Ai@Ae@Ee@Mc@K_@Qa@SUO[UCESQ]]Y_@S]O]Ug@Si@GQ}@qCG[WkAQaAAAw@aEAEI_@SkAc@iC[_BAGq@sDa@uBCM]iBG]g@iCG]COEQGUI[?C]cAY_AOc@[aAk@gBeAgDe@{AWy@m@{BScAQ}@Mo@G]Ga@OaAGg@CWEo@Gw@ACA[AM?MAIAQEsACwAEmAAs@KuCE}AAyCAcAA}AAiC?CA{CA}C?m@@U?]?kAC{@?Q?OAwA?qC?kD?S?qA?m@AwCA_A?{@?yCCcJ?sAEaM?s@?_B?aACwI?A@iG?i@?I?i@?aF?gA?GAcBA}F?}CEaDAqDAgCE{P?iB?oAAmB?[AyFAsFAaAAsDC}LAmCCeC?WAs@"},"start_location":{"lat":39.940089,"lng":116.3517242},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":240},"duration":{"text":"1分钟","value":52},"end_location":{"lat":39.9491196,"lng":116.4154664},"html_instructions":"下<b>地坛/北新桥<\/b>出口走<b>安定门东大街<\/b><div style=\"font-size:0.9em\">目的地在左侧<\/div>","maneuver":"ramp-right","polyline":{"points":"_qyrFezoeUDc@BWHm@Aa@C}AG}DAu@CqA"},"start_location":{"lat":39.9491173,"lng":116.4126744},"travel_mode":"DRIVING"}],"traffic_speed_entry":[],"via_waypoint":[]}],"overview_polyline":{"points":"k}bsFqg|dUhBWpA[QqCa@Xe@Pm@Lc@FSqIEkA`RaArJg@|I_@xLc@xCKnDKp@TjBI\\]R`ML~Kb@|@FvG?THjFPbR\\v]E`FGjGDf@RhAHRTVXTVDb@AVI^Yj@cAj@kA~AoD`@w@r@y@n@c@z@_@d@KtAQxCUbDOxI_@`HYzEU|AEnCW|@QlAg@bAm@v@m@fAgAdAyAtAgC~DoHnD_Hv@aANMLKh@S|@OlFYzEYhE[fRuB|BUbBIrA@fAE|@EjAOXOzFy@xFw@`Da@hAI~DStFSrDOnEQhK[lGWlL[bB@bAQ`IOfACpAGb@It@SlAe@l@[b@]nAmAPU`@m@P]Ve@x@}BvDgNt@uCt@gDVi@He@t@cFXeD`@{Jn@yR`@kM^qLh@mOd@oOJ{G?eBCgGw@g`@QoKOmCWgC{@yEcBmHm@yDWsCu@uJBU@e@KuFMuFCeAKw@IYSc@U[UQQKk@Ig@A{A@uACkAScA]w@c@_@[q@o@m@}@e@eA[{@eAmDcBqIcA{FcEqTYuAaAcD}CuJ}@uCaA_Eo@mDWiBIgAMeBI}BWoJE}AAyCCaDEgM@mDEuD?cLMui@AmZ?{ICaJE_II_^CsMIg\\G_JH{@Hm@Aa@K{GEgC"},"summary":"北二环","warnings":[],"waypoint_order":[]}]
     * status : OK
     */

    private String status;
    private List<GeocodedWaypointsBean> geocoded_waypoints;
    private List<RoutesBean> routes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GeocodedWaypointsBean> getGeocoded_waypoints() {
        return geocoded_waypoints;
    }

    public void setGeocoded_waypoints(List<GeocodedWaypointsBean> geocoded_waypoints) {
        this.geocoded_waypoints = geocoded_waypoints;
    }

    public List<RoutesBean> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutesBean> routes) {
        this.routes = routes;
    }

    public static class GeocodedWaypointsBean {
        /**
         * geocoder_status : OK
         * place_id : ChIJZ14cl7pW8DURm4NfSvuSCeE
         * types : ["street_address"]
         */

        private String geocoder_status;
        private String place_id;
        private List<String> types;

        public String getGeocoder_status() {
            return geocoder_status;
        }

        public void setGeocoder_status(String geocoder_status) {
            this.geocoder_status = geocoder_status;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }
    }

    public static class RoutesBean {
        /**
         * bounds : {"northeast":{"lat":39.9972325,"lng":116.4154664},"southwest":{"lat":39.9380797,"lng":116.2975118}}
         * copyrights : 地图数据 ©2018 GS(2011)6020
         * legs : [{"distance":{"text":"17.8 公里","value":17840},"duration":{"text":"26分钟","value":1551},"end_address":"中国北京市东城区安定门东大街51号 邮政编码: 100009","end_location":{"lat":39.9491196,"lng":116.4154664},"start_address":"中国北京市海淀区颐和园路5号,北京大学内","start_location":{"lat":39.9971789,"lng":116.3124142},"steps":[{"distance":{"text":"0.1 公里","value":107},"duration":{"text":"1分钟","value":30},"end_location":{"lat":39.99624,"lng":116.3126731},"html_instructions":"向<b>南<\/b>行驶","polyline":{"points":"k}bsFqg|dUn@Kx@KpA["},"start_location":{"lat":39.9971789,"lng":116.3124142},"travel_mode":"DRIVING"},{"distance":{"text":"62 米","value":62},"duration":{"text":"1分钟","value":21},"end_location":{"lat":39.9963295,"lng":116.3133971},"html_instructions":"向<b>左<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-left","polyline":{"points":"owbsFei|dUQqC"},"start_location":{"lat":39.99624,"lng":116.3126731},"travel_mode":"DRIVING"},{"distance":{"text":"91 米","value":91},"duration":{"text":"1分钟","value":28},"end_location":{"lat":39.9971012,"lng":116.3130702},"html_instructions":"向<b>左<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-left","polyline":{"points":"axbsFwm|dUa@Xe@PWHUBc@F"},"start_location":{"lat":39.9963295,"lng":116.3133971},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":177},"duration":{"text":"1分钟","value":50},"end_location":{"lat":39.9972325,"lng":116.3151373},"html_instructions":"向<b>右<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-right","polyline":{"points":"{|bsFuk|dUSqIAOC{@"},"start_location":{"lat":39.9971012,"lng":116.3130702},"travel_mode":"DRIVING"},{"distance":{"text":"1.2 公里","value":1173},"duration":{"text":"3分钟","value":204},"end_location":{"lat":39.9867147,"lng":116.3161287},"html_instructions":"向<b>右<\/b>转，进入<b>中关村北大街<\/b>","maneuver":"turn-right","polyline":{"points":"u}bsFsx|dUJ?|EYxBK|F[n@CxCQVApCO^CJ?r@E|FUdAGD?RArCKVArAEXA~@Cx@E~AEnDK"},"start_location":{"lat":39.9972325,"lng":116.3151373},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":111},"duration":{"text":"1分钟","value":38},"end_location":{"lat":39.9857674,"lng":116.3162166},"html_instructions":"稍向<b>右<\/b>转，继续沿<b>中关村北大街<\/b>前行","maneuver":"turn-slight-right","polyline":{"points":"}{`sFy~|dUp@TjBI\\]"},"start_location":{"lat":39.9867147,"lng":116.3161287},"travel_mode":"DRIVING"},{"distance":{"text":"0.4 公里","value":369},"duration":{"text":"1分钟","value":55},"end_location":{"lat":39.9855952,"lng":116.3118907},"html_instructions":"在<b>中关村一桥<\/b>向<b>右<\/b>急转，进入<b>北四环西路辅路<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"av`sFk_}dU@v@PhK@|@FrD?b@BhC"},"start_location":{"lat":39.9857674,"lng":116.3162166},"travel_mode":"DRIVING"},{"distance":{"text":"0.9 公里","value":943},"duration":{"text":"1分钟","value":65},"end_location":{"lat":39.9850892,"lng":116.3009085},"html_instructions":"稍向<b>左<\/b>转，走<b>北四环西路<\/b>","polyline":{"points":"_u`sFid|dUb@|@FvG?J?H@t@@z@@f@BpABpCB`CHtH?X?\\@n@@`@BtBBnD@dADpCHhJ"},"start_location":{"lat":39.9855952,"lng":116.3118907},"travel_mode":"DRIVING"},{"distance":{"text":"2.6 公里","value":2631},"duration":{"text":"3分钟","value":170},"end_location":{"lat":39.96661,"lng":116.3072591},"html_instructions":"下<b>苏州桥/三环路<\/b>出口走<b>万泉河路<\/b>","maneuver":"ramp-right","polyline":{"points":"yq`sFu_zdU?RC`CAd@?d@GjGDf@Lz@DLBJDFHJJJJJLHVD@?P?JAB?FCNETMHKT]Te@FMb@}@\\u@`AyB`@w@Za@VWVQVQPKLGNEJENETE\\Ev@KxCUbDOtAGbGW`@CfBIv@C~AGjEUN?r@Ch@Ab@Ed@CPCr@IJANEB?\\Ir@WXOh@WXUZSZY^]f@i@\\a@f@w@t@qA^u@nBqD~@cBFMFKx@}A|@eBp@oADKh@s@LMDCHIJG@CRITILEXENCD?TAhBK`BIJArCQfAGvAK"},"start_location":{"lat":39.9850892,"lng":116.3009085},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2257},"duration":{"text":"3分钟","value":166},"end_location":{"lat":39.946444,"lng":116.3098532},"html_instructions":"下<b>左侧<\/b>出口，走<b>西三环北路<\/b>","maneuver":"ramp-left","polyline":{"points":"i~|rFkg{dUpBOxAQlBUbI}@zAOJAJAhAKZE\\CB?JAt@C|@?T@f@C^A\\C^Ar@KVCHENIdAOtDi@^Gf@Gx@KvB[nBWp@IBAdAGl@EpCMjFSH?bBGFAH?|@EjAG`@CfACXA~@CdCGNArDMNAhBG~AGr@EtDMvFMx@?h@@"},"start_location":{"lat":39.96661,"lng":116.3072591},"travel_mode":"DRIVING"},{"distance":{"text":"1.8 公里","value":1806},"duration":{"text":"2分钟","value":135},"end_location":{"lat":39.9387674,"lng":116.3253733},"html_instructions":"下<b>左侧<\/b>的<b>西直门外大街/白石新桥<\/b>出口，走<b>紫竹院路<\/b>","maneuver":"ramp-left","polyline":{"points":"g`yrFqw{dUbAQ`IOn@AVAZ?NAPARCNCREVG\\KPG`@MXM?ATKVOBC^Yp@m@\\_@LOBEDGFG?CRYJS@CBEJQJSTk@b@qA^sAv@qCZkAbAuDXcAZqANo@d@wBVi@He@V}A\\eCPsBFq@TqFJiCNaFD{ALiEJqB@a@@]BeAJcD"},"start_location":{"lat":39.946444,"lng":116.3098532},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2280},"duration":{"text":"2分钟","value":135},"end_location":{"lat":39.940089,"lng":116.3517242},"html_instructions":"继续前行，上<b>西直门外大街<\/b>","polyline":{"points":"ipwrFqx~dUBc@Ba@Bm@@m@FyAFoB@YLmELgDJyCFsBFwAB{@DqA@MDuAFgB?KD}@DkBHuC@eC?A?cB?s@AmBAoA?UI{CK}EG{DAi@E}AEwBIsDA}@?QC{@?UAYCcBAs@Ay@C_AGqAEk@?KACKqA?AE]EUE_@u@yDy@oDi@}BSkAYmBI}@MuAOqBEs@KoAS_C"},"start_location":{"lat":39.9387674,"lng":116.3253733},"travel_mode":"DRIVING"},{"distance":{"text":"5.6 公里","value":5593},"duration":{"text":"7分钟","value":402},"end_location":{"lat":39.9491173,"lng":116.4126744},"html_instructions":"下出口后走<b>北二环<\/b>","maneuver":"ramp-right","polyline":{"points":"qxwrFg}ceUBQ?C@O?U?Q?GGsBCgBE{AAi@AgACg@Ai@A[EYE]GWAAO]CESWACIGKICAMIUEUCg@Ai@?q@@k@Ai@Ae@Ee@Mc@K_@Qa@SUO[UCESQ]]Y_@S]O]Ug@Si@GQ}@qCG[WkAQaAAAw@aEAEI_@SkAc@iC[_BAGq@sDa@uBCM]iBG]g@iCG]COEQGUI[?C]cAY_AOc@[aAk@gBeAgDe@{AWy@m@{BScAQ}@Mo@G]Ga@OaAGg@CWEo@Gw@ACA[AM?MAIAQEsACwAEmAAs@KuCE}AAyCAcAA}AAiC?CA{CA}C?m@@U?]?kAC{@?Q?OAwA?qC?kD?S?qA?m@AwCA_A?{@?yCCcJ?sAEaM?s@?_B?aACwI?A@iG?i@?I?i@?aF?gA?GAcBA}F?}CEaDAqDAgCE{P?iB?oAAmB?[AyFAsFAaAAsDC}LAmCCeC?WAs@"},"start_location":{"lat":39.940089,"lng":116.3517242},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":240},"duration":{"text":"1分钟","value":52},"end_location":{"lat":39.9491196,"lng":116.4154664},"html_instructions":"下<b>地坛/北新桥<\/b>出口走<b>安定门东大街<\/b><div style=\"font-size:0.9em\">目的地在左侧<\/div>","maneuver":"ramp-right","polyline":{"points":"_qyrFezoeUDc@BWHm@Aa@C}AG}DAu@CqA"},"start_location":{"lat":39.9491173,"lng":116.4126744},"travel_mode":"DRIVING"}],"traffic_speed_entry":[],"via_waypoint":[]}]
         * overview_polyline : {"points":"k}bsFqg|dUhBWpA[QqCa@Xe@Pm@Lc@FSqIEkA`RaArJg@|I_@xLc@xCKnDKp@TjBI\\]R`ML~Kb@|@FvG?THjFPbR\\v]E`FGjGDf@RhAHRTVXTVDb@AVI^Yj@cAj@kA~AoD`@w@r@y@n@c@z@_@d@KtAQxCUbDOxI_@`HYzEU|AEnCW|@QlAg@bAm@v@m@fAgAdAyAtAgC~DoHnD_Hv@aANMLKh@S|@OlFYzEYhE[fRuB|BUbBIrA@fAE|@EjAOXOzFy@xFw@`Da@hAI~DStFSrDOnEQhK[lGWlL[bB@bAQ`IOfACpAGb@It@SlAe@l@[b@]nAmAPU`@m@P]Ve@x@}BvDgNt@uCt@gDVi@He@t@cFXeD`@{Jn@yR`@kM^qLh@mOd@oOJ{G?eBCgGw@g`@QoKOmCWgC{@yEcBmHm@yDWsCu@uJBU@e@KuFMuFCeAKw@IYSc@U[UQQKk@Ig@A{A@uACkAScA]w@c@_@[q@o@m@}@e@eA[{@eAmDcBqIcA{FcEqTYuAaAcD}CuJ}@uCaA_Eo@mDWiBIgAMeBI}BWoJE}AAyCCaDEgM@mDEuD?cLMui@AmZ?{ICaJE_II_^CsMIg\\G_JH{@Hm@Aa@K{GEgC"}
         * summary : 北二环
         * warnings : []
         * waypoint_order : []
         */

        private BoundsBean bounds;
        private String copyrights;
        private OverviewPolylineBean overview_polyline;
        private String summary;
        private List<LegsBean> legs;
        private List<?> warnings;
        private List<?> waypoint_order;

        public BoundsBean getBounds() {
            return bounds;
        }

        public void setBounds(BoundsBean bounds) {
            this.bounds = bounds;
        }

        public String getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(String copyrights) {
            this.copyrights = copyrights;
        }

        public OverviewPolylineBean getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(OverviewPolylineBean overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<LegsBean> getLegs() {
            return legs;
        }

        public void setLegs(List<LegsBean> legs) {
            this.legs = legs;
        }

        public List<?> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<?> warnings) {
            this.warnings = warnings;
        }

        public List<?> getWaypoint_order() {
            return waypoint_order;
        }

        public void setWaypoint_order(List<?> waypoint_order) {
            this.waypoint_order = waypoint_order;
        }

        public static class BoundsBean {
            /**
             * northeast : {"lat":39.9972325,"lng":116.4154664}
             * southwest : {"lat":39.9380797,"lng":116.2975118}
             */

            private NortheastBean northeast;
            private SouthwestBean southwest;

            public NortheastBean getNortheast() {
                return northeast;
            }

            public void setNortheast(NortheastBean northeast) {
                this.northeast = northeast;
            }

            public SouthwestBean getSouthwest() {
                return southwest;
            }

            public void setSouthwest(SouthwestBean southwest) {
                this.southwest = southwest;
            }

            public static class NortheastBean {
                /**
                 * lat : 39.9972325
                 * lng : 116.4154664
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class SouthwestBean {
                /**
                 * lat : 39.9380797
                 * lng : 116.2975118
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }
        }

        public static class OverviewPolylineBean {
            /**
             * points : k}bsFqg|dUhBWpA[QqCa@Xe@Pm@Lc@FSqIEkA`RaArJg@|I_@xLc@xCKnDKp@TjBI\]R`ML~Kb@|@FvG?THjFPbR\v]E`FGjGDf@RhAHRTVXTVDb@AVI^Yj@cAj@kA~AoD`@w@r@y@n@c@z@_@d@KtAQxCUbDOxI_@`HYzEU|AEnCW|@QlAg@bAm@v@m@fAgAdAyAtAgC~DoHnD_Hv@aANMLKh@S|@OlFYzEYhE[fRuB|BUbBIrA@fAE|@EjAOXOzFy@xFw@`Da@hAI~DStFSrDOnEQhK[lGWlL[bB@bAQ`IOfACpAGb@It@SlAe@l@[b@]nAmAPU`@m@P]Ve@x@}BvDgNt@uCt@gDVi@He@t@cFXeD`@{Jn@yR`@kM^qLh@mOd@oOJ{G?eBCgGw@g`@QoKOmCWgC{@yEcBmHm@yDWsCu@uJBU@e@KuFMuFCeAKw@IYSc@U[UQQKk@Ig@A{A@uACkAScA]w@c@_@[q@o@m@}@e@eA[{@eAmDcBqIcA{FcEqTYuAaAcD}CuJ}@uCaA_Eo@mDWiBIgAMeBI}BWoJE}AAyCCaDEgM@mDEuD?cLMui@AmZ?{ICaJE_II_^CsMIg\G_JH{@Hm@Aa@K{GEgC
             */

            private String points;

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }
        }

        public static class LegsBean {
            /**
             * distance : {"text":"17.8 公里","value":17840}
             * duration : {"text":"26分钟","value":1551}
             * end_address : 中国北京市东城区安定门东大街51号 邮政编码: 100009
             * end_location : {"lat":39.9491196,"lng":116.4154664}
             * start_address : 中国北京市海淀区颐和园路5号,北京大学内
             * start_location : {"lat":39.9971789,"lng":116.3124142}
             * steps : [{"distance":{"text":"0.1 公里","value":107},"duration":{"text":"1分钟","value":30},"end_location":{"lat":39.99624,"lng":116.3126731},"html_instructions":"向<b>南<\/b>行驶","polyline":{"points":"k}bsFqg|dUn@Kx@KpA["},"start_location":{"lat":39.9971789,"lng":116.3124142},"travel_mode":"DRIVING"},{"distance":{"text":"62 米","value":62},"duration":{"text":"1分钟","value":21},"end_location":{"lat":39.9963295,"lng":116.3133971},"html_instructions":"向<b>左<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-left","polyline":{"points":"owbsFei|dUQqC"},"start_location":{"lat":39.99624,"lng":116.3126731},"travel_mode":"DRIVING"},{"distance":{"text":"91 米","value":91},"duration":{"text":"1分钟","value":28},"end_location":{"lat":39.9971012,"lng":116.3130702},"html_instructions":"向<b>左<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-left","polyline":{"points":"axbsFwm|dUa@Xe@PWHUBc@F"},"start_location":{"lat":39.9963295,"lng":116.3133971},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":177},"duration":{"text":"1分钟","value":50},"end_location":{"lat":39.9972325,"lng":116.3151373},"html_instructions":"向<b>右<\/b>转，前往<b>中关村北大街<\/b>","maneuver":"turn-right","polyline":{"points":"{|bsFuk|dUSqIAOC{@"},"start_location":{"lat":39.9971012,"lng":116.3130702},"travel_mode":"DRIVING"},{"distance":{"text":"1.2 公里","value":1173},"duration":{"text":"3分钟","value":204},"end_location":{"lat":39.9867147,"lng":116.3161287},"html_instructions":"向<b>右<\/b>转，进入<b>中关村北大街<\/b>","maneuver":"turn-right","polyline":{"points":"u}bsFsx|dUJ?|EYxBK|F[n@CxCQVApCO^CJ?r@E|FUdAGD?RArCKVArAEXA~@Cx@E~AEnDK"},"start_location":{"lat":39.9972325,"lng":116.3151373},"travel_mode":"DRIVING"},{"distance":{"text":"0.1 公里","value":111},"duration":{"text":"1分钟","value":38},"end_location":{"lat":39.9857674,"lng":116.3162166},"html_instructions":"稍向<b>右<\/b>转，继续沿<b>中关村北大街<\/b>前行","maneuver":"turn-slight-right","polyline":{"points":"}{`sFy~|dUp@TjBI\\]"},"start_location":{"lat":39.9867147,"lng":116.3161287},"travel_mode":"DRIVING"},{"distance":{"text":"0.4 公里","value":369},"duration":{"text":"1分钟","value":55},"end_location":{"lat":39.9855952,"lng":116.3118907},"html_instructions":"在<b>中关村一桥<\/b>向<b>右<\/b>急转，进入<b>北四环西路辅路<\/b>","maneuver":"turn-sharp-right","polyline":{"points":"av`sFk_}dU@v@PhK@|@FrD?b@BhC"},"start_location":{"lat":39.9857674,"lng":116.3162166},"travel_mode":"DRIVING"},{"distance":{"text":"0.9 公里","value":943},"duration":{"text":"1分钟","value":65},"end_location":{"lat":39.9850892,"lng":116.3009085},"html_instructions":"稍向<b>左<\/b>转，走<b>北四环西路<\/b>","polyline":{"points":"_u`sFid|dUb@|@FvG?J?H@t@@z@@f@BpABpCB`CHtH?X?\\@n@@`@BtBBnD@dADpCHhJ"},"start_location":{"lat":39.9855952,"lng":116.3118907},"travel_mode":"DRIVING"},{"distance":{"text":"2.6 公里","value":2631},"duration":{"text":"3分钟","value":170},"end_location":{"lat":39.96661,"lng":116.3072591},"html_instructions":"下<b>苏州桥/三环路<\/b>出口走<b>万泉河路<\/b>","maneuver":"ramp-right","polyline":{"points":"yq`sFu_zdU?RC`CAd@?d@GjGDf@Lz@DLBJDFHJJJJJLHVD@?P?JAB?FCNETMHKT]Te@FMb@}@\\u@`AyB`@w@Za@VWVQVQPKLGNEJENETE\\Ev@KxCUbDOtAGbGW`@CfBIv@C~AGjEUN?r@Ch@Ab@Ed@CPCr@IJANEB?\\Ir@WXOh@WXUZSZY^]f@i@\\a@f@w@t@qA^u@nBqD~@cBFMFKx@}A|@eBp@oADKh@s@LMDCHIJG@CRITILEXENCD?TAhBK`BIJArCQfAGvAK"},"start_location":{"lat":39.9850892,"lng":116.3009085},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2257},"duration":{"text":"3分钟","value":166},"end_location":{"lat":39.946444,"lng":116.3098532},"html_instructions":"下<b>左侧<\/b>出口，走<b>西三环北路<\/b>","maneuver":"ramp-left","polyline":{"points":"i~|rFkg{dUpBOxAQlBUbI}@zAOJAJAhAKZE\\CB?JAt@C|@?T@f@C^A\\C^Ar@KVCHENIdAOtDi@^Gf@Gx@KvB[nBWp@IBAdAGl@EpCMjFSH?bBGFAH?|@EjAG`@CfACXA~@CdCGNArDMNAhBG~AGr@EtDMvFMx@?h@@"},"start_location":{"lat":39.96661,"lng":116.3072591},"travel_mode":"DRIVING"},{"distance":{"text":"1.8 公里","value":1806},"duration":{"text":"2分钟","value":135},"end_location":{"lat":39.9387674,"lng":116.3253733},"html_instructions":"下<b>左侧<\/b>的<b>西直门外大街/白石新桥<\/b>出口，走<b>紫竹院路<\/b>","maneuver":"ramp-left","polyline":{"points":"g`yrFqw{dUbAQ`IOn@AVAZ?NAPARCNCREVG\\KPG`@MXM?ATKVOBC^Yp@m@\\_@LOBEDGFG?CRYJS@CBEJQJSTk@b@qA^sAv@qCZkAbAuDXcAZqANo@d@wBVi@He@V}A\\eCPsBFq@TqFJiCNaFD{ALiEJqB@a@@]BeAJcD"},"start_location":{"lat":39.946444,"lng":116.3098532},"travel_mode":"DRIVING"},{"distance":{"text":"2.3 公里","value":2280},"duration":{"text":"2分钟","value":135},"end_location":{"lat":39.940089,"lng":116.3517242},"html_instructions":"继续前行，上<b>西直门外大街<\/b>","polyline":{"points":"ipwrFqx~dUBc@Ba@Bm@@m@FyAFoB@YLmELgDJyCFsBFwAB{@DqA@MDuAFgB?KD}@DkBHuC@eC?A?cB?s@AmBAoA?UI{CK}EG{DAi@E}AEwBIsDA}@?QC{@?UAYCcBAs@Ay@C_AGqAEk@?KACKqA?AE]EUE_@u@yDy@oDi@}BSkAYmBI}@MuAOqBEs@KoAS_C"},"start_location":{"lat":39.9387674,"lng":116.3253733},"travel_mode":"DRIVING"},{"distance":{"text":"5.6 公里","value":5593},"duration":{"text":"7分钟","value":402},"end_location":{"lat":39.9491173,"lng":116.4126744},"html_instructions":"下出口后走<b>北二环<\/b>","maneuver":"ramp-right","polyline":{"points":"qxwrFg}ceUBQ?C@O?U?Q?GGsBCgBE{AAi@AgACg@Ai@A[EYE]GWAAO]CESWACIGKICAMIUEUCg@Ai@?q@@k@Ai@Ae@Ee@Mc@K_@Qa@SUO[UCESQ]]Y_@S]O]Ug@Si@GQ}@qCG[WkAQaAAAw@aEAEI_@SkAc@iC[_BAGq@sDa@uBCM]iBG]g@iCG]COEQGUI[?C]cAY_AOc@[aAk@gBeAgDe@{AWy@m@{BScAQ}@Mo@G]Ga@OaAGg@CWEo@Gw@ACA[AM?MAIAQEsACwAEmAAs@KuCE}AAyCAcAA}AAiC?CA{CA}C?m@@U?]?kAC{@?Q?OAwA?qC?kD?S?qA?m@AwCA_A?{@?yCCcJ?sAEaM?s@?_B?aACwI?A@iG?i@?I?i@?aF?gA?GAcBA}F?}CEaDAqDAgCE{P?iB?oAAmB?[AyFAsFAaAAsDC}LAmCCeC?WAs@"},"start_location":{"lat":39.940089,"lng":116.3517242},"travel_mode":"DRIVING"},{"distance":{"text":"0.2 公里","value":240},"duration":{"text":"1分钟","value":52},"end_location":{"lat":39.9491196,"lng":116.4154664},"html_instructions":"下<b>地坛/北新桥<\/b>出口走<b>安定门东大街<\/b><div style=\"font-size:0.9em\">目的地在左侧<\/div>","maneuver":"ramp-right","polyline":{"points":"_qyrFezoeUDc@BWHm@Aa@C}AG}DAu@CqA"},"start_location":{"lat":39.9491173,"lng":116.4126744},"travel_mode":"DRIVING"}]
             * traffic_speed_entry : []
             * via_waypoint : []
             */

            private DistanceBean distance;
            private DurationBean duration;
            private String end_address;
            private EndLocationBean end_location;
            private String start_address;
            private StartLocationBean start_location;
            private List<StepsBean> steps;
            private List<?> traffic_speed_entry;
            private List<?> via_waypoint;

            public DistanceBean getDistance() {
                return distance;
            }

            public void setDistance(DistanceBean distance) {
                this.distance = distance;
            }

            public DurationBean getDuration() {
                return duration;
            }

            public void setDuration(DurationBean duration) {
                this.duration = duration;
            }

            public String getEnd_address() {
                return end_address;
            }

            public void setEnd_address(String end_address) {
                this.end_address = end_address;
            }

            public EndLocationBean getEnd_location() {
                return end_location;
            }

            public void setEnd_location(EndLocationBean end_location) {
                this.end_location = end_location;
            }

            public String getStart_address() {
                return start_address;
            }

            public void setStart_address(String start_address) {
                this.start_address = start_address;
            }

            public StartLocationBean getStart_location() {
                return start_location;
            }

            public void setStart_location(StartLocationBean start_location) {
                this.start_location = start_location;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            public List<?> getTraffic_speed_entry() {
                return traffic_speed_entry;
            }

            public void setTraffic_speed_entry(List<?> traffic_speed_entry) {
                this.traffic_speed_entry = traffic_speed_entry;
            }

            public List<?> getVia_waypoint() {
                return via_waypoint;
            }

            public void setVia_waypoint(List<?> via_waypoint) {
                this.via_waypoint = via_waypoint;
            }

            public static class DistanceBean {
                /**
                 * text : 17.8 公里
                 * value : 17840
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DurationBean {
                /**
                 * text : 26分钟
                 * value : 1551
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class EndLocationBean {
                /**
                 * lat : 39.9491196
                 * lng : 116.4154664
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StartLocationBean {
                /**
                 * lat : 39.9971789
                 * lng : 116.3124142
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StepsBean {
                /**
                 * distance : {"text":"0.1 公里","value":107}
                 * duration : {"text":"1分钟","value":30}
                 * end_location : {"lat":39.99624,"lng":116.3126731}
                 * html_instructions : 向<b>南</b>行驶
                 * polyline : {"points":"k}bsFqg|dUn@Kx@KpA["}
                 * start_location : {"lat":39.9971789,"lng":116.3124142}
                 * travel_mode : DRIVING
                 * maneuver : turn-left
                 */

                private DistanceBeanX distance;
                private DurationBeanX duration;
                private EndLocationBeanX end_location;
                private String html_instructions;
                private PolylineBean polyline;
                private StartLocationBeanX start_location;
                private String travel_mode;
                private String maneuver;

                public DistanceBeanX getDistance() {
                    return distance;
                }

                public void setDistance(DistanceBeanX distance) {
                    this.distance = distance;
                }

                public DurationBeanX getDuration() {
                    return duration;
                }

                public void setDuration(DurationBeanX duration) {
                    this.duration = duration;
                }

                public EndLocationBeanX getEnd_location() {
                    return end_location;
                }

                public void setEnd_location(EndLocationBeanX end_location) {
                    this.end_location = end_location;
                }

                public String getHtml_instructions() {
                    return html_instructions;
                }

                public void setHtml_instructions(String html_instructions) {
                    this.html_instructions = html_instructions;
                }

                public PolylineBean getPolyline() {
                    return polyline;
                }

                public void setPolyline(PolylineBean polyline) {
                    this.polyline = polyline;
                }

                public StartLocationBeanX getStart_location() {
                    return start_location;
                }

                public void setStart_location(StartLocationBeanX start_location) {
                    this.start_location = start_location;
                }

                public String getTravel_mode() {
                    return travel_mode;
                }

                public void setTravel_mode(String travel_mode) {
                    this.travel_mode = travel_mode;
                }

                public String getManeuver() {
                    return maneuver;
                }

                public void setManeuver(String maneuver) {
                    this.maneuver = maneuver;
                }

                public static class DistanceBeanX {
                    /**
                     * text : 0.1 公里
                     * value : 107
                     */

                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class DurationBeanX {
                    /**
                     * text : 1分钟
                     * value : 30
                     */

                    private String text;
                    private int value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public int getValue() {
                        return value;
                    }

                    public void setValue(int value) {
                        this.value = value;
                    }
                }

                public static class EndLocationBeanX {
                    /**
                     * lat : 39.99624
                     * lng : 116.3126731
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class PolylineBean {
                    /**
                     * points : k}bsFqg|dUn@Kx@KpA[
                     */

                    private String points;

                    public String getPoints() {
                        return points;
                    }

                    public void setPoints(String points) {
                        this.points = points;
                    }
                }

                public static class StartLocationBeanX {
                    /**
                     * lat : 39.9971789
                     * lng : 116.3124142
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }
    }
}
