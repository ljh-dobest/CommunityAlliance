package com.issp.inspiration.base.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.issp.inspiration.R;
import com.issp.inspiration.utils.DataUtils;


/**
 * Created by Min on 2016/11/23.
 * activity基类
 */

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;
/*    protected LinearLayout mHeadLayout;
    private ViewFlipper mContentView;
    protected Button btnLeft,btnRight;
    protected TextView tvTitle;
    protected TextView tvHeadText;
    protected Drawable backDrawable;*/


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  getSupportActionBar().hide();
        super.setContentView(R.layout.activity_base);
        setVolumeControlStream(AudioManager.STREAM_MUSIC); //使得音量键控制媒体声音
        mContext=this;
        //初始化
        /*mContentView= (ViewFlipper) super.findViewById(R.id.layout_container);
        mHeadLayout= (LinearLayout) super.findViewById(R.id.layout_head);
        tvHeadText= (TextView) findViewById(R.id.text_right);
        btnLeft= (Button) super.findViewById(R.id.btn_left);
        btnRight= (Button) super.findViewById(R.id.btn_right);
        tvTitle= (TextView) super.findViewById(R.id.tv_title);
        backDrawable=getResources().getDrawable(R.mipmap.ac_back_icon);
        backDrawable.setBounds(0,0,backDrawable.getMinimumWidth(),backDrawable.getMinimumHeight());*/
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
           if (DataUtils.isFastDoubleClick()) {
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }


    /*@Override
    public void setContentView(View view) {
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        mContentView.addView(view,lp);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View view= LayoutInflater.from(this).inflate(layoutResID,null);
        setContentView(view);
    }

    protected boolean flags=true;

    *//**
     * 设置头部是否可见
     * @return
     *//*
    public void setHeadVisibility(int visibility){
//        if(true) {
            mHeadLayout.setVisibility(visibility);
//        }else {
//            mHeadLayout.setVisibility(View.VISIBLE);
//        }
    }

    *//**
     * 设置左边是否可见
     * @return
     *//*
    public void setHeadLeftButton(int visibility){
        btnLeft.setVisibility(View.VISIBLE);
    }

    *//**
     * 设置右边是否可见
     * @return
     *//*
    public void setHeadRightButton(int visibility){
        btnRight.setVisibility(View.VISIBLE);
    }

    *//**
     * 设置标题
     * @return
     *//*
    public void setTitle(int titleId){
        setTitle(getString(titleId),false);
    }

    public void setTitle(int titleId,boolean flag){
        setTitle(getString(titleId),flag);
    }

    public void setTitle(String title){
        setTitle(title,false);
    }

    public void setTitle(String title, boolean flag) {
        tvTitle.setText(title);
        if(flag){
            btnLeft.setCompoundDrawables(null,null,null,null);
        }else{
            btnLeft.setCompoundDrawables(backDrawable,null,null,null);
        }
    }

    *//**
     * 点击左按钮
     *//*
    public void onHeadLeftButtonClick(View v) {
        finish();
    }

    *//**
     * 点击右按钮
     *//*
    public void onHeadRightButtonClick(View v) {

    }

    public Button getBtnLeft() {
        return btnLeft;
    }

    public void setBtnLeft(Button btnLeft) {
        this.btnLeft = btnLeft;
    }

    public Button getBtnRight() {
        return btnRight;
    }

    public void setBtnRight(Button btnRight) {
        this.btnRight = btnRight;
    }

    public Drawable getBackDrawable() {
        return backDrawable;
    }

    public void setBackDrawable(Drawable backDrawable) {
        this.backDrawable = backDrawable;
    }*/

    //设置app字体不根据系统字体的大小改变而改变
    @Override
    public Resources getResources() {
        Resources resources=super.getResources();
        Configuration configuration=new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());
        return resources;
    }
}
