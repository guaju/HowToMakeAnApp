package com.guaju.howtomakeanapp.httputils;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by guaju on 2017/7/31.
 */

public  abstract class BaseCallBack<T> implements Callback {


    //当访问返回400 404时调用（一般是token传错，参数传错）
    public abstract void onError();

    public abstract void onSuccess(Response response);

    public abstract void onFailed();

    @Override
    public void onFailure(Call call, IOException e) {
          onFailed();
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
         if (response.isSuccessful()){
             onSuccess(response);
         }
         else{
             onError();
         }
    }
}
