package com.issp.association.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.issp.association.R;
import com.zhy.autolayout.AutoLayoutInfo;
import com.zhy.autolayout.utils.AutoLayoutHelper;


/**
 * Created by Administrator on 2016/12/13 0013.
 */

public class ShareRadioGroup extends RadioGroup {
    private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);
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

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(),attrs);
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



    public static class LayoutParams extends RadioGroup.LayoutParams
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

        public LayoutParams(LinearLayout.LayoutParams source)
        {
            super((MarginLayoutParams) source);
            gravity = source.gravity;
        }

        public LayoutParams(LayoutParams source)
        {
            this((LinearLayout.LayoutParams) source);
            mAutoLayoutInfo = source.mAutoLayoutInfo;
        }

        @Override
        public AutoLayoutInfo getAutoLayoutInfo()
        {
            return mAutoLayoutInfo;
        }


    }
}
