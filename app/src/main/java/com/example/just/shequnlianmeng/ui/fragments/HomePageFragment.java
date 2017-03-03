package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.BannerImageLoader;
import com.example.just.shequnlianmeng.adapter.HomePageGVAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by just on 2017/3/1.
 */

public class HomePageFragment extends Fragment{
    @BindView(R.id.homepage_banner)
    Banner homepage_banner;
    @BindView(R.id.home_ad_gridview)
    GridView homepage_gd;
    private ArrayList<String> imgList;
    String[] images={"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=699105693,866957547&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=787324823,4149955059&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2152422253,1846971893&fm=21&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3258213409,1470632782&fm=21&gp=0.jpg"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View containerView=inflater.inflate(R.layout.homepage_fragment,container,false);
        ButterKnife.bind(this,containerView);
        initView();
        return  containerView;
    }

    @Override
    public void onStart() {
        super.onStart();
        homepage_banner.startAutoPlay();
    }

    private void initView() {
        initBanner();
        initGridView();
    }

    private void initGridView() {
        ArrayList<String> data=new ArrayList<>();
        data.add("干货分享");
        data.add("灵感贩卖");
        data.add("求助中心");
        data.add("直播频道");
        data.add("领养中心");
        data.add("联盟打车");
        homepage_gd.setAdapter(new HomePageGVAdapter(getContext(),data));
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

    @Override
    public void onStop() {
        super.onStop();
        homepage_banner.stopAutoPlay();
    }
}
