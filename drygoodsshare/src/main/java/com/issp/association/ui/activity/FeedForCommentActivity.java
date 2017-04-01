package com.issp.association.ui.activity;

<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> bxh
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.association.R;
import com.issp.association.adapter.FeedForCommentListAdapter;
import com.issp.association.adapter.ShareCommentListAdapter;
import com.issp.association.base.view.BaseMvpActivity;
<<<<<<< HEAD
import com.issp.association.bean.ShareCommentBean;
import com.issp.association.interfaces.IFeedForCommentListView;
import com.issp.association.presenters.FeedForCommentPresenter;
import com.issp.association.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.List;
=======
import com.issp.association.bean.ShareBean;
import com.issp.association.bean.ShareCommentBean;
import com.issp.association.interfaces.IFeedForCommentListView;
import com.issp.association.presenters.FeedForCommentPresenter;
import com.issp.association.utils.T;
import com.issp.association.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> bxh
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 评论列表
 * Created by T-BayMax on 2017/3/18.
 */

public class FeedForCommentActivity extends BaseMvpActivity<IFeedForCommentListView, FeedForCommentPresenter> implements IFeedForCommentListView {

    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.editText)
    EditText editText;
<<<<<<< HEAD
=======
    @BindView(R.id.tv_submit_comment)
    TextView tvSubmitComment;
>>>>>>> bxh
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerView;
    @BindView(R.id.xrefreshview)
    XRefreshView xRefreshView;

<<<<<<< HEAD

    private View headerView;
=======
    private View headerView;

    private boolean isRefresh = true;

    List<ShareCommentBean> personList = new ArrayList<ShareCommentBean>();
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;

    private int limit = 20;
    private int page = 1;

    FeedForCommentListAdapter adapter;

    private ShareBean shareBean;
>>>>>>> bxh

    List<ShareCommentBean> personList = new ArrayList<ShareCommentBean>();
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;
    FeedForCommentListAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_for_comments);
        ButterKnife.bind(this);
        initView();
    }

<<<<<<< HEAD
    private void initView(){
        ltMainTitle.setText("评论列表");
        xRefreshView.setPullLoadEnable(true);

=======
    private void initView() {
        ltMainTitle.setText("评论列表");
        Intent intent = getIntent();
        shareBean = (ShareBean) intent.getSerializableExtra("bean");

        xRefreshView.setPullLoadEnable(true);
>>>>>>> bxh
        recyclerView.setHasFixedSize(true);

        initData();
        adapter = new FeedForCommentListAdapter(personList, this);
        // 设置静默加载模式
//		xRefreshView1.setSilenceLoadMore();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // 静默加载模式不能设置footerview
        recyclerView.setAdapter(adapter);
        //设置刷新完成以后，headerview固定的时间
<<<<<<< HEAD
        xRefreshView.setPinnedTime(1000);
=======
        xRefreshView.setPinnedTime(1500);
>>>>>>> bxh
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
<<<<<<< HEAD
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
=======
                page = 1;
                initData();
>>>>>>> bxh
            }

            @Override
            public void onLoadMore(boolean isSilence) {
<<<<<<< HEAD
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            ShareCommentBean person = new ShareCommentBean();
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
            ShareCommentBean person = new ShareCommentBean();
            personList.add(person);
        }
    }
    @OnClick(R.id.lt_main_title_left)
    void leftClick(){
        FeedForCommentActivity.this.finish();
    }

    @Override
    public FeedForCommentPresenter initPresenter() {
        return new FeedForCommentPresenter();
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
    public void setFeedForCommentListData(ArrayList<ShareCommentBean> data) {

=======
                page++;
                initData();
            }
        });

    }

    private void initData() {
        isRefresh = true;
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("shareId", shareBean.getId());
        presenter.FeedCommentInfo(formData);
    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        FeedForCommentActivity.this.finish();
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
            presenter.addFeedCommentInfo(formData);
        }
    }

    @Override
    public FeedForCommentPresenter initPresenter() {
        return new FeedForCommentPresenter();
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
        T.showShort(FeedForCommentActivity.this, errorString);
    }

    @Override
    public void setFeedForCommentListData(ArrayList<ShareCommentBean> data) {
        if (page == 1) {
            xRefreshView.stopRefresh(true);
        } else {
            xRefreshView.stopLoadMore(true);
        }
        adapter.setData(data, page);
    }

    @Override
    public void setAddCommentData(String data) {
        T.showShort(FeedForCommentActivity.this, data);
        tvSubmitComment.setVisibility(View.GONE);
    }

    @Override
    public boolean checkInputInfo() {
        if (editText.getText().toString().equals("")) {
            return false;
        }
        return true;
>>>>>>> bxh
    }
}
