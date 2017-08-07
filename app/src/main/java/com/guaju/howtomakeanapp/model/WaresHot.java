package com.guaju.howtomakeanapp.model;

import com.guaju.howtomakeanapp.bean.WareHot;
import com.guaju.howtomakeanapp.constants.HttpConstants;
import com.guaju.howtomakeanapp.http.RetrofitCampainI;
import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    public static void retrofitGetWaresHot(Callback<WareHot> callback){
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstants.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitCampainI retrofitCampainI = retrofit.create(RetrofitCampainI.class);

        Call waresHot = retrofitCampainI.getWaresHot();

        waresHot.enqueue(callback);
    }

    public static void retrofitGetWaresHot2(Callback<WareHot> callback){
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstants.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitCampainI retrofitCampainI = retrofit.create(RetrofitCampainI.class);

        Call waresHot = retrofitCampainI.getWaresHot("wares");

        waresHot.enqueue(callback);
    }

    public static void retrofitGetWaresHot21(Callback<WareHot> callback){
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstants.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitCampainI retrofitCampainI = retrofit.create(RetrofitCampainI.class);

        Call waresHot = retrofitCampainI.getWaresHot21("0","10");

        waresHot.enqueue(callback);
    }
    public static void retrofitGetWaresHot22(Callback<WareHot> callback){
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstants.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitCampainI retrofitCampainI = retrofit.create(RetrofitCampainI.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("curPage","0");
        map.put("pageSize","10");
        Call waresHot = retrofitCampainI.getWaresHot22(map);

        waresHot.enqueue(callback);
    }

}
