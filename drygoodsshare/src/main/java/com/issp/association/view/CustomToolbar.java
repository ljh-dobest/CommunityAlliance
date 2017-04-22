package com.issp.association.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import com.issp.association.R;
import com.zhy.autolayout.AutoLayoutInfo;
import com.zhy.autolayout.utils.AutoLayoutHelper;


/**
 * Created by T-BayMax on 2017/3/13.
 */

public class CustomToolbar extends Toolbar {
    private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);
    public CustomToolbar(Context context) {
        super(context);
    }

    public CustomToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private TextView mTvMainTitleLeft;
    private TextView mTvMainTitle;
    private TextView mTvMainTitleRight;
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        if (!isInEditMode())
        {
            mHelper.adjustChildren();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom)
    {
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTvMainTitleLeft = (TextView) findViewById(R.id.lt_main_title_left);
        mTvMainTitle = (TextView) findViewById(R.id.lt_main_title);
        mTvMainTitleRight = (TextView) findViewById(R.id.lt_main_title_right);
    }
/*
    //设置主title的内容
    public void setMainTitle(String text) {
        this.setTitle(" ");
        mTvMainTitle.setVisibility(View.VISIBLE);
        mTvMainTitle.setText(text);
    }

    //设置主title的内容文字的颜色
    public void setMainTitleColor(int color) {
        mTvMainTitle.setTextColor(color);
    }

    //设置title左边文字
    public void setMainTitleLeftText(String text) {
        mTvMainTitleLeft.setVisibility(View.VISIBLE);
        mTvMainTitleLeft.setText(text);
    }

    //设置title左边文字颜色
    public void setMainTitleLeftColor(int color) {
        mTvMainTitleLeft.setTextColor(color);
    }

    //设置title左边图标
    public void setMainTitleLeftDrawable(int res) {
        Drawable dwLeft = ContextCompat.getDrawable(getContext(), res);
        dwLeft.setBounds(0, 0, dwLeft.getMinimumWidth(), dwLeft.getMinimumHeight());
        mTvMainTitleLeft.setCompoundDrawables(dwLeft, null, null, null);
    }

    //设置title右边文字
    public void setMainTitleRightText(String text) {
        mTvMainTitleRight.setVisibility(View.VISIBLE);
        mTvMainTitleRight.setText(text);
    }

    //设置title右边文字颜色
    public void setMainTitleRightColor(int color) {
        mTvMainTitleRight.setTextColor(color);
    }

    //设置title右边图标
    public void setMainTitleRightDrawable(int res) {
        Drawable dwRight = ContextCompat.getDrawable(getContext(), res);
        dwRight.setBounds(0, 0, dwRight.getMinimumWidth(), dwRight.getMinimumHeight());
        mTvMainTitleRight.setCompoundDrawables(null, null, dwRight, null);
    }


    //设置toolbar状态栏颜色
    public void setToolbarBackground(int res) {
        this.setBackgroundResource(res);
    }

    //设置toolbar左边图标
    public void setToolbarLeftBackImageRes(int res) {
        this.setNavigationIcon(res);
    }

    //设置toolbar左边文字
    public void setToolbarLeftText(String text) {
        this.setNavigationContentDescription(text);
    }

    //设置toolbar的标题
    public void setToolbarTitle(String text) {
        this.setTitle(text);
    }

    //设置toolbar标题的颜色
    public void setToolbarTitleColor(int color) {
        this.setTitleTextColor(color);
    }

    //设置toolbar子标题
    public void setToolbarSubTitleText(String text) {
        this.setSubtitle(text);
    }

    //设置toolbar子标题颜色
    public void setToolbarSubTitleTextColor(int color) {
        this.setSubtitleTextColor(color);
    }
*/

    public static class LayoutParams extends Toolbar.LayoutParams
            implements AutoLayoutHelper.AutoLayoutParams
    {
        private AutoLayoutInfo mAutoLayoutInfo;

        public LayoutParams(Context c, AttributeSet attrs)
        {
            super(c, attrs);

            mAutoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(c, attrs);
        }

        public LayoutParams(int width, int height)
        {
            super(width, height);
        }

        public LayoutParams(int width, int height, int gravity)
        {
            super(width, height, gravity);
        }

        public LayoutParams(ViewGroup.LayoutParams source)
        {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source)
        {
            super(source);
        }

        public LayoutParams(Toolbar.LayoutParams source)
        {
            super((MarginLayoutParams) source);
            gravity = source.gravity;
        }

        public LayoutParams(LayoutParams source)
        {
            this((Toolbar.LayoutParams) source);
            mAutoLayoutInfo = source.mAutoLayoutInfo;
        }

        @Override
        public AutoLayoutInfo getAutoLayoutInfo()
        {
            return mAutoLayoutInfo;
        }


    }
}
