package com.guaju.androidh5.utils;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

/**
 * Created by guaju on 2017/7/21.
 */

public class DialogUtils {

    private static AlertDialog alertDialog;

    public static void showUpdateDialog(final Activity act, String title, String mes){
        AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(title);
        builder.setMessage(mes);
        alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

    }
    public static void hideDialog(){
        if (alertDialog!=null&&alertDialog.isShowing()){
            alertDialog.dismiss();
        }
    }


}

