package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by just on 2017/3/1.
 */

public class HomeFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    @BindView(R.id.tl_home)
    TabLayout tl_home;
    @BindView(R.id.vp_home)
    ViewPager vp_home;
    private List<Fragment> fragments;
    private List<String> mTitle;
    private HomePageFragment homePageFragment;
    private ZhongChouFragment zhongChouFragment;
    private YiYuanDuoBaoFragment yiYuanDuoBaoFragment;
    private UsefulActivityFragment usefulActivityFragment;
    private PlatformActivityFragment platformActivityFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ContainerView=inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,ContainerView);
        init();
        return  ContainerView;
    }

    private void init() {
        initTitle();
        initFragments();
    }

    private void initFragments() {
      homePageFragment=new HomePageFragment();
        zhongChouFragment=new ZhongChouFragment();
        yiYuanDuoBaoFragment=new YiYuanDuoBaoFragment();
        usefulActivityFragment=new UsefulActivityFragment();
        platformActivityFragment=new PlatformActivityFragment();
        fragments=new ArrayList<Fragment>();
        tl_home.setTabMode(TabLayout.MODE_FIXED);
        fragments.add(homePageFragment);
        fragments.add(zhongChouFragment);
        fragments.add(yiYuanDuoBaoFragment);
        fragments.add(usefulActivityFragment);
        fragments.add(platformActivityFragment);
        vp_home.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
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
        tl_home.setupWithViewPager(vp_home);
        tl_home.addOnTabSelectedListener(this);
    }

    //初始化标题
    private void initTitle() {
        mTitle=new ArrayList<>();
        mTitle.add("首页");
        mTitle.add("众筹");
        mTitle.add("一元夺宝");
        mTitle.add("公益活动");
        mTitle.add("平台活动");
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp_home.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
