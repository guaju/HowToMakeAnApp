package com.guaju.howtomakeanapp.bean;

import java.util.List;

/**
 * Created by guaju on 2017/7/24.
 */

public class GuideBean {


    /**
     * status : 200
     * data : {"guidepic":["http://upload.cankaoxiaoxi.com/2017/0724/1500856367784.jpg","http://upload.cankaoxiaoxi.com/2017/0724/1500856334352.jpg","http://upload.cankaoxiaoxi.com/2017/0724/1500856038428.jpg"]}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<String> guidepic;

        public List<String> getGuidepic() {
            return guidepic;
        }

        public void setGuidepic(List<String> guidepic) {
            this.guidepic = guidepic;
        }
    }
}
