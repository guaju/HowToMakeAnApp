package com.guaju.howtomakeanapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by guaju on 2017/7/27.
 */

public abstract  class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=initView(inflater);
        initData();
        return v;
    }

    public abstract void initData();

    public abstract View  initView(LayoutInflater inflater);
}
