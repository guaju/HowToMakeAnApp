package com.guaju.howtomakeanapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.base.BaseFragment;

/**
 * Created by guaju on 2017/7/27.
 */

public class MainFragment extends BaseFragment implements View.OnClickListener{

    private Button bt;

    @Override
    public void initData() {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View v=inflater.inflate(R.layout.fragment_main,null,false);
        bt = (Button) v.findViewById(R.id.bt);
        initEvent();
        return v;
    }

    private void initEvent() {
        bt.setOnClickListener(this);
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
