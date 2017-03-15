package com.example.just.shequnlianmeng.ui.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseActivity;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.bean.RelationBean;
import com.example.just.shequnlianmeng.interfaces.IRelationMapView;
import com.example.just.shequnlianmeng.presenters.RelationMapPresenter;
import com.example.just.shequnlianmeng.ui.fragments.InterpersonalConnectionsFragment;
import com.example.just.shequnlianmeng.ui.fragments.RelationMapFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/11.
 */

public class RelationMapActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.rg_relation)
    RadioGroup radioGroup;
    @BindView(R.id.rb_connection)
    RadioButton rb_connection;
    @BindView(R.id.rb_relation_map)
    RadioButton rb_relation_map;
    @BindView(R.id.relation_vp)
    ViewPager relation_vp;


    private int checkedcolor = 0xffff3300;
    private RadioButton radioButtons[];
    private List<Fragment> fragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation_map);
        ButterKnife.bind(this);
        initFragment();
    }
    private void initFragment() {
        radioButtons = new RadioButton[]{rb_connection,rb_relation_map};
        fragments=new ArrayList<Fragment>();
        fragments.add(new InterpersonalConnectionsFragment());
        fragments.add(new RelationMapFragment());
        relation_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        rb_connection.setChecked(true);
        relation_vp.addOnPageChangeListener(this);
        relation_vp.setCurrentItem(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rb=null;
        for (int i = 0; i < radioButtons.length; i++) {
            rb = radioButtons[i];
            rb.setChecked(false);
            if (position == i) {
                rb.setChecked(true);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        int curItem=0;
        reset();
        RadioButton rb = (RadioButton) group.findViewById(checkedId);
        rb.setTextColor(Color.BLACK);
        for (int i=0;i<radioButtons.length;i++){
            if(checkedId==radioButtons[i].getId()){
                curItem=i;
            }
        }
        relation_vp.setCurrentItem(curItem);
    }
    private void reset() {
        for (RadioButton rb : radioButtons) {
            rb.setTextColor(Color.GREEN);
        }

    }
}
