package com.issp.association.crowdfunding.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.adapter.ProductCommentListAdapter;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.bean.CommentsBean;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IProductCommentListView;
import com.issp.association.crowdfunding.presenters.ProductCommentPresenter;
import com.issp.association.crowdfunding.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 评论列表
 * Created by T-BayMax on 2017/3/18.
 */

public class ProductCommentActivity extends BaseMvpActivity<IProductCommentListView, ProductCommentPresenter> implements IProductCommentListView {

    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.recycler_view_test_rv)
    RecyclerView recyclerView;
    @BindView(R.id.xrefreshview)
    XRefreshView xRefreshView;


    private int page = 1;
    private boolean isRefresh = true;

    private View headerView;
    ProductCollectBean bean;

    List<CommentsBean> personList = new ArrayList<CommentsBean>();
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;
    ProductCommentListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_comments);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        bean = (ProductCollectBean) getIntent().getSerializableExtra("bean");
        ltMainTitle.setText(getString(R.string.str_title_comment));

        xRefreshView.setPullLoadEnable(true);

        recyclerView.setHasFixedSize(true);

        initData();
        adapter = new ProductCommentListAdapter(personList, this);
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
               page=1;
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
        formData.put("articleId", bean.getId());
        formData.put("userId", "111");
        formData.put("type", "3");
        presenter.productCommentInfoPresenter(formData);
    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        ProductCommentActivity.this.finish();
    }

    @Override
    public ProductCommentPresenter initPresenter() {
        return new ProductCommentPresenter();
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
        T.showShort(ProductCommentActivity.this, errorString);
    }

    @Override
    public void setProductCommentListData(List<CommentsBean> data) {
        if (page == 1) {
            xRefreshView.stopRefresh(true);
        } else {
            xRefreshView.stopLoadMore(true);
        }
        adapter.setData(data, page);
    }
}
