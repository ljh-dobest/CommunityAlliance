package com.issp.inspiration.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.issp.inspiration.R;


/**
 * Created by Administrator on 2016/12/13 0013.
 */

public class ShareRadioGroup extends RadioGroup {
    public ShareRadioGroup(Context context) {
        this(context, null);
    }

    public ShareRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawables = new Drawable[]{
                getResources().getDrawable(R.drawable.botm_connection_buttom),
                getResources().getDrawable(R.drawable.botm_relation_buttom)
        };
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() * 0.15f), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int childcount;
    private boolean isLayout = true;
    private Drawable[] drawables;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (isLayout) {
            isLayout = false;
            childcount = getChildCount();
            for (int i = 0; i < childcount; i++) {
                Drawable drawable = drawables[i];
                RadioButton rb = (RadioButton) getChildAt(i);

               /* LayoutParams lp = new LayoutParams(0, LayoutParams.MATCH_PARENT, 1);
                rb.setLayoutParams(lp);*/
                rb.setBackground(drawable);
            }

        }

        super.onLayout(changed, l, t, r, b);
    }
}
