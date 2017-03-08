package com.example.just.shequnlianmeng.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.just.shequnlianmeng.R;


/**
 * Created by Administrator on 2016/12/13 0013.
 */

public class MainRadioGroup extends RadioGroup {
    public MainRadioGroup(Context context) {
        this(context, null);
    }

    public MainRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawables = new Drawable[]{
                  getResources().getDrawable(R.drawable.botm_home_buttom),
                getResources().getDrawable(R.drawable.chat2x),
                getResources().getDrawable(R.drawable.mine2x)
        };
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() * 0.15f), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int childcount;
    private boolean isLayout = true;
    private Drawable []drawables;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (isLayout) {
            isLayout = false;
            childcount = getChildCount();
            for (int i = 0; i < childcount; i++) {
                Drawable drawable=drawables[i];
                RadioButton rb = (RadioButton) getChildAt(i);
          //      int left = (int) ((getMeasuredWidth() * 0.2f) / 10);
                int top = (int) (getMeasuredHeight() * 0.11f);
                int right = (int) (getMeasuredHeight()*0.45f);
                int bottom = (int) (getMeasuredWidth() /5*0.5f);
          //      System.out.println("right="+right+"bottom"+bottom);
                LayoutParams lp = new LayoutParams(0, LayoutParams.MATCH_PARENT,1);
                rb.setLayoutParams(lp);
                //第一0是距左右边距离，第二0是距上下边距离，第三长度,第四宽度
                drawable.setBounds(0,top,right,bottom);
                rb.setCompoundDrawables(null,drawable,null,null);
            }

        }

        super.onLayout(changed, l, t, r, b);
    }
}
