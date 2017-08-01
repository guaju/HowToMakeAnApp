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
       FormBody.Builder formBody = new FormBody.Builder();
       if (paramMap==null){
           FormBody body = formBody.build();
           Request request = builder.url(url)
                   .post(body)
                   .build();
           Call call = okHttpClient.newCall(request);
           call.enqueue(callBack);
       }else{
       Set<Map.Entry<String, String>> entries = paramMap.entrySet();
       for (Map.Entry<String, String> map:entries){
           formBody.add(map.getKey(),map.getValue());
       }
       FormBody body = formBody.build();
       Request request = builder.url(url)
               .post(body)
               .build();
       Call call = okHttpClient.newCall(request);
       call.enqueue(callBack);

       }



   };
   //上传图片的post请求
   public void postMult(String url, String imageParam,Map<String, String> paramMap, BaseCallBack callBack
   ,File ... file){
       //声明一个文件类型
       /*
       属性：
        text/html ： HTML格式
        text/plain ：纯文本格式
        text/xml ：  XML格式
        image/gif ：gif图片格式
        image/jpeg ：jpg图片格式
        image/png：png图片格式
        以application开头的媒体格式类型：

        application/xhtml+xml ：XHTML格式
        application/xml     ： XML数据格式
        application/atom+xml  ：Atom XML聚合格式
        application/json    ： JSON数据格式
        application/pdf       ：pdf格式
        application/msword  ： Word文档格式
        application/octet-stream ： 二进制流数据（如常见的文件下载）
        */




       MediaType mediaType = MediaType.parse("image/png");
       //创建一个复杂类型的请求体
//       MultipartBody.Builder multiBody = new MultipartBody.Builder();
//       multiBody.setType(MultipartBody.FORM);
       MultipartBody.Builder multipartBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
       //遍历上传文件
       if (file!=null&&file.length>0) {
           for (File fi : file) {
               RequestBody requestBody = RequestBody.create(mediaType, fi);
               multipartBuilder.addFormDataPart(imageParam, fi.getName(), requestBody);
           }
       }
       //遍历参数
       if (!(paramMap==null&&paramMap.isEmpty())){
       Set<Map.Entry<String, String>> entries = paramMap.entrySet();
       for (Map.Entry<String, String> map:entries){
           multipartBuilder.addFormDataPart(map.getKey(),map.getValue());
       }
       }
       //最终得到请求体
       MultipartBody body = multipartBuilder.build();
       //使用okhttpclient做上传
       Request request = new Request.Builder().url(url)
               .post(body)
               .build();
       Call call = okHttpClient.newCall(request);
       call.enqueue(callBack);

   };

}
