package com.eoe.drugstore.bean;

import java.util.List;

/**
 * Created by Jon on 2016/3/7.
 */
public class WelcomBean {
    /**
     * issuccess : true
     * errormsg :
     * resultdata : {"status":3,"msg":"发现新版本，强制升级","ipath":"http://images.818.com/shopimg/2015/06/18/7201.png","itime":"2000000000","iflag":"0","apkurl":"http://action.818.com/modify.apk"}
     */

    private List<ResultEntity> result;

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private boolean issuccess;
        private String errormsg;
        /**
         * status : 3
         * msg : 发现新版本，强制升级
         * ipath : http://images.818.com/shopimg/2015/06/18/7201.png
         * itime : 2000000000
         * iflag : 0
         * apkurl : http://action.818.com/modify.apk
         */

        private ResultdataEntity resultdata;

        public void setIssuccess(boolean issuccess) {
            this.issuccess = issuccess;
        }

        public void setErrormsg(String errormsg) {
            this.errormsg = errormsg;
        }

        public void setResultdata(ResultdataEntity resultdata) {
            this.resultdata = resultdata;
        }

        public boolean isIssuccess() {
            return issuccess;
        }

        public String getErrormsg() {
            return errormsg;
        }

        public ResultdataEntity getResultdata() {
            return resultdata;
        }

        public static class ResultdataEntity {
            private int status;
            private String msg;
            private String ipath;
            private String itime;
            private String iflag;
            private String apkurl;

            public void setStatus(int status) {
                this.status = status;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public void setIpath(String ipath) {
                this.ipath = ipath;
            }

            public void setItime(String itime) {
                this.itime = itime;
            }

            public void setIflag(String iflag) {
                this.iflag = iflag;
            }

            public void setApkurl(String apkurl) {
                this.apkurl = apkurl;
            }

            public int getStatus() {
                return status;
            }

            public String getMsg() {
                return msg;
            }

            public String getIpath() {
                return ipath;
            }

            public String getItime() {
                return itime;
            }

            public String getIflag() {
                return iflag;
            }

            public String getApkurl() {
                return apkurl;
            }
        }
    }
}
