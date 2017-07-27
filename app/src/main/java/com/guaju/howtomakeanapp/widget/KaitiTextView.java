package com.guaju.howtomakeanapp.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by guaju on 2017/7/26.
 */

public class KaitiTextView extends android.support.v7.widget.AppCompatTextView {
    public KaitiTextView(Context context) {
        super(context);
    }

    public KaitiTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public KaitiTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //提供一个得到TypeFace的方法
    private Typeface mGetTypeFace(){
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "kaiti.ttf");
        return typeface;
    }


    //设置字体的方法

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(mGetTypeFace());

    }
}
