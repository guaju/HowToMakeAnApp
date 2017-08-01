package com.guaju.howtomakeanapp.model;

import com.guaju.howtomakeanapp.constants.HttpConstants;
import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;

import java.util.HashMap;

/**
 * Created by guaju on 2017/7/31.
 */

public class WaresHot {


    public  static void getWaresHot(BaseCallBack callBack){
        HashMap<String, String> map = new HashMap<>();
        map.put("curPage","0");
        map.put("pageSize","10");
        OkHttpUtils instance = OkHttpUtils.getInstance();
        instance.get(HttpConstants.API.WARES_HOT,map,callBack);
    }
    public static void postWaresHot(BaseCallBack callBack){
        HashMap<String, String> map = new HashMap<>();
        map.put("curPage","0");
        map.put("pageSize","10");
        OkHttpUtils instance = OkHttpUtils.getInstance();
        instance.postData(HttpConstants.API.WARES_HOT,map,callBack);
    }

}
