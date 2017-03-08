package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.BannerImageLoader;
import com.example.just.shequnlianmeng.adapter.HomePageGVAdapter;
import com.example.just.shequnlianmeng.adapter.HomePageLVAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by just on 2017/3/1.
 */

public class HomePageFragment extends Fragment implements AbsListView.OnScrollListener {
    LinearLayout homepage_lv_header;
    Banner homepage_banner;
    GridView homepage_gv;
    @BindView(R.id.homepage_lv)
    ListView homepage_lv;
    @BindView(R.id.homepage_iv_top)
    ImageView homepage_iv_top;
    private ArrayList<String> imgList;
    String[] images={"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=699105693,866957547&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=787324823,4149955059&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2152422253,1846971893&fm=21&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3258213409,1470632782&fm=21&gp=0.jpg"};
    private ArrayList<String> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View containerView=inflater.inflate(R.layout.homepage_fragment,container,false);
        ButterKnife.bind(this,containerView);
        homepage_lv_header= (LinearLayout) inflater.inflate(R.layout.homepage_lv_header,null);
        initView();
        return  containerView;
    }

    private void initView() {
        homepage_banner= (Banner) homepage_lv_header.findViewById(R.id.homepage_banner);
        homepage_gv= (GridView) homepage_lv_header.findViewById(R.id.homepage_gv);
        initBanner();
        initGridView();
        initListView();
    }

   private void initListView() {
       homepage_lv.addHeaderView(homepage_lv_header);
       homepage_lv.setAdapter(new HomePageLVAdapter(getContext(),data));
       homepage_lv.setOnScrollListener(this);
    }

    private void initGridView() {
        data = new ArrayList<>();
        data.add("干货分享");
        data.add("灵感贩卖");
        data.add("认领中心");
        data.add("直播中心");
        homepage_gv.setAdapter(new HomePageGVAdapter(getContext(), data));
    }

    private void initBanner() {
        imgList=new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            imgList.add(images[i]);
        }
        //设置图片加载器
        homepage_banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        homepage_banner.setImages(imgList);
        //banner设置方法全部调用完毕时最后调用
        homepage_banner.start();
    }
    @OnClick(R.id.homepage_iv_top)
    public void toTopOnClick(View view){
        switch (view.getId()) {
            case R.id.homepage_iv_top:
                homepage_lv.smoothScrollToPosition(0);
                break;
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        homepage_banner.startAutoPlay();
    }
    @Override
    public void onStop() {
        super.onStop();
        homepage_banner.stopAutoPlay();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (visibleItemCount + firstVisibleItem == totalItemCount) {
            homepage_iv_top.setVisibility(View.VISIBLE);
        }else{
            homepage_iv_top.setVisibility(View.GONE);
        }
    }
//    @BindView(R.id.tl_home)
//    TabLayout tl_home;
//    @BindView(R.id.vp_home)
//    ViewPager vp_home;
//    private List<Fragment> fragments;
//    private List<String> mTitle;
//    private HomePageFragment homePageFragment;
//    private ZhongChouFragment zhongChouFragment;
//    private YiYuanDuoBaoFragment yiYuanDuoBaoFragment;
//    private UsefulActivityFragment usefulActivityFragment;
//    private PlatformActivityFragment platformActivityFragment;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View ContainerView=inflater.inflate(R.layout.fragment_home,container,false);
//        ButterKnife.bind(this,ContainerView);
//        init();
//        return  ContainerView;
//    }
//
//    private void init() {
//        initTitle();
//        initFragments();
//    }
//
//    private void initFragments() {
//        homePageFragment=new HomePageFragment();
//        zhongChouFragment=new ZhongChouFragment();
//        yiYuanDuoBaoFragment=new YiYuanDuoBaoFragment();
//        usefulActivityFragment=new UsefulActivityFragment();
//        platformActivityFragment=new PlatformActivityFragment();
//        fragments=new ArrayList<Fragment>();
//        tl_home.setTabMode(TabLayout.MODE_FIXED);
//        fragments.add(homePageFragment);
//        fragments.add(zhongChouFragment);
//        fragments.add(yiYuanDuoBaoFragment);
//        fragments.add(usefulActivityFragment);
//        fragments.add(platformActivityFragment);
//        vp_home.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
//            //此方法用来显示tab上的名字
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return mTitle.get(position);
//            }
//            @Override
//            public Fragment getItem(int position) {
//                return fragments.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return fragments.size();
//            }
//        });
//        tl_home.setupWithViewPager(vp_home);
//        tl_home.addOnTabSelectedListener(this);
//    }
//
//    //初始化标题
//    private void initTitle() {
//        mTitle=new ArrayList<>();
//        mTitle.add("首页");
//        mTitle.add("众筹");
//        mTitle.add("一元夺宝");
//        mTitle.add("公益活动");
//        mTitle.add("平台活动");
//    }
//
//    @Override
//    public void onTabSelected(TabLayout.Tab tab) {
//        vp_home.setCurrentItem(tab.getPosition());
//    }
//
//    @Override
//    public void onTabUnselected(TabLayout.Tab tab) {
//
//    }
//
//    @Override
//    public void onTabReselected(TabLayout.Tab tab) {
//
//    }
}
