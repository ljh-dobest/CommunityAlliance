package com.example.just.shequnlianmeng;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.just.shequnlianmeng.base.view.BaseActivity;
import com.example.just.shequnlianmeng.ui.fragments.ChatFragment;
import com.example.just.shequnlianmeng.ui.fragments.HomeFragment;
import com.example.just.shequnlianmeng.ui.fragments.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.rb_home)
    RadioButton rb_home;
//    @BindView(R.id.rb_community)
//    RadioButton rb_community;
//    @BindView(R.id.rb_search)
//    RadioButton rb_search;
    @BindView(R.id.rb_chat)
    RadioButton rb_chat;
    @BindView(R.id.rb_mine)
    RadioButton rb_mine;
    @BindView(R.id.rg)
    RadioGroup radioGroup;
    @BindView(R.id.main_vp)
    ViewPager main_vp;
    @BindView(R.id.rl_main_header)
    RelativeLayout rl_main_header;

    private int checkedcolor = 0xffff3300;
    private RadioButton radioButtons[];
  private List<Fragment> fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        radioButtons = new RadioButton[]{rb_home,rb_chat,rb_mine};
        fragments=new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new ChatFragment());
        fragments.add(new MineFragment());
        main_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        radioGroup.setOnCheckedChangeListener(this);
        rb_home.setChecked(true);
        main_vp.addOnPageChangeListener(this);
        main_vp.setCurrentItem(0);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int curItem=0;
        reset();
        RadioButton rb = (RadioButton) group.findViewById(checkedId);
        rb.setTextColor(checkedcolor);
        for (int i=0;i<radioButtons.length;i++){
            if(checkedId==radioButtons[i].getId()){
                curItem=i;
            }
        }
        main_vp.setCurrentItem(curItem);
    }



    private void reset() {
        for (RadioButton rb : radioButtons) {
            rb.setTextColor(Color.BLACK);
        }

    }
    private long clickTime = 0; //记录第一次点击的时间
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(getApplicationContext(),"你忍心退出吗~~",
                    Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            finish();

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rb=null;
        for (int i = 0; i < radioButtons.length; i++) {
             rb=radioButtons[i];
            rb.setChecked(false);
            if(position==i){
                rb.setChecked(true);
            }
            if(position==2){//我的碎片时隐藏头
                rl_main_header.setVisibility(View.GONE);
            }else{
                rl_main_header.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
