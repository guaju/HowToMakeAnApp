package com.guaju.howtomakeanapp.http;

import com.guaju.howtomakeanapp.bean.WareHot;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by guaju on 2017/8/3.
 */

public interface RetrofitCampainI {
    //网址类型是////{type}/{hello}/
    @GET("wares/hot?curPage=0&pageSize=10")
    //返回值  方法名（参数）
    Call<WareHot> getWaresHot();

    @GET("{type}/hot?curPage=0&pageSize=10")
        //返回值  方法名（参数）
    Call<WareHot> getWaresHot(@Path("type") String type);
    //用？ &将网址拼接在一起
   @GET("wares/hot")
   Call<WareHot> getWaresHot21(@Query("curPage") String page,@Query("pageSize") String pageSize);

    @GET("wares/hot")
    Call<WareHot> getWaresHot22(@QueryMap HashMap<String,String> param);
}
