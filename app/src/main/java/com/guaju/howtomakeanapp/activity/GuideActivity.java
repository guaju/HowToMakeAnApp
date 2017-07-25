package com.guaju.howtomakeanapp.activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.adpter.GuideAdapter;
import com.guaju.howtomakeanapp.bean.GuideBean;
import com.guaju.howtomakeanapp.constants.HttpConstants;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;
import com.guaju.howtomakeanapp.model.progress.ProgressImageView;
import com.guaju.howtomakeanapp.model.progress.ProgressModelLoader;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by guaju on 2017/7/24.
 */

public class GuideActivity extends AppCompatActivity {

    private ArrayList<String> guidepic;
    private ArrayList<ProgressImageView> lists = new ArrayList<>();
    private ViewPager vp;
    private LinearLayout ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetCirlceIndicater();
                ImageView iv = (ImageView) ll.getChildAt(position);
                iv.setImageResource(R.drawable.selected);


            }

            private void resetCirlceIndicater() {
                for (int i=0;i<ll.getChildCount();i++){
                    ((ImageView) ll.getChildAt(i)).setImageResource(R.drawable.normal);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        ll = (LinearLayout) findViewById(R.id.ll);
        vp.setOffscreenPageLimit(0);
    }

    private void initData() {
        final Request req = new Request.Builder()
                .get()
                .url(HttpConstants.guide)
                .build();
        OkHttpClient instance = OkHttpUtils.getInstance();
        Call call = instance.newCall(req);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
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

                }
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
