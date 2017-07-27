package com.guaju.howtomakeanapp.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.base.BaseFragment;

/**
 * Created by guaju on 2017/7/27.
 */

public class MineFragment extends BaseFragment {
    @Override
    public void initData() {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_mine, null, false);
        return v;

    }
}
