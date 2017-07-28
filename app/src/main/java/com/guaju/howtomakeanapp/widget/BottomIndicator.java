package com.guaju.howtomakeanapp.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guaju.howtomakeanapp.R;

/**
 * Created by guaju on 2017/7/28.
 */

public class BottomIndicator extends LinearLayout{
    private static final String TAG = "BottomIndicator";

    private TextView tv;
    private ImageView iv;
    private View v;

    public BottomIndicator(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        v = LayoutInflater.from(getContext()).inflate(R.layout.main_indicator,null,false);
        tv = (TextView) v.findViewById(R.id.tv);
        iv = (ImageView) v.findViewById(R.id.iv);
        this.addView(v);

    }

    public BottomIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BottomIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    public void setTextAndImage(String title,int drawable){
        if (TextUtils.isEmpty(title) || drawable==0){
             return;
        }
        tv.setText(title);
        iv.setBackgroundResource(drawable);
    }


}
