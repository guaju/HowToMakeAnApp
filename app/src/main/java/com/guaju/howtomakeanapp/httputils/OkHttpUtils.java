package com.guaju.howtomakeanapp.httputils;

import com.google.gson.Gson;

import java.io.File;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by guaju on 2017/7/21.
 * 需要创建一个单利的网络加载的工具类
 *
 */

public class OkHttpUtils {
    private int count=0;
    //私有化对象
    private static OkHttpUtils okUtils;
    private static Gson gson;
    private static OkHttpClient okHttpClient;

    //静态代码块
    static{
        okUtils=new OkHttpUtils();
    }

    //私有化构造方法
    private OkHttpUtils(){
        //单例化okhttp
        okHttpClient = new OkHttpClient();
        gson=new Gson();
    }
    //对外提供方法让别人去调用
    public static  OkHttpUtils getInstance(){
        return   okUtils;
    }
    public static Gson getGson(){
        return gson;
    }
   //提供访问网络的方法
   public void get(String url, Map<String,String> paramMap, BaseCallBack callback){
       Request.Builder builder = new Request.Builder();
       if ((paramMap!=null)&&(!paramMap.isEmpty())){
       Set<Map.Entry<String, String>> entries = paramMap.entrySet();
       StringBuffer sb = new StringBuffer();
       Set<String> keys= paramMap.keySet();
       for (String str:keys){
           if (count==0){
           sb.append("?");
           }else if (count!=0){
               sb.append("&");
           }
           sb.append(str+"="+paramMap.get(str));
           count++;
       }
       String params = sb.toString();
       url = url+params;   }
       Request request = builder.url(url)
               .get()
               .build();
       Call call = okHttpClient.newCall(request);
       call.enqueue(callback);
   }

   public void postData(String url,Map<String,String> paramMap,BaseCallBack callBack){
       Request.Builder builder = new Request.Builder();
       Set<Map.Entry<String, String>> entries = paramMap.entrySet();
       FormBody.Builder formBody = new FormBody.Builder();
       for (Map.Entry<String, String> map:entries){
           formBody.add(map.getKey(),map.getValue());
       }
       FormBody body = formBody.build();
       Request request = builder.url(url)
               .post(body)
               .build();
       Call call = okHttpClient.newCall(request);
       call.enqueue(callBack);

   };
   //上传图片的post请求
   public void postMult(String url, String imageParam,Map<String, String> paramMap, BaseCallBack callBack
   ,File ... file){

       MediaType mediaType = MediaType.parse("image/png");

       MultipartBody.Builder multiBody = new MultipartBody.Builder();
       multiBody.setType(mediaType);
       if (file!=null&&file.length>0) {
           for (File fi : file) {
               RequestBody requestBody = RequestBody.create(mediaType, fi);
               multiBody.addFormDataPart(imageParam, fi.getName(), requestBody);
           }
       }
       Request.Builder builder = new Request.Builder();
       if (!(paramMap==null&&paramMap.isEmpty())){
       Set<Map.Entry<String, String>> entries = paramMap.entrySet();
       for (Map.Entry<String, String> map:entries){
           multiBody.addFormDataPart(map.getKey(),map.getValue());
       }
       }
       MultipartBody body = multiBody.build();
       Request request = builder.url(url)
               .post(body)
               .build();
       Call call = okHttpClient.newCall(request);
       call.enqueue(callBack);

   };

}
