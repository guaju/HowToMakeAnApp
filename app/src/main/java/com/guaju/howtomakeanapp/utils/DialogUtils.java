package com.guaju.howtomakeanapp.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.guaju.howtomakeanapp.model.DownLoader;

/**
 * Created by guaju on 2017/7/21.
 */

public class DialogUtils {
    public static void showUpdateDialog(final Activity act,String title,String mes,final String url){
        AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(title);
        builder.setMessage(mes);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                downloadAndInstall(act,url);
            }


        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private static void downloadAndInstall(Activity act,String url) {
        DownLoader.downLoadAndInstallApk(act,url);

    }
}

