package com.guaju.howtomakeanapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.adpter.AdsAdapter;
import com.guaju.howtomakeanapp.base.BaseFragment;
import com.guaju.howtomakeanapp.constants.HttpConstants;
import com.guaju.howtomakeanapp.model.GetAds;
import com.guaju.howtomakeanapp.widget.BottomIndicator;

import java.util.ArrayList;

/**
 * Created by guaju on 2017/7/27.
 */

public class MainFragment extends BaseFragment implements View.OnClickListener {
    private int currentPosition=0;
    private Button bt;
    private BottomIndicator bi;
    private ArrayList<ImageView> imageViewLists = new ArrayList<>();
    private AdsAdapter adsAdapter;
    private ViewPager vp;

    @Override
    public void initData() {
        GetAds getAds = new GetAds() {


            @Override
            public void showAds(final ArrayList<String> guidepic) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (String str : guidepic) {
                            ImageView imageView = new ImageView(getActivity());
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            Glide.with(getActivity()).load(str).placeholder(R.mipmap.ic_launcher).into(imageView);
                            imageViewLists.add(imageView);      }
                            adsAdapter = new AdsAdapter(getActivity(), imageViewLists);
                            vp.setAdapter(adsAdapter);
                            vp.setCurrentItem(200);
                            adsAdapter.startPlay(vp);
                            adsAdapter.controlVP(vp);
                    }
                });
            }
        };
        getAds.getAds(HttpConstants.guide);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_main, null, false);
        vp = (ViewPager) v.findViewById(R.id.vp);

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
}
