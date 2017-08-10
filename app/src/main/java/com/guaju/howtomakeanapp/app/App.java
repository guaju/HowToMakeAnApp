package com.guaju.howtomakeanapp.app;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by guaju on 2017/8/10.
 */

public class App extends Application {
    public static int versionCode;
    @Override
    public void onCreate() {
        super.onCreate();
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}
