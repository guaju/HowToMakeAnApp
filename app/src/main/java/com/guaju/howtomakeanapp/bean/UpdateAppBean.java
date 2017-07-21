package com.guaju.howtomakeanapp.bean;

/**
 * Created by guaju on 2017/7/21.
 */

public class UpdateAppBean {

    /**
     * status : 200
     * data : {"version":"1.0.1","info":"添加了支付功能，添加了用户的定位功能...","appurl":"https: //guaju.github.io/1.0.1.apk"}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * version : 1.0.1
         * info : 添加了支付功能，添加了用户的定位功能...
         * appurl : https: //guaju.github.io/1.0.1.apk
         */

        private String version;
        private String info;
        private String appurl;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getAppurl() {
            return appurl;
        }

        public void setAppurl(String appurl) {
            this.appurl = appurl;
        }
    }
}
