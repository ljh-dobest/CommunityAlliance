package com.issp.association.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.issp.association.R;
import com.issp.association.adapter.FeedForCommentListAdapter;
import com.issp.association.base.view.BaseMvpActivity;
import com.issp.association.bean.CommentsBean;
import com.issp.association.bean.ShareBean;
import com.issp.association.interfaces.IFeedForCommentListView;
import com.issp.association.presenters.FeedForCommentPresenter;
import com.issp.association.utils.T;

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

public class FeedForCommentActivity extends BaseMvpActivity<IFeedForCommentListView, FeedForCommentPresenter> implements IFeedForCommentListView {

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
    private boolean isComment=false;

    List<CommentsBean> personList = new ArrayList<CommentsBean>();
    LinearLayoutManager layoutManager;
    private int mLoadCount = 0;

    private int limit = 20;
    private int page = 1;

    FeedForCommentListAdapter adapter;

    private ShareBean bean;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_for_comments);
        ButterKnife.bind(this);
        initView();
        initData();
        initItemClick();
    }

    private void initView() {
        ltMainTitle.setText("评论列表");
        Intent intent = getIntent();
        bean = (ShareBean) intent.getSerializableExtra("bean");

        xRefreshView.setPullLoadEnable(true);
        recyclerView.setHasFixedSize(true);

        adapter = new FeedForCommentListAdapter(personList, this);
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
        formData.put("articleId", bean.getId());
        formData.put("userId","111");
        formData.put("type","3");
        presenter.FeedCommentInfo(formData);
    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        FeedForCommentActivity.this.finish();
    }

    @OnClick(R.id.editText)
    void commentClick() {
        isComment=false;
        tvSubmitComment.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.tv_submit_comment)
    void submitCommentClick() {
        if (checkInputInfo()) {
            isRefresh = false;
            Map<String, String> formData = new HashMap<String, String>(0);
            if (isComment){
                formData.put("commentId",commentsBean.getId());
            }
            formData.put("articleId", bean.getId());
            formData.put("userId", "111");
            formData.put("type","3");
            formData.put("content", editText.getText().toString().trim());
            presenter.addFeedCommentInfo(formData);
        }
    }
    FeedForCommentListAdapter.AdapterViewHolder viewHolder;
    CommentsBean commentsBean;
    void initItemClick(){
        adapter.setOnItemClickListener(new FeedForCommentListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FeedForCommentListAdapter.AdapterViewHolder viewHolder, CommentsBean bean) {
                isComment=true;
                editText.requestFocus();
                tvSubmitComment.setVisibility(View.VISIBLE);
                editText.setHint("回复"+bean.getNickname());
            }

            @Override
            public void onLikeClick(FeedForCommentListAdapter.AdapterViewHolder viewHolder, CommentsBean bean) {
                isRefresh = false;
                Map<String, String> formData = new HashMap<String, String>(0);
                formData.put("userId", "111");
                formData.put("commentId",bean.getId());
                formData.put("status", bean.getLikesStatus()==0?"1":"0");
                presenter.addCommentLikes(formData);
                FeedForCommentActivity.this.viewHolder=viewHolder;
                FeedForCommentActivity.this.commentsBean=bean;
            }
        });
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
    public void setFeedForCommentListData(List<CommentsBean> data) {
        if (page == 1) {
            xRefreshView.stopRefresh(true);
        } else {
            xRefreshView.stopLoadMore(true);
        }
        adapter.setData(data, page);
    }

    @Override
    public void commentLikes(String data) {
        if (commentsBean.getLikesStatus() == 0) {
            viewHolder.ivLikeBtn.setImageResource(R.mipmap.img_comments_have_thumb_up_btn);
            viewHolder.tvLikeBtn.setText((commentsBean.getLikes()+1)+"");
            T.showLong(FeedForCommentActivity.this,"点赞成功！");
        } else {
            viewHolder.ivLikeBtn.setImageResource(R.mipmap.img_like_btn_no);
            viewHolder.tvLikeBtn.setText((commentsBean.getLikes()-1)+"");
            T.showLong(FeedForCommentActivity.this,"取消点赞！");
        }
    }

    @Override
    public void setAddCommentData(String data) {
        T.showShort(FeedForCommentActivity.this, data);
        tvSubmitComment.setVisibility(View.GONE);
        editText.setText("");
        editText.setHint("输入你的评论内容");
    }

    @Override
    public boolean checkInputInfo() {
        if (editText.getText().toString().equals("")) {
            return false;
        }
        return true;

    }
}
