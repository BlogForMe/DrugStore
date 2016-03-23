package com.eoe.drugstore.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/22.
 */
public class BaseBean {
    /**
     * issuccess : true
     * errormsg :
     * resultdata : [{"shopid":10561,"shopname":"永安康健","islottery":"3","druginfo":[{"cartid":1249573,"did":10878613,"drugtype":1,"drugname":"永安康健 代餐粉（5盒25包）  果蔬纤维","mkprice":"299.00","price":"79.00","pharmacode":"otc","shopid":10561,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/10/11149510/150x150/a1.jpg","maxbuynum":88,"num":"1","desinfo":""},{"cartid":1249572,"did":10743431,"drugtype":1,"drugname":"永安康健 蓝莓叶黄素   买2送1（原装）加送眼贴 （请直接更改购买数量）","mkprice":"259.00","price":"79.00","pharmacode":"otc","shopid":10561,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/29/11133829/150x150/a1.jpg","maxbuynum":74,"num":"1","desinfo":""},{"cartid":1249571,"did":10687894,"drugtype":1,"drugname":"永安康健秘鲁进口玛咖 正品黑玛卡 买二送一原装 ","mkprice":"296.00","price":"99.00","pharmacode":"otc","shopid":10561,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/81/11123981/150x150/a1.jpg","maxbuynum":659,"num":"1","desinfo":""}],"lotteryinfo":[],"ship":[]},{"shopid":10523,"shopname":"好一生大药房","islottery":"3","druginfo":[{"cartid":1131543,"did":11167526,"drugtype":1,"drugname":"【鹤鸣山】 过氧苯甲酰凝胶 （15克装）","mkprice":"29.00","price":"12.00","pharmacode":"fotc","shopid":10523,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/13/11087113/150x150/a1.jpg","maxbuynum":2,"num":"2","desinfo":""}],"lotteryinfo":[],"ship":[]},{"shopid":31,"shopname":"西安怡康医药","islottery":"3","druginfo":[{"cartid":1141704,"did":10097235,"drugtype":1,"drugname":"【天士力】 养血清脑颗粒 （9袋装）","mkprice":"25.30","price":"21.00","pharmacode":"fotc","shopid":31,"shopname":null,"status":2,"drugimg":"http://images02.818.com/16/43/76543/150x150/a2.jpg","maxbuynum":12,"num":"1","desinfo":""}],"lotteryinfo":[],"ship":[]},{"shopid":10631,"shopname":"圣益轩大药房","islottery":"3","druginfo":[{"cartid":1141702,"did":11543497,"drugtype":1,"drugname":"【天士力】 养血清脑颗粒 （15袋装）","mkprice":"22.00","price":"22.00","pharmacode":"fotc","shopid":10631,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/77/11006277/150x150/a1.jpg","maxbuynum":200,"num":"1","desinfo":""}],"lotteryinfo":[],"ship":[]},{"shopid":10745,"shopname":"幸福人药品超市\r\n","islottery":"3","druginfo":[{"cartid":1131467,"did":10847241,"drugtype":1,"drugname":"【鹤鸣山】 过氧苯甲酰凝胶 （15克装）","mkprice":"15.00","price":"10.89","pharmacode":"fotc","shopid":10745,"shopname":null,"status":5,"drugimg":"http://images02.818.com/11/13/11087113/150x150/a1.jpg","maxbuynum":11,"num":"1","desinfo":"该商品已下架"}],"lotteryinfo":[],"ship":[]},{"shopid":10117,"shopname":"上海测试药房","islottery":"3","druginfo":[{"cartid":1113547,"did":11440439,"drugtype":1,"drugname":"测试驱害","mkprice":"0.01","price":"0.01","pharmacode":"otc","shopid":10117,"shopname":null,"status":3,"drugimg":"http://images02.818.com/11/02/11196902/150x150/a1.jpg","maxbuynum":200,"num":"1","desinfo":"该商品已下架"}],"lotteryinfo":[],"ship":[]},{"shopid":10215,"shopname":"同康长新大药房","islottery":"3","druginfo":[{"cartid":1078026,"did":10410646,"drugtype":1,"drugname":"【德元堂】 肾衰宁片 (36粒装)","mkprice":"35.00","price":"12.95","pharmacode":"rx","shopid":10215,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/67/11037867/150x150/a1.jpg","maxbuynum":16189,"num":"4","desinfo":""}],"lotteryinfo":[],"ship":[]},{"shopid":10234,"shopname":"润新大药房","islottery":"3","druginfo":[{"cartid":1078039,"did":10431587,"drugtype":1,"drugname":"【消银泰】 苦丹丸 （6袋装）","mkprice":"49.00","price":"15.90","pharmacode":"rx","shopid":10234,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/32/11072832/150x150/a1.jpg","maxbuynum":299,"num":"1","desinfo":""}],"lotteryinfo":[],"ship":[]}]
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private boolean issuccess;
        private String errormsg;
        /**
         * shopid : 10561
         * shopname : 永安康健
         * islottery : 3
         * druginfo : [{"cartid":1249573,"did":10878613,"drugtype":1,"drugname":"永安康健 代餐粉（5盒25包）  果蔬纤维","mkprice":"299.00","price":"79.00","pharmacode":"otc","shopid":10561,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/10/11149510/150x150/a1.jpg","maxbuynum":88,"num":"1","desinfo":""},{"cartid":1249572,"did":10743431,"drugtype":1,"drugname":"永安康健 蓝莓叶黄素   买2送1（原装）加送眼贴 （请直接更改购买数量）","mkprice":"259.00","price":"79.00","pharmacode":"otc","shopid":10561,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/29/11133829/150x150/a1.jpg","maxbuynum":74,"num":"1","desinfo":""},{"cartid":1249571,"did":10687894,"drugtype":1,"drugname":"永安康健秘鲁进口玛咖 正品黑玛卡 买二送一原装 ","mkprice":"296.00","price":"99.00","pharmacode":"otc","shopid":10561,"shopname":null,"status":2,"drugimg":"http://images02.818.com/11/81/11123981/150x150/a1.jpg","maxbuynum":659,"num":"1","desinfo":""}]
         * lotteryinfo : []
         * ship : []
         */

        private List<ShopCartBean.ResultdataBean> resultdata;

        public boolean isIssuccess() {
            return issuccess;
        }

        public void setIssuccess(boolean issuccess) {
            this.issuccess = issuccess;
        }

        public String getErrormsg() {
            return errormsg;
        }

        public void setErrormsg(String errormsg) {
            this.errormsg = errormsg;
        }

        public List<ShopCartBean.ResultdataBean> getResultdata() {
            return resultdata;
        }

        public void setResultdata(List<ShopCartBean.ResultdataBean> resultdata) {
            this.resultdata = resultdata;
        }
    }
}