package com.example.just.shequnlianmeng.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class HomeGridView extends GridView {
    public HomeGridView(Context context) {
        this(context,null);
    }

    public HomeGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth()*0.2f),MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
