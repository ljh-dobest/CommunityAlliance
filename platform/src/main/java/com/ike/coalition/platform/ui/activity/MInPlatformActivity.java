package com.ike.coalition.platform.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.ike.coalition.platform.R;
import com.ike.coalition.platform.adapter.SimpleAdapter;
import com.ike.coalition.platform.base.view.BaseMvpActivity;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.interfaces.IMinPlatformListView;
import com.ike.coalition.platform.presenters.MinPlatformPresenter;
import com.ike.coalition.platform.utils.T;
import com.ike.coalition.platform.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MInPlatformActivity extends BaseMvpActivity<IMinPlatformListView, MinPlatformPresenter> implements IMinPlatformListView {

    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerViewTestRv;
    @BindView(R.id.xrefreshview)
    XRefreshView xrefreshview;


    SimpleAdapter adapter;
    List<PlatformBean> personList = new ArrayList<PlatformBean>();
    GridLayoutManager layoutManager;
    private int mLoadCount = 0;

    private int limit = 20;
    private int page = 1;

    private boolean isRefresh;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_platform);
        ButterKnife.bind(this);
        initView();
        initClick();
    }

    @Override
    public MinPlatformPresenter initPresenter() {
        return new MinPlatformPresenter();
    }

    TextView tv_like_btn;
    ImageView iv_like_btn;

    private void initView() {

        ltMainTitle.setText("我参与的活动");
        ltMainTitleRight.setVisibility(View.GONE);
        xrefreshview.setPullLoadEnable(true);
        recyclerViewTestRv.setHasFixedSize(true);

        initData();
        adapter = new SimpleAdapter(personList, this);
        // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
        layoutManager = new GridLayoutManager(this, 1);
        recyclerViewTestRv.setLayoutManager(layoutManager);


        CustomGifHeader header = new CustomGifHeader(this);
        xrefreshview.setCustomHeaderView(header);
        recyclerViewTestRv.setAdapter(adapter);
        xrefreshview.setAutoLoadMore(false);
        xrefreshview.setPinnedTime(1000);
        xrefreshview.setMoveForHorizontal(true);
//        recyclerviewAdapter.setHeaderView(headerView, recyclerView);
        adapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
//        xRefreshView1.setPullRefreshEnable(false);
        //设置在下拉刷新被禁用的情况下，是否允许界面被下拉,默认是true
//        xRefreshView1.setMoveHeadWhenDisablePullRefresh(false);
//        xRefreshView1.enablePullUpWhenLoadCompleted(false);
//		xRefreshView1.setPullLoadEnable(false);
//        xRefreshView1.enableRecyclerViewPullUp(false);
        //设置静默加载时提前加载的item个数
//		xRefreshView1.setPreLoadCount(2);

        xrefreshview.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {

                page = 1;
                initData();

            }

            @Override
            public void onLoadMore(boolean isSilence) {

                page++;
                initData();

            }
        });

    }

    private void initData() {
        isRefresh = true;
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "111");
        formData.put("type", "6");
        presenter.platformInfoPresenter(formData);

    }

    private void initClick() {
        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, PlatformBean data) {
                Intent intent = new Intent(MInPlatformActivity.this, PlatformParticularsActivity.class);
                intent.putExtra("bean", data);
                startActivity(intent);
            }
        });
    }


    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        MInPlatformActivity.this.finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {
        if (isRefresh)
            if (page == 1) {
                xrefreshview.stopRefresh(false);
            } else {
                xrefreshview.stopLoadMore(false);
            }
        T.showShort(MInPlatformActivity.this, errorString);
    }

    @Override
    public void setMinPlatformListData(List<PlatformBean> data) {

        if (page == 1) {
            xrefreshview.stopRefresh(true);
        } else {
            xrefreshview.stopLoadMore(true);
        }
        adapter.setData(data, page);
    }


}
