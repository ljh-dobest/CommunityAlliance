package com.example.just.shequnlianmeng.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.BannerImageLoader;
import com.example.just.shequnlianmeng.adapter.ZhongChouLVAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by just on 2017/3/1.
 */

public class ZhongChouFragment extends Fragment{
    Banner zc_banner;
    @BindView(R.id.zc_lv)
    ListView zc_lv;
    RelativeLayout lv_header;
    private ArrayList<String> imgList;
    String[] images={"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=699105693,866957547&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=787324823,4149955059&fm=21&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2152422253,1846971893&fm=21&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3258213409,1470632782&fm=21&gp=0.jpg"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View containerView=inflater.inflate(R.layout.zhongchou_fragment,container,false);
        ButterKnife.bind(this,containerView);
       lv_header= (RelativeLayout) inflater.inflate(R.layout.zc_lv_header,null);
        zc_banner= (Banner) lv_header.findViewById(R.id.zc_banner);
          initView();
        return  containerView;
    }

    private void initView() {
        initBanner();
        initListView();
    }

    private void initListView() {
        ArrayList<String> data=new ArrayList<>();
        data.add("1");
        data.add("2");
        zc_lv.addHeaderView(lv_header);
        zc_lv.setAdapter(new ZhongChouLVAdapter(getContext(),data));
    }
    private void initBanner() {
        imgList=new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            imgList.add(images[i]);
        }
        //设置图片加载器
        zc_banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        zc_banner.setImages(imgList);
        //banner设置方法全部调用完毕时最后调用
        zc_banner.start();
    }
}
