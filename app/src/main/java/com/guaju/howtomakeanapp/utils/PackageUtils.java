package com.guaju.howtomakeanapp.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by guaju on 2017/7/21.
 */

public class PackageUtils {

    public static String getCurrentVersion(Activity activty) throws PackageManager.NameNotFoundException {
        PackageManager pm = activty.getPackageManager();
        PackageInfo packageInfo = pm.getPackageInfo("com.guaju.howtomakeanapp", 0);
        String versionName = packageInfo.versionName;
        if (TextUtils.isEmpty(versionName)){
            return "";
        }
        return  versionName;
    }

}
