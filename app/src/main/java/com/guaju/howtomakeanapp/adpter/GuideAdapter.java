package com.guaju.howtomakeanapp.adpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.guaju.howtomakeanapp.model.progress.ProgressImageView;

import java.util.ArrayList;

/**
 * Created by guaju on 2017/7/24.
 */

public class GuideAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<ProgressImageView> list;

    public GuideAdapter(Context context, ArrayList<ProgressImageView> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return   list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));

    }
}
