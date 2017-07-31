package com.guaju.howtomakeanapp.model;

import android.app.Activity;
import android.os.Environment;

import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Response;

/**
 * Created by guaju on 2017/7/21.
 */

public class DownLoader {

    public static void downLoadAndInstallApk(final Activity act, String url) {
        OkHttpUtils.getInstance().get(url,null,new DownLoaderCallBack(act));
    }


    public static class DownLoaderCallBack extends BaseCallBack {
        private Activity act;

        private DownLoaderCallBack(Activity act) {
            this.act = act;

        }


        @Override
        public void onError() {

        }

        @Override
        public void onSuccess(Response response) {
            if (response.isSuccessful()){
               try{
                byte[] bytes = response.body().bytes();
                if (bytes!=null&&bytes.length>0){
                    File dir = new File(Environment.getExternalStorageDirectory()+"/how");
                    if (!dir.exists()){
                        dir.mkdirs();
                    }
                    File file = new File(dir, "how.apk");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(bytes);

                    fos.close();
                    bytes=null;
                    //然后就要安装了
                    InstallApk.InstallApk(act,file);
                }
            }catch (IOException e){
                   throw new RuntimeException("下载apk异常");
               }

        }
        }

        @Override
        public void onFailed() {

        }
    }
}