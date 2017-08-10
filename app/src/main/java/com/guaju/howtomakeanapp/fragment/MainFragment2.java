package com.guaju.howtomakeanapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.adpter.AdsAdapter;
import com.guaju.howtomakeanapp.base.BaseFragment;
import com.guaju.howtomakeanapp.bean.ADSBean;
import com.guaju.howtomakeanapp.constants.HttpConstants;
import com.guaju.howtomakeanapp.event.InfoEvent;
import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;
import com.guaju.howtomakeanapp.model.GetAds;
import com.guaju.howtomakeanapp.utils.SimpleImageLoader;
import com.guaju.howtomakeanapp.widget.BottomIndicator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

import static com.guaju.howtomakeanapp.R.id.slider;

/**
 * Created by guaju on 2017/7/27.
 */

public class MainFragment2 extends BaseFragment implements View.OnClickListener,BaseSliderView.OnSliderClickListener {
    private static final String TAG = "MainFragment2";
    private int currentPosition=0;
    private Button bt;
    private BottomIndicator bi;
    private ArrayList<ImageView> imageViewLists = new ArrayList<>();
    private AdsAdapter adsAdapter;
    private ViewPager vp;
    private SliderLayout sl;
    private RecyclerView rv;
    private TextView tv_event;

    @Override
    public void initData() {
        GetAds.getAds2(new BaseCallBack() {

            private List<ADSBean.DataBean.BannerBean> banner;

            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(Response response) {
                try {
                    String json=response.body().string();
                    ADSBean adsBean = OkHttpUtils.getGson().fromJson(json, ADSBean.class);
                    banner = adsBean.getData().get(0).getBanner();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        initSlider(banner);

                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailed() {

            }
        });
        SimpleImageLoader.getInsance().save(getActivity(),"https://n.sinaimg.cn/tech/crawl/20170226/yrbm-fyawhqy2124261.jpg");

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageEvent(InfoEvent event) {
        String address = event.getAddress();
        String name = event.getName();
        int age = event.getAge();
        tv_event.setText(address);
    };

    private void initSlider(List<ADSBean.DataBean.BannerBean> banner) {
        for (ADSBean.DataBean.BannerBean bean:banner){
            DefaultSliderView dsv=new DefaultSliderView(getActivity());
            dsv.image(HttpConstants.QINIU+bean.getImg())
               .setScaleType(DefaultSliderView.ScaleType.Fit)
               .setOnSliderClickListener(this);
            Bundle bundle = new Bundle();
            bundle.putString("tag",bean.getId());
            dsv.bundle(bundle);
            sl.addSlider(dsv);
            sl.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
            sl.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        }

    }


    @Override
    public View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_main2, null, false);
        sl = (SliderLayout) v.findViewById(slider);
        rv = (RecyclerView) v.findViewById(R.id.rv);
        tv_event = (TextView) v.findViewById(R.id.tv_event);
        initEvent();
        return v;
    }

    private void initEvent() {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("Android.intent.action.VIEW");
        Uri uri = Uri.parse("https://item.taobao.com/item.htm?spm=a217h.1721928.1998704851.2.4bc338d2fkfKwX&id=524309999816"); // 商品地址
        intent.setData(uri);
        intent.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
        startActivity(intent);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
         if (hidden){
             if (adsAdapter!=null){
                 int currentItem = vp.getCurrentItem();
                 Log.e(TAG, "guajuonHiddenChanged: 隐藏 "+currentItem );
                 adsAdapter.stopLoop();
             }
         } else{
             if (adsAdapter!=null) {
                 int currentItem = vp.getCurrentItem();
                 Log.e(TAG, "guajuonHiddenChanged: 显示 "+currentItem );
                 adsAdapter.startPlay(vp);

             }
         }

    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Bundle bundle = slider.getBundle();
        String tag = bundle.getString("tag");
        Log.e(TAG, "onSliderClick: "+tag);
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
