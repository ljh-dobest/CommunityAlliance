package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.BaseActivity;
import com.example.just.shequnlianmeng.ui.fragments.LoginFragment;
import com.example.just.shequnlianmeng.ui.fragments.RegisterFragment;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements TabLayout.OnTabSelectedListener, RegisterFragment.FinishRegisterListener {
    @BindView(R.id.tl_login)
    TabLayout tl_login;
    @BindView(R.id.vp_login)
    ViewPager vp_login;
    private List<Fragment> fragments;
    private List<String> mTitle;
    private RegisterFragment registerFragment;
    private LoginFragment loginFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initTitle();
        initFragments();
    }

    private void initFragments() {
        registerFragment=new RegisterFragment();
        registerFragment.setListener(this);
        loginFragment=new LoginFragment();
        fragments=new ArrayList<Fragment>();
        tl_login.setTabMode(TabLayout.MODE_FIXED);
        fragments.add(loginFragment);
        fragments.add(registerFragment);
        vp_login.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tl_login.setupWithViewPager(vp_login);
        tl_login.addOnTabSelectedListener(this);
    }

    //初始化标题
    private void initTitle() {
        mTitle=new ArrayList<>();
        mTitle.add("登录");
        mTitle.add("注册");
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp_login.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    //注册完成调回登录页面
    @Override
    public void finishRegister() {
        vp_login.setCurrentItem(0);
        LoadDialog.dismiss(LoginActivity.this);
        T.showShort(this,"注册成功！恭喜您加入艾佳大家庭~~");
    }
}
