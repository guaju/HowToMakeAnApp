package com.guaju.howtomakeanapp.model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Created by guaju on 2017/7/21.
 */

public class InstallApk {

    public static  void  InstallApk(Activity act,File file){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://"+file.getAbsolutePath()),
                "application/vnd.android.package-archive");
        //startActivityForResult在sdk中有明确说明，
        // 如果intent类型是ACTION_VIEW或者ACTION_MAIN那是不会得到返回结果的
        act.startActivity(intent);
        //疑问？如何监听apk是否安装成功


    }


}
