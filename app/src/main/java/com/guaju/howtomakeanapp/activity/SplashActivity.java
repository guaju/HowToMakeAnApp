package com.guaju.howtomakeanapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;

import com.guaju.howtomakeanapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by guaju on 2017/7/25.
 */

public class SplashActivity extends Activity{
    private static final int STARTCOUNT = 10;
    private static final int COUNT = 11;
    Timer timer;

    int count=0;
    int time=0;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case STARTCOUNT:
                    mHandler.sendEmptyMessageDelayed(STARTCOUNT,1000);
                    count+=1000;
                    if (count>=time){
                        mHandler.removeMessages(STARTCOUNT);
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    }
                    break;
                default:
                    break;
            }

        }
    };
    private Thread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        useHandler(3000);
//        useTimer(3000);
        useWhile(3000);

    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }

    private void useHandler(int time) {
        this.time=time;
        mHandler.sendEmptyMessage(STARTCOUNT);

    }

    private void useWhile(final int time) {
        thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 while (count<time){
                     SystemClock.sleep(1000);
                     count+=1000;
                 }
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         if (count!=4000){
                     startActivity(new Intent(SplashActivity.this,MainActivity.class));
                         }
                     }
                 });

             }
         });
        thread.start();

    }


    void  useTimer(final int time){
      new Thread(new Runnable() {
          @Override
          public void run() {
            timer=new Timer();
              timer.schedule(new TimerTask() {
                  @Override
                  public void run() {
                    if(count<time){
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

  public  void  skip(View view){
//      mHandler.removeMessages(STARTCOUNT);
//      timer.cancel();
//      timer.purge();
      count=4000;
      startActivity(new Intent(SplashActivity.this,MainActivity.class));

  }
}
