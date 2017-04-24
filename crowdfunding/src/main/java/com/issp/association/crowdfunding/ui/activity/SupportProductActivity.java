package com.issp.association.crowdfunding.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.adapter.SupportProductAdapter;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.bean.ProductRewardBean;
import com.issp.association.crowdfunding.interfaces.ISupportProductListView;
import com.issp.association.crowdfunding.presenters.SupportProductPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 支持TA
 * Created by T-BayMax on 2017/3/18.
 */

public class SupportProductActivity extends BaseMvpActivity<ISupportProductListView, SupportProductPresenter> implements ISupportProductListView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.tv_confess_total)
    TextView tvConfessTotal;
    @BindView(R.id.tv_amount_total)
    TextView tvAmountTotal;
    @BindView(R.id.pb_schedule)
    ProgressBar pbSchedule;
    @BindView(R.id.tv_schedule)
    TextView tvSchedule;
    @BindView(R.id.iv_support_people_number)
    ImageView ivSupportPeopleNumber;
    @BindView(R.id.tv_support_people_number)
    TextView tvSupportPeopleNumber;
    @BindView(R.id.iv_time_remaining)
    ImageView ivTimeRemaining;
    @BindView(R.id.tv_time_remaining)
    TextView tvTimeRemaining;
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerViewTestRv;
    @BindView(R.id.xrefreshview)
    XRefreshView xrefreshview;
    private View headerView;

    List<ProductRewardBean> personList = new ArrayList<ProductRewardBean>();
    ProductCollectBean bean;
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;
    SupportProductAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_product);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        bean = (ProductCollectBean) getIntent().getSerializableExtra("bean");
        personList.addAll(bean.getProductReward());
        ltMainTitle.setText(getString(R.string.str_title_support));

        xrefreshview.setPullLoadEnable(true);

        recyclerViewTestRv.setHasFixedSize(true);

        initData();
        adapter = new SupportProductAdapter(personList, this);
        // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
        layoutManager = new LinearLayoutManager(this);
        recyclerViewTestRv.setLayoutManager(layoutManager);
        // 静默加载模式不能设置footerview
        recyclerViewTestRv.setAdapter(adapter);
        //设置刷新完成以后，headerview固定的时间
        xrefreshview.setPinnedTime(1000);
        xrefreshview.setMoveForHorizontal(true);
        xrefreshview.setPullLoadEnable(true);
        xrefreshview.setAutoLoadMore(false);

        //当需要使用数据不满一屏时不显示点击加载更多的效果时，解注释下面的三行代码
        //并注释掉第四行代码
      /*  CustomerFooter customerFooter = new CustomerFooter(this);
        customerFooter.setRecyclerView(recyclerView);
       adapter.setCustomLoadMoreView(customerFooter);*/
        adapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
        xrefreshview.enableReleaseToLoadMore(true);
        xrefreshview.enableRecyclerViewPullUp(true);
        xrefreshview.enablePullUpWhenLoadCompleted(true);


        xrefreshview.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {

            }

            @Override
            public void onLoadMore(boolean isSilence) {

            }
        });
        adapter.setOnItemClickListener(new SupportProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ProductRewardBean bean) {

            }

            @Override
            public void onSupportClick(View view, ProductRewardBean bean) {
                Intent intent = new Intent(SupportProductActivity.this, AddSupportProjectActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
            }
        });
    }

    private void initData() {

    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        SupportProductActivity.this.finish();
    }

    @Override
    public SupportProductPresenter initPresenter() {
        return new SupportProductPresenter();
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
    public void setSupportProductData(ArrayList<ProductCollectBean> data) {

    }
}
