package com.guaju.howtomakeanapp.model;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.guaju.howtomakeanapp.bean.GuideBean;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by guaju on 2017/7/28.
 */

public abstract  class GetAds {

    public  void getAds(String url){
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = OkHttpUtils.getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                   if (response.isSuccessful()){
                       String json = response.body().string();
                       if (TextUtils.isEmpty(json)){
                              //做没有数据的处理
                       }else{
                       Gson gson=new Gson();
                       GuideBean guideBean = gson.fromJson(json, GuideBean.class);
                           ArrayList<String> guidepic = (ArrayList<String>) guideBean.getData().getGuidepic();
                       showAds(guidepic);
                       }
                   }
            }
        });

    }

    public  abstract void showAds(ArrayList<String> guidepic);
}
