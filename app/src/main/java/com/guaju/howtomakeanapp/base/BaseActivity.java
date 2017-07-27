package com.guaju.howtomakeanapp.base;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Created by guaju on 2017/7/27.
 */

public class BaseActivity extends FragmentActivity {
    //双击返回键退出应用
    long prePressed=0;
    long lastPressed=0;

    @Override
    public void onBackPressed() {
           lastPressed=System.currentTimeMillis();
           if (lastPressed-prePressed>2000){
               prePressed=lastPressed;
               Toast.makeText(this, "双击退出应用", Toast.LENGTH_SHORT).show();
           }
           else{
               System.exit(0);
           }

       }
}
