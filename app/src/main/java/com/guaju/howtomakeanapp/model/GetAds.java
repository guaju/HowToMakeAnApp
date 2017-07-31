package com.guaju.howtomakeanapp.model;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.guaju.howtomakeanapp.bean.GuideBean;
import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Response;

/**
 * Created by guaju on 2017/7/28.
 */

public abstract  class GetAds {

    public  void getAds(String url){
        OkHttpUtils.getInstance().get(url, null, new BaseCallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(Response response) {
                if (response.isSuccessful()){
                    try{
                    String json = response.body().string();
                    if (TextUtils.isEmpty(json)){
                        //做没有数据的处理
                    }else{
                        Gson gson=new Gson();
                        GuideBean guideBean = gson.fromJson(json, GuideBean.class);
                        ArrayList<String> guidepic = (ArrayList<String>) guideBean.getData().getGuidepic();
                        showAds(guidepic);
                    }
                    }catch (IOException e){
                        throw new RuntimeException("广告轮播下载出现异常");
                    }

                }
            }

            @Override
            public void onFailed() {

            }
        });



    }

    public  abstract void showAds(ArrayList<String> guidepic);
}
