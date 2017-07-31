package com.guaju.howtomakeanapp.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.adpter.GuideAdapter;
import com.guaju.howtomakeanapp.bean.GuideBean;
import com.guaju.howtomakeanapp.constants.HttpConstants;
import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;
import com.guaju.howtomakeanapp.model.progress.ProgressImageView;
import com.guaju.howtomakeanapp.model.progress.ProgressModelLoader;
import com.guaju.howtomakeanapp.utils.SPUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import okhttp3.Response;

/**
 * Created by guaju on 2017/7/24.
 */

public class GuideActivity extends AppCompatActivity  implements View.OnClickListener{

    private ArrayList<String> guidepic;
    private ArrayList<ProgressImageView> lists = new ArrayList<>();
    private ViewPager vp;
    private LinearLayout ll;
    private Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        if ((boolean) SPUtils.getInstance(this, "config").getSp("isfirst", false)){
            startActivity(new Intent(GuideActivity.this,SplashActivity.class));
            return;
        };
        initView();
        initData();
        initEvent();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();


    }

    private void initEvent() {
        bt.setOnClickListener(this);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetCirlceIndicater();
                ImageView iv = (ImageView) ll.getChildAt(position);
                iv.setImageResource(R.drawable.selected);
                if (position==guidepic.size()-1){
                    ll.setVisibility(View.INVISIBLE);
                    bt.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(GuideActivity.this, R.anim.enter_from_bottom);
                    animation.setInterpolator(new OvershootInterpolator());
                    bt.setAnimation(animation);
                }



            }

            private void resetCirlceIndicater() {
                for (int i=0;i<ll.getChildCount();i++){
                    ((ImageView) ll.getChildAt(i)).setImageResource(R.drawable.normal);
                }
                bt.setVisibility(View.GONE);
                ll.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        ll = (LinearLayout) findViewById(R.id.ll);
        bt = (Button) findViewById(R.id.bt);
        bt.setVisibility(View.GONE);
        vp.setOffscreenPageLimit(0);
    }

    private void initData() {
        OkHttpUtils instance = OkHttpUtils.getInstance();
        instance.get(HttpConstants.guide, null, new BaseCallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(Response response) {
                String json = null;
                try {
                    json = response.body().string();
                    Gson gson = new Gson();
                    GuideBean guideBean = gson.fromJson(json, GuideBean.class);
                    if (guideBean != null) {
                    if (200 == guideBean.getStatus()) {
                        guidepic = (ArrayList<String>) guideBean.getData().getGuidepic();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateFace();

                            }
                        });

                    }


                }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailed() {

            }
        });

    }

    private void updateFace() {
        for (String str : guidepic) {
            ProgressImageView progressImageView = (ProgressImageView) LayoutInflater
                    .from(GuideActivity.this).inflate(R.layout.progressimageview,null,false);
            ImageView imageView = progressImageView.getImageView();
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(GuideActivity.this)
                    .using(new ProgressModelLoader(new ProgressHandler(GuideActivity.this, progressImageView)))
                    .load(str)
                    .placeholder(R.drawable.loading).into(imageView);
            lists.add(progressImageView);

            //将小圆点图片添加到linearlayout 里面去
            ImageView iv=new ImageView(GuideActivity.this);
            iv.setImageResource(R.drawable.normal);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50);
            layoutParams.setMargins(10,0,10,0);
            iv.setLayoutParams(layoutParams);
            ll.addView(iv);

        }
        ImageView firstIv = (ImageView) ll.getChildAt(0);
        firstIv.setImageResource(R.drawable.selected);
        GuideAdapter guideAdapter = new GuideAdapter(GuideActivity.this, lists);
        vp.setAdapter(guideAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt:
                SPUtils.getInstance(this,"config").putSP("isfirst",true);
                startActivity(new Intent(GuideActivity.this,SplashActivity.class));
                break;
            default:
                break;

        }


    }

    private static class ProgressHandler extends Handler {

        private final WeakReference<Activity> mActivity;
        private final ProgressImageView mProgressImageView;

        public ProgressHandler(Activity activity, ProgressImageView progressImageView) {
            super(Looper.getMainLooper());
            mActivity = new WeakReference<>(activity);
            mProgressImageView = progressImageView;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final Activity activity = mActivity.get();
            if (activity != null) {
                switch (msg.what) {
                    case 1:
                        int percent = msg.arg1 * 100 / msg.arg2;
                        mProgressImageView.setProgress(percent);
                        if (percent>=100){
                            mProgressImageView.hideTextView();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
