package com.guaju.howtomakeanapp.fragment;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.base.BaseFragment;
import com.guaju.howtomakeanapp.bean.WareHot;
import com.guaju.howtomakeanapp.http.RetrofitUtil;
import com.guaju.howtomakeanapp.utils.SimpleImageLoader;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by guaju on 2017/7/27.
 */

public class MineFragment extends BaseFragment {

    private ImageView iv;

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
//        Bitmap bitmap = SimpleImageLoader.getInsance().getBitmap("https://n.sinaimg.cn/tech/crawl/20170226/yrbm-fyawhqy2124261.jpg");
//        if (bitmap!=null){
//             iv.setImageBitmap(bitmap);
//        }
        try {
            Bitmap bitmapFromDisk = SimpleImageLoader.getInsance().getBitmapFromDisk("https://n.sinaimg.cn/tech/crawl/20170226/yrbm-fyawhqy2124261.jpg");
            if (bitmapFromDisk!=null){
             iv.setImageBitmap(bitmapFromDisk);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_mine, null, false);
        iv = (ImageView) v.findViewById(R.id.iv_imageloader);
        return v;
    }


}
