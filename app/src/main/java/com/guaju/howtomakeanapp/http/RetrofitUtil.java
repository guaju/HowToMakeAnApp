package com.guaju.howtomakeanapp.http;

import com.guaju.howtomakeanapp.bean.WareHot;
import com.guaju.howtomakeanapp.constants.HttpConstants;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by guaju on 2017/8/4.
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;
    private static Retrofit retrofit;
    private final RetrofitCampainI retrofitCampainI;

    private RetrofitUtil(){

        retrofitCampainI = retrofit.create(RetrofitCampainI.class);
    }
    //只要类被调用，就会执行此方法
    static {
        //去初始化retrofit
        retrofit=new Retrofit.Builder()
                .baseUrl(HttpConstants.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitUtil=new RetrofitUtil();

    }
    public void getWaresHot1(Callback<WareHot> callback){
        Call<WareHot> waresHot = retrofitCampainI.getWaresHot();
        waresHot.enqueue(callback);
    }
      public void getWaresHot2(Callback<WareHot> callback){
        Call<WareHot> waresHot = retrofitCampainI.getWaresHot("wares");
        waresHot.enqueue(callback);
    }
      public void getWaresHot3(Callback<WareHot> callback){
        Call<WareHot> waresHot = retrofitCampainI.getWaresHot21("0","10");
        waresHot.enqueue(callback);
    }
      public void getWaresHot4(Callback<WareHot> callback){
          HashMap<String, String> map = new HashMap<>();
          map.put("curPage","0");
          map.put("pageSize","10");

          Call<WareHot> waresHot = retrofitCampainI.getWaresHot22(map);
        waresHot.enqueue(callback);
    }


    public static RetrofitUtil getInstance(){
        return retrofitUtil;

    }


}
