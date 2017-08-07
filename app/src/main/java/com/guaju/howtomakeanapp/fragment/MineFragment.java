package com.guaju.howtomakeanapp.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.base.BaseFragment;
import com.guaju.howtomakeanapp.bean.WareHot;
import com.guaju.howtomakeanapp.http.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by guaju on 2017/7/27.
 */

public class MineFragment extends BaseFragment {
    @Override
    public void initData() {
        RetrofitUtil.getInstance().getWaresHot1(new Callback<WareHot>() {
            @Override
            public void onResponse(Call<WareHot> call, Response<WareHot> response) {
                WareHot body = response.body();
                Log.e(TAG, "onResponse: "+body.getCopyright() );
            }

            @Override
            public void onFailure(Call<WareHot> call, Throwable throwable) {

            }
        });


    }

    @Override
    public View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_mine, null, false);
        return v;

    }
}
