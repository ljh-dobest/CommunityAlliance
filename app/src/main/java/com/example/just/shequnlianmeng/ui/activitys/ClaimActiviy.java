package com.example.just.shequnlianmeng.ui.activitys;

import android.content.Intent;
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
import com.example.just.shequnlianmeng.presenters.ClaimCenterPresenter;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClaimActiviy extends BaseMvpActivity<IClaimCenterView,ClaimCenterPresenter> implements IClaimCenterView, ClaimCenterRecyclerAdapter.OnItemClickLitener {
@BindView(R.id.rv_calim)
    RecyclerView rv_calim;
    @BindView(R.id.iv_claim_back)
    ImageView iv_claim_back;
    @BindView(R.id.iv_claim_more)
    ImageView iv_claim_more;
    private ClaimCenterRecyclerAdapter adapter;
    private ArrayList<ClaimPeopleBean> data;
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
        adapter.setOnItemClickLitener(this);
    }

   @OnClick(value = {R.id.iv_claim_back,R.id.iv_claim_more})
    public void claimViewOnCliick(View view){
       switch (view.getId()) {
           case R.id.iv_claim_back:
               finish();
               break;
           case R.id.iv_claim_more:
               ClaimPopupWindow chatPopupWindow =new ClaimPopupWindow(this);
               chatPopupWindow.showPopupWindow(iv_claim_more);
               break;
       }

   }


    @Override
    public ClaimCenterPresenter initPresenter() {
        return new ClaimCenterPresenter();
    }

    @Override
    public void setPeoplesData(ArrayList<ClaimPeopleBean> data) {
     this.data=data;
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

    @Override
    public void onItemClick(View view, int position) {
        Intent intent=new Intent(this,ClaimInfoActivity.class);
        String claimUserId=data.get(position).getRecommendId();
        intent.putExtra("claimUserId",claimUserId);
        startActivity(intent);
    }
}
