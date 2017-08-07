package com.guaju.howtomakeanapp.http;

import com.guaju.howtomakeanapp.bean.WareHot;

/**
 * Created by guaju on 2017/8/7.
 */

public abstract class MyTask implements Runnable {
       public WareHot wareHot;

    public WareHot getWareHot() {
        return wareHot;
    }

    public void setWareHot(WareHot wareHot) {
        this.wareHot = wareHot;
    }
}
