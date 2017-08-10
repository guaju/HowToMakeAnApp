package com.guaju.howtomakeanapp.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.util.LruCache;
import android.widget.Toast;

import com.guaju.howtomakeanapp.app.App;
import com.guaju.howtomakeanapp.http.OkHttpHelper;
import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by guaju on 2017/8/10.
 */

public class SimpleImageLoader {
    private  static SimpleImageLoader simpleImageLoader=new SimpleImageLoader();
    private LruCache<String,Bitmap> mLruCache;
    private DiskLruCache mDiskLruCache;
    private SimpleImageLoader(){
        //一般定位为android虚拟机内存的1/8
        int i = (int) ((Runtime.getRuntime().maxMemory() / 8));
       //初始化内存缓存
        mLruCache=new LruCache<String, Bitmap>(i){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return  value.getByteCount();
            }
        };
        String s = Environment.getExternalStorageDirectory() + "/howto";
        File file = new File(s);

        //初始化本地缓存
        try {
            mDiskLruCache=DiskLruCache.open(file, App.versionCode,1,10*1024*1024);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  String  md5(String url){
        return  "hehe";
    }
   public static  SimpleImageLoader getInsance(){
       return  simpleImageLoader;
   }

    //缓存图片
    public void save(final Activity act,final String url){
        OkHttpHelper.getInstance().getStream(url, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        act.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(act, "图片缓存失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        byte[] bytes = response.body().bytes();
                        saveToMemory(act,url,bytes);
                        saveToDisk(url,bytes);

                    }
                });
    }
   //存到本地
    public void saveToDisk(String url,byte[] bytes) throws IOException {
        DiskLruCache.Editor edit = mDiskLruCache.edit(md5(url));
        OutputStream outputStream = edit.newOutputStream(0);
        outputStream.write(bytes);
        edit.commit();

    }
    public  void saveToMemory(final Activity act, String url, byte[] bytes){
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        if (mLruCache.get(md5(url))==null){
            mLruCache.put(md5(url),bitmap);
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(act, "图片缓存成功", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(act, "图片已缓存", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
   public Bitmap getBitmapFromDisk(String url) throws IOException {
       Bitmap bitmap=null;
       DiskLruCache.Snapshot snapshot = mDiskLruCache.get(md5(url));
       if (snapshot!=null){
       InputStream inputStream = snapshot.getInputStream(0);
        bitmap = BitmapFactory.decodeStream(inputStream);
       }
       return bitmap;
   }

    //取图片
    public  Bitmap getBitmapFromMemory(String url){
        Bitmap bitmap;
        String s = md5(url);
        if (mLruCache!=null&&mLruCache.size()>0){
            bitmap = mLruCache.get(s);
        }
        else{
            bitmap=null;
        }
        return bitmap;
    }
    public boolean removeFromMemory(String url){
        Bitmap remove=null;
        String s = md5(url);
        if (mLruCache!=null&&mLruCache.size()>0){
             remove = mLruCache.remove(s);
        }
        if (remove!=null){
            return true;
        }else{
            return false;
        }
    }
    public void removeFromDisk(String url) throws IOException {
        String s = md5(url);
        if (mDiskLruCache!=null){
            mDiskLruCache.remove(s);
        }
    }
    public void deleteDiskCache() throws IOException {
        long size = mDiskLruCache.size();
        mDiskLruCache.delete();
    }

}
