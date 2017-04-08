package com.issp.association.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.association.MainActivity;
import com.issp.association.R;
import com.issp.association.adapter.FeedForCommentListAdapter;
import com.issp.association.adapter.MinShareListAdapter;
import com.issp.association.base.view.BaseActivity;
import com.issp.association.base.view.BaseMvpActivity;
import com.issp.association.bean.ShareBean;
import com.issp.association.bean.ShareCommentBean;
import com.issp.association.interfaces.IMinShareListView;
import com.issp.association.presenters.MinShareInfoPresenter;
import com.issp.association.utils.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的分享
 * Created by T-BayMax on 2017/3/18.
 */

public class MinShareActivity extends BaseMvpActivity<IMinShareListView, MinShareInfoPresenter> implements IMinShareListView, RadioGroup.OnCheckedChangeListener {

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


    List<ShareBean> personList = new ArrayList<ShareBean>();
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;
    MinShareListAdapter adapter;


    private boolean isRefresh;
    private int page = 1;
    private int type;
    private RadioButton radioButtons[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_share);
        ButterKnife.bind(this);
        initView();
        initData();
        initClick();
    }

    @Override
    public MinShareInfoPresenter initPresenter() {
        return new MinShareInfoPresenter();
    }

    private void initView() {
        xRefreshView.setPullLoadEnable(true);

        recyclerView.setHasFixedSize(true);

        initShareData();
        adapter = new MinShareListAdapter(personList, this);
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
        // isRefresh = true;
        Map<String, String> formData = new HashMap<String, String>(0);
        formData.put("userId", "110");
        // formData.put("page", page + "");
        presenter.MinShareInfoPresenter(formData);
    }

    TextView tv_like_btn;
    ImageView iv_like_btn;
    private void initClick() {
        adapter.setOnItemClickListener(new MinShareListAdapter.OnItemClickListener() {
            @Override
            public void onShareClick(View view, ShareBean bean) {

            }

            @Override
            public void onItemClick(View view, ShareBean bean) {
                Intent intent = new Intent(MinShareActivity.this, ReadShareActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
            }

            @Override
            public void onLikeClick(View view, ShareBean bean) {
                isRefresh = false;
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("userId", "111");
                formData.put("articleId", bean.getId());
                formData.put("type", "3");
                formData.put("status", "1");
                tv_like_btn = (TextView) view.findViewById(R.id.tv_like_btn);
                iv_like_btn = (ImageView) view.findViewById(R.id.iv_like_btn);

                presenter.sharePraiseInfoPresenter(formData);
            }

            @Override
            public void onCommentClick(View view, ShareBean bean) {
                Intent intent = new Intent(MinShareActivity.this, FeedForCommentActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
            }
        });
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
    void backClick() {
        MinShareActivity.this.finish();
    }

    @OnClick(R.id.rb_connection)
    void connectionClick() {
        type = 1;
        adapter.clear();
        initData();
    }

    @OnClick(R.id.rb_relation_map)
    void relationMapClick() {
        type = 2;
        adapter.clear();
        initData();
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
        T.showShort(MinShareActivity.this, errorString);
    }

    @Override
    public void setMinShareListData(List<ShareBean> data) {
        if (page == 1) {
            xRefreshView.stopRefresh(true);
        } else {
            xRefreshView.stopLoadMore(true);
        }
        if (data.size() < 1) {
            T.showShort(MinShareActivity.this, "没有了");
            return;
        }
        adapter.setData(data, page);
    }

    @Override
    public void sharePraise(String data) {
        int likes = Integer.parseInt(tv_like_btn.getText().toString().trim());
        tv_like_btn.setText((likes + 1) + "");
        iv_like_btn.setImageResource(R.mipmap.img_have_thumb_up_btn);
        T.showShort(MinShareActivity.this, data);
    }
}
