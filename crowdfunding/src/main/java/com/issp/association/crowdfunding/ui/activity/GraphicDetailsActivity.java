package com.issp.association.crowdfunding.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.richeditor.RichEditor;

/**
 * 图文详情
 * Created by T-BayMax on 2017/4/22.
 */

public class GraphicDetailsActivity extends AutoLayoutActivity implements View.OnLayoutChangeListener {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.et_content)
    RichEditor etContent;
    @BindView(R.id.iv_ask_camera)
    ImageView ivAskCamera;
    @BindView(R.id.iv_ask_picture)
    ImageView ivAskPicture;
    @BindView(R.id.ll_ask_insert)
    AutoLinearLayout llAskInsert;
    @BindView(R.id.ll_insert)
    LinearLayout llInsert;
    //屏幕高度
    private int screenHeight = 0;
    private int screenWidth = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;
    private int goldNum = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_details);
        ButterKnife.bind(this);
        llInsert.addOnLayoutChangeListener(this);
    }

    /**
     * 布局底部移动超过屏幕高度的四分之一则判断软键盘弹出或关闭
     */
    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
            llAskInsert.setVisibility(View.VISIBLE);
        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
            llAskInsert.setVisibility(View.INVISIBLE);
        }
    }

    @OnClick({R.id.lt_main_title_left, R.id.lt_main_title_right, R.id.iv_ask_camera, R.id.iv_ask_picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                break;
            case R.id.lt_main_title_right:
                break;
            case R.id.iv_ask_camera:
                break;
            case R.id.iv_ask_picture:
                break;
        }
    }
}
