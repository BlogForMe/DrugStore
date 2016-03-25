package com.eoe.drugstore.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/22.
 */
public class ShopCartBean extends BaseBean {


    public static class ResultdataBean {
        private int shopid;
        private String shopname;
        private String islottery;
        /**
         * cartid : 1249573
         * did : 10878613
         * drugtype : 1
         * drugname : 永安康健 代餐粉（5盒25包）  果蔬纤维
         * mkprice : 299.00
         * price : 79.00
         * pharmacode : otc
         * shopid : 10561
         * shopname : null
         * status : 2
         * drugimg : http://images02.818.com/11/10/11149510/150x150/a1.jpg
         * maxbuynum : 88
         * num : 1
         * desinfo :
         */

        private List<DruginfoBean> druginfo;
        private List<?> lotteryinfo;
        private List<?> ship;
        private Boolean isGSelect =false;

        public int getShopid() {
            return shopid;
        }

        public void setShopid(int shopid) {
            this.shopid = shopid;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getIslottery() {
            return islottery;
        }

        public void setIslottery(String islottery) {
            this.islottery = islottery;
        }

        public List<DruginfoBean> getDruginfo() {
            return druginfo;
        }

        public void setDruginfo(List<DruginfoBean> druginfo) {
            this.druginfo = druginfo;
        }

        public List<?> getLotteryinfo() {
            return lotteryinfo;
        }

        public void setLotteryinfo(List<?> lotteryinfo) {
            this.lotteryinfo = lotteryinfo;
        }

        public List<?> getShip() {
            return ship;
        }

        public void setShip(List<?> ship) {
            this.ship = ship;
        }

        public Boolean getIsGSelect() {
            return isGSelect;
        }

        public void setIsGSelect(Boolean isGSelect) {
            this.isGSelect = isGSelect;
        }

        public static class DruginfoBean {
            private int cartid;
            private int did;
            private int drugtype;
            private String drugname;
            private String mkprice;
            private String price;
            private String pharmacode;
            private int shopid;
            private Object shopname;
            private int status;
            private String drugimg;
            private int maxbuynum;
            private String num;
            private String desinfo;
            private boolean isSelect;

            public int getCartid() {
                return cartid;
            }

            public void setCartid(int cartid) {
                this.cartid = cartid;
            }

            public int getDid() {
                return did;
            }

            public void setDid(int did) {
                this.did = did;
            }

            public int getDrugtype() {
                return drugtype;
            }

            public void setDrugtype(int drugtype) {
                this.drugtype = drugtype;
            }

            public String getDrugname() {
                return drugname;
            }

            public void setDrugname(String drugname) {
                this.drugname = drugname;
            }

            public String getMkprice() {
                return mkprice;
            }

            public void setMkprice(String mkprice) {
                this.mkprice = mkprice;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPharmacode() {
                return pharmacode;
            }

            public void setPharmacode(String pharmacode) {
                this.pharmacode = pharmacode;
            }

            public int getShopid() {
                return shopid;
            }

            public void setShopid(int shopid) {
                this.shopid = shopid;
            }

            public Object getShopname() {
                return shopname;
            }

            public void setShopname(Object shopname) {
                this.shopname = shopname;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getDrugimg() {
                return drugimg;
            }

            public void setDrugimg(String drugimg) {
                this.drugimg = drugimg;
            }

            public int getMaxbuynum() {
                return maxbuynum;
            }

            public void setMaxbuynum(int maxbuynum) {
                this.maxbuynum = maxbuynum;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getDesinfo() {
                return desinfo;
            }

            public void setDesinfo(String desinfo) {
                this.desinfo = desinfo;
            }

            public boolean isSelect() {
                return isSelect;
            }

            public void setIsSelect(boolean isSelect) {
                this.isSelect = isSelect;
            }
        }
    }
}
