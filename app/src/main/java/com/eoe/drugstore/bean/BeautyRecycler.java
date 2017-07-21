package com.eoe.drugstore.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BeautyRecycler {

    /**
     * state : true
     * hmList : [{"h_title":"春风十里不如你 0","h_describe":"平儿生日致函助攻一家团聚 0","h_imgurl":"/VideoServer/img/recycler_0.jpg"},{"h_title":"春风十里不如你 1","h_describe":"平儿生日致函助攻一家团聚 1","h_imgurl":"/VideoServer/img/recycler_1.jpg"},{"h_title":"春风十里不如你 2","h_describe":"平儿生日致函助攻一家团聚 2","h_imgurl":"/VideoServer/img/recycler_2.jpg"},{"h_title":"春风十里不如你 3","h_describe":"平儿生日致函助攻一家团聚 3","h_imgurl":"/VideoServer/img/recycler_3.jpg"},{"h_title":"春风十里不如你 4","h_describe":"平儿生日致函助攻一家团聚 4","h_imgurl":"/VideoServer/img/recycler_4.jpg"},{"h_title":"春风十里不如你 5","h_describe":"平儿生日致函助攻一家团聚 5","h_imgurl":"/VideoServer/img/recycler_5.jpg"},{"h_title":"春风十里不如你 6","h_describe":"平儿生日致函助攻一家团聚 6","h_imgurl":"/VideoServer/img/recycler_6.jpg"},{"h_title":"春风十里不如你 7","h_describe":"平儿生日致函助攻一家团聚 7","h_imgurl":"/VideoServer/img/recycler_7.jpg"},{"h_title":"春风十里不如你 8","h_describe":"平儿生日致函助攻一家团聚 8","h_imgurl":"/VideoServer/img/recycler_8.jpg"},{"h_title":"春风十里不如你 9","h_describe":"平儿生日致函助攻一家团聚 9","h_imgurl":"/VideoServer/img/recycler_9.jpg"},{"h_title":"春风十里不如你 10","h_describe":"平儿生日致函助攻一家团聚 10","h_imgurl":"/VideoServer/img/recycler_10.jpg"},{"h_title":"春风十里不如你 11","h_describe":"平儿生日致函助攻一家团聚 11","h_imgurl":"/VideoServer/img/recycler_11.jpg"},{"h_title":"春风十里不如你 12","h_describe":"平儿生日致函助攻一家团聚 12","h_imgurl":"/VideoServer/img/recycler_12.jpg"},{"h_title":"春风十里不如你 13","h_describe":"平儿生日致函助攻一家团聚 13","h_imgurl":"/VideoServer/img/recycler_13.jpg"},{"h_title":"春风十里不如你 14","h_describe":"平儿生日致函助攻一家团聚 14","h_imgurl":"/VideoServer/img/recycler_14.jpg"}]
     */

    private boolean state;
    private List<HmListBean> hmList;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<HmListBean> getHmList() {
        return hmList;
    }

    public void setHmList(List<HmListBean> hmList) {
        this.hmList = hmList;
    }

    public static class HmListBean {
        /**
         * h_title : 春风十里不如你 0
         * h_describe : 平儿生日致函助攻一家团聚 0
         * h_imgurl : /VideoServer/img/recycler_0.jpg
         */

        private String h_title;
        private String h_describe;
        private String h_imgurl;

        public String getH_title() {
            return h_title;
        }

        public void setH_title(String h_title) {
            this.h_title = h_title;
        }

        public String getH_describe() {
            return h_describe;
        }

        public void setH_describe(String h_describe) {
            this.h_describe = h_describe;
        }

        public String getH_imgurl() {
            return h_imgurl;
        }

        public void setH_imgurl(String h_imgurl) {
            this.h_imgurl = h_imgurl;
        }
    }
}
