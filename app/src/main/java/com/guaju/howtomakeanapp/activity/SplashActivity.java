package com.guaju.howtomakeanapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.guaju.howtomakeanapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by guaju on 2017/7/25.
 */

public class SplashActivity extends Activity{
    int count=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        useTimer(3000);
    }


  void  useTimer(final int time){
      new Thread(new Runnable() {
          @Override
          public void run() {
            final Timer timer=new Timer();
              timer.schedule(new TimerTask() {
                  @Override
                  public void run() {
                    if(count<=time){
                      count+=1000;
                    }
                    else{
                        //停止
                      timer.cancel();
                      timer.purge();
                      startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    }
                  }
              },0,1000);


          }
      }).start();

  }
}
