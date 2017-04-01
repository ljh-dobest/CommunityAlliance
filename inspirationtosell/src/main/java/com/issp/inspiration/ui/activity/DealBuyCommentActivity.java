package com.issp.inspiration.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.inspiration.R;
import com.issp.inspiration.adapter.DealBuyCommentListAdapter;
import com.issp.inspiration.base.view.BaseMvpActivity;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.bean.DealBuyCommentBean;
import com.issp.inspiration.interfaces.IDealBuyCommentListView;
import com.issp.inspiration.presenters.DealBuyCommentPresenter;
import com.issp.inspiration.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 评论列表
 * Created by T-BayMax on 2017/3/18.
 */

public class DealBuyCommentActivity extends BaseMvpActivity<IDealBuyCommentListView, DealBuyCommentPresenter> implements IDealBuyCommentListView {

        @BindView(R.id.lt_main_title_left)
        TextView ltMainTitleLeft;
        @BindView(R.id.lt_main_title)
        TextView ltMainTitle;
        @BindView(R.id.lt_main_title_right)
        TextView ltMainTitleRight;
        @BindView(R.id.editText)
        EditText editText;
        @BindView(R.id.tv_submit_comment)
        TextView tvSubmitComment;
        @BindView(R.id.recycler_view_test_rv)
        RecyclerView recyclerView;
        @BindView(R.id.xrefreshview)
        XRefreshView xRefreshView;

        private View headerView;

        private boolean isRefresh = true;

        List<DealBuyCommentBean> personList = new ArrayList<DealBuyCommentBean>();
        LinearLayoutManager layoutManager;
        private int mLoadCount = 0;

        private int limit = 20;
        private int page = 1;

    DealBuyCommentListAdapter adapter;

        private DealBuyBean shareBean;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_deal_buy_comments);
            ButterKnife.bind(this);
            initView();
        }

        private void initView() {
            ltMainTitle.setText("评论列表");
            Intent intent = getIntent();
            shareBean = (DealBuyBean) intent.getSerializableExtra("bean");

            xRefreshView.setPullLoadEnable(true);
            recyclerView.setHasFixedSize(true);

            initData();
            adapter = new DealBuyCommentListAdapter(personList, this);
            // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            // 静默加载模式不能设置footerview
            recyclerView.setAdapter(adapter);
            //设置刷新完成以后，headerview固定的时间
            xRefreshView.setPinnedTime(1500);
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
            formData.put("shareId", shareBean.getId());
            presenter.DealBuyCommentInfo(formData);
        }

        @OnClick(R.id.lt_main_title_left)
        void leftClick() {
            DealBuyCommentActivity.this.finish();
        }

        @OnClick(R.id.editText)
        void commentClick() {
            tvSubmitComment.setVisibility(View.VISIBLE);
        }

        @OnClick(R.id.tv_submit_comment)
        void submitCommentClick() {
            if (checkInputInfo()) {
                isRefresh = false;
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("shareId", shareBean.getId());
                formData.put("userId", "111");
                formData.put("content", editText.getText().toString().trim());
                presenter.addDealBuyCommentInfo(formData);
            }
        }

        @Override
        public DealBuyCommentPresenter initPresenter() {
            return new DealBuyCommentPresenter();
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
                    xRefreshView.stopRefresh(false);
                } else {
                    xRefreshView.stopLoadMore(false);
                }
            T.showShort(DealBuyCommentActivity.this, errorString);
        }

        @Override
        public void setDealBuyCommentListData(List<DealBuyCommentBean> data) {
            if (page == 1) {
                xRefreshView.stopRefresh(true);
            } else {
                xRefreshView.stopLoadMore(true);
            }
            adapter.setData(data, page);
        }

        @Override
        public void setAddCommentData(String data) {
            T.showShort(DealBuyCommentActivity.this, data);
            tvSubmitComment.setVisibility(View.GONE);
        }

        @Override
        public boolean checkInputInfo() {
            if (editText.getText().toString().equals("")) {
                return false;
            }
            return true;
        }
}
