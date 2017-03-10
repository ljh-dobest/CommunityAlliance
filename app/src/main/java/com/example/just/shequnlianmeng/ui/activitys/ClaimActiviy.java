package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.ClaimCenterRecyclerAdapter;
import com.example.just.shequnlianmeng.adapter.DividerItemDecoration;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.bean.ClaimPeopleBean;
import com.example.just.shequnlianmeng.interfaces.IClaimCenterView;
import com.example.just.shequnlianmeng.presenters.ClaimPresenter;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClaimActiviy extends BaseMvpActivity<IClaimCenterView,ClaimPresenter> implements IClaimCenterView {
@BindView(R.id.rv_calim)
    RecyclerView rv_calim;
    @BindView(R.id.iv_claim_back)
    ImageView iv_claim_back;
    private ClaimCenterRecyclerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.claim_activiy);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        presenter.getClaimPeopleData("110");
    }

    private void initView() {
        adapter=new ClaimCenterRecyclerAdapter(this);
        //设置布局管理器
        rv_calim.setLayoutManager(new GridLayoutManager(this,3));
        //设置Adapter
        rv_calim.setAdapter(adapter);
        //设置增加或删除条目的动画
        rv_calim.setItemAnimator(new DefaultItemAnimator());
        rv_calim.addItemDecoration(new DividerItemDecoration(this,OrientationHelper.HORIZONTAL));
    }

   @OnClick(R.id.iv_claim_back)
    public void claimViewOnCliick(View view){
       switch (view.getId()) {
           case R.id.iv_claim_back:
               finish();
               break;
       }

   }


    @Override
    public ClaimPresenter initPresenter() {
        return new ClaimPresenter();
    }

    @Override
    public void setPeoplesData(ArrayList<ClaimPeopleBean> data) {
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
