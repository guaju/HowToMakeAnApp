package com.guaju.howtomakeanapp.model;

import android.app.Activity;
import android.widget.Toast;

import com.guaju.howtomakeanapp.constants.HttpConstants;
import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;

import java.io.File;
import java.util.HashMap;

import okhttp3.Response;

/**
 * Created by guaju on 2017/8/1.
 */

public class PublishGoods {

    public static void uploadGoods(final Activity context, HashMap<String,String> map, File ... files){
        OkHttpUtils instance = OkHttpUtils.getInstance();
        BaseCallBack baseCallBack = new BaseCallBack() {
            @Override
            public void onError() {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "上传失败，请重新上传", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onSuccess(Response response) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "上传成功，您的商品已经进入审核状态", Toast.LENGTH_SHORT).show();                   }
                });
            }

            @Override
            public void onFailed() {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "上传失败，请重新上传", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        instance.postMult(HttpConstants.upload,"photo",map,baseCallBack,files);

    }

}
