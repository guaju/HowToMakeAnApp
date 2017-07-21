package com.guaju.howtomakeanapp.httputils;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by guaju on 2017/7/21.
 * 需要创建一个单利的网络加载的工具类
 *
 */

public class OkHttpUtils {

    //私有化对象
    private static OkHttpUtils okUtils=new OkHttpUtils();
    private static OkHttpClient okHttpClient;

    //私有化构造方法
    private OkHttpUtils(){
        //单例化okhttp
        okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(5, TimeUnit.SECONDS);
    }
    //对外提供方法让别人去调用
    public static  OkHttpClient getInstance(){
        return   okHttpClient;
    }


}
