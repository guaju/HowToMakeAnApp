package com.guaju.howtomakeanapp.http;

import com.guaju.howtomakeanapp.bean.WareHot;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by guaju on 2017/8/3.
 */

public interface API {
//    //网址类型是////{type}/{hello}/
//    @GET("wares/hot?curPage=0&pageSize=10")
//    //返回值  方法名（参数）
//    Call<WareHot> getWaresHot();
    @GET("{type}/hot?curPage=0&pageSize=10")
    Observable<WareHot> getWare(@Path("type") String type);


}
