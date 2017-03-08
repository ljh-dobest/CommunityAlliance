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

public class HomeFragment extends Fragment implements AbsListView.OnScrollListener {
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
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("i");
        }
        homepage_lv.addHeaderView(homepage_lv_header);
        homepage_lv.setAdapter(new HomePageLVAdapter(getContext(),list));
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
}
