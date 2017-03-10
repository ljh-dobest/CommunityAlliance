package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.DividerItemDecoration;
import com.example.just.shequnlianmeng.adapter.RecommedInfoRecyclerAdapter;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.bean.RecommendInfoBean;
import com.example.just.shequnlianmeng.interfaces.IWasRecommedList;
import com.example.just.shequnlianmeng.presenters.RecommendInfoPresenter;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendInfoActivity extends BaseMvpActivity<IWasRecommedList,RecommendInfoPresenter> implements IWasRecommedList {
@BindView(R.id.rv_recom_info)
    RecyclerView rv_recom_info;
    private RecommedInfoRecyclerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_info);
        ButterKnife.bind(this);
         initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getRecommedInfo("110");
    }

    private void initView() {
        adapter=new RecommedInfoRecyclerAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        rv_recom_info.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        rv_recom_info.setAdapter(adapter);
        //设置增加或删除条目的动画
        rv_recom_info.setItemAnimator(new DefaultItemAnimator());
        rv_recom_info.addItemDecoration(new DividerItemDecoration(this,OrientationHelper.VERTICAL));
    }

    @Override
    public RecommendInfoPresenter initPresenter() {
        return new RecommendInfoPresenter();
    }

    @Override
    public void setRecommedListData(ArrayList<RecommendInfoBean> data) {
            adapter.setmDatas(data);
    }

    @Override
    public void showLoading() {
        LoadDialog.show(this);
    }

    @Override
    public void hideLoading() {
        LoadDialog.dismiss(this);
    }

    @Override
    public void showError(String errorString) {
        T.showShort(this,errorString);
    }
}
