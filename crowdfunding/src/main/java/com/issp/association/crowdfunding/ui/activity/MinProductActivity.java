package com.issp.association.crowdfunding.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.adapter.MinProductListAdapter;

import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IProductCollectListView;
import com.issp.association.crowdfunding.presenters.ProductCollectPresenter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的分享
 * Created by T-BayMax on 2017/3/18.
 */

public class MinProductActivity extends BaseMvpActivity<IProductCollectListView,ProductCollectPresenter> implements IProductCollectListView , RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.lt_main_title_left)
    TextView lt_main_title_left;
    @BindView(R.id.rg_relation)
    RadioGroup radioGroup;
    @BindView(R.id.rb_connection)
    RadioButton rb_connection;
    @BindView(R.id.rb_relation_map)
    RadioButton rb_relation_map;
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerView;
    @BindView(R.id.xrefreshview)
    XRefreshView xRefreshView;


    List<ProductCollectBean> personList = new ArrayList<ProductCollectBean>();
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;
    MinProductListAdapter adapter;

    private RadioButton radioButtons[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_product);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public ProductCollectPresenter initPresenter() {
        return new ProductCollectPresenter();
    }

    private void initView(){
        xRefreshView.setPullLoadEnable(true);

        recyclerView.setHasFixedSize(true);

        initShareData();
        adapter = new MinProductListAdapter(personList, this);
        // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // 静默加载模式不能设置footerview
        recyclerView.setAdapter(adapter);
        //设置刷新完成以后，headerview固定的时间
        xRefreshView.setPinnedTime(1000);
        xRefreshView.setMoveForHorizontal(true);
        xRefreshView.setPullLoadEnable(true);
        xRefreshView.setAutoLoadMore(false);

        //当需要使用数据不满一屏时不显示点击加载更多的效果时，解注释下面的三行代码
        //并注释掉第四行代码
      /*  CustomerFooter customerFooter = new CustomerFooter(this);
        customerFooter.setRecyclerView(recyclerView);
       adapter.setCustomLoadMoreView(customerFooter);*/
        adapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
        xRefreshView.enableReleaseToLoadMore(true);
        xRefreshView.enableRecyclerViewPullUp(true);
        xRefreshView.enablePullUpWhenLoadCompleted(true);


        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //模拟数据加载失败的情况
                        Random random = new Random();
                        boolean success = random.nextBoolean();
                        if(success){
                            xRefreshView.stopRefresh();
                        }else{
                            xRefreshView.stopRefresh(false);
                        }
                        //或者
//                        xRefreshView1.stopRefresh(success);
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            ProductCollectBean person = new ProductCollectBean();
                            adapter.insert(person,
                                    adapter.getAdapterItemCount());
                        }
                        mLoadCount++;
                        if (mLoadCount >= 3) {
                            xRefreshView.setLoadComplete(true);
                        } else {
                            // 刷新完成必须调用此方法停止加载
                            xRefreshView.stopLoadMore();
                        }
                    }
                }, 1000);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            ProductCollectBean person = new ProductCollectBean();
            personList.add(person);
        }
    }

    private void initShareData() {
        radioButtons = new RadioButton[]{rb_connection, rb_relation_map};
        radioGroup.setOnCheckedChangeListener(this);
        rb_connection.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        reset();
        RadioButton rb = (RadioButton) group.findViewById(checkedId);
        rb.setTextColor(Color.BLACK);

    }

    private void reset() {
        for (RadioButton rb : radioButtons) {
            rb.setTextColor(Color.GREEN);
        }

    }
    @OnClick(R.id.lt_main_title_left)
    void backClick(){
        MinProductActivity.this.finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {

    }

    @Override
    public void setProductCollectData(ArrayList<ProductCollectBean> data) {

    }
}
