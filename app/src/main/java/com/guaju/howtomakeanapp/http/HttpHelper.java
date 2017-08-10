package com.guaju.howtomakeanapp.http;

import android.os.Handler;
import android.os.Looper;

import com.guaju.howtomakeanapp.bean.WareHot;
import com.guaju.howtomakeanapp.constants.HttpConstants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by guaju on 2017/8/7.
 */

public class HttpHelper {
    private static volatile HttpHelper httpHelper;
    private static Retrofit retrofit;
    private final API api;

    private HttpHelper() {
        //1.retrofit初始化
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstants.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    public static HttpHelper getInstance() {
        if (httpHelper == null) {
            synchronized (HttpHelper.class) {
                if (httpHelper == null) {
                    httpHelper = new HttpHelper();
                }
            }
        }
        return httpHelper;
    }

    public void getWareHot(final MyTask runnable){
        Observable<WareHot> wares = api.getWare("wares");
        wares.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WareHot>() {
                    @Override
                    public void call(WareHot wareHot) {
                        Handler handler = new Handler(Looper.getMainLooper());
                        runnable.setWareHot(wareHot);
                        handler.post(runnable);
                    }
                });


    }

}
