package com.issp.inspiration.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.issp.inspiration.R;
import com.issp.inspiration.base.view.BaseMvpActivity;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.interfaces.IDealBuyConfirmOrderView;
import com.issp.inspiration.network.HttpUtils;
import com.issp.inspiration.presenters.DealBuyConfirmOrderPresenter;
import com.issp.inspiration.utils.T;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 确认订单
 * Created by T-BayMax on 2017/3/31.
 */

public class DealBuyConfirmOrderActivity extends BaseMvpActivity<IDealBuyConfirmOrderView, DealBuyConfirmOrderPresenter> implements IDealBuyConfirmOrderView {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.iv_deal_buy_icon)
    ImageView ivDealBuyIcon;
    @BindView(R.id.tv_deal_buy_title)
    TextView tvDealBuyTitle;
    @BindView(R.id.iv_deal_Contribution)
    ImageView ivDealContribution;
    @BindView(R.id.tv_deal_Contribution)
    TextView tvDealContribution;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.tv_deal_Contribution_total)
    TextView tvDealContributionTotal;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.tv_buy_button)
    TextView tvBuyButton;

    DealBuyBean bean;

    private static final int REQUEST_CODE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_buy_confirm_order);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ltMainTitleLeft.setText("返回");
        ltMainTitle.setText("确认订单");
        Intent intent = getIntent();
        bean = (DealBuyBean) intent.getSerializableExtra("bean");
        if (null != bean) {
            if (null != bean.getUserPortraitUrl())
                Picasso.with(DealBuyConfirmOrderActivity.this).load(HttpUtils.IMAGE_RUL + bean.getUserPortraitUrl())
                        .into(ivDealBuyIcon);
            tvDealBuyTitle.setText(bean.getTitle());
            tvDealContribution.setText("贡献币" + bean.getDealContribution());
            tvDealContributionTotal.setText("贡献币" + bean.getDealContribution());
        }
    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        DealBuyConfirmOrderActivity.this.finish();
    }

    @OnClick(R.id.tv_buy_button)
    void buyClick() {
        if (checkInputInfo()) {
            Map<String, String> formData = new HashMap<String, String>(0);
            formData.put("userId", bean.getUserId());
            formData.put("articleId", bean.getId());
            presenter.addDealBuyCommentInfo(formData);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {
        T.showShort(DealBuyConfirmOrderActivity.this, errorString);
    }

    @Override
    public void setConfirmOrderData(String data) {
        Intent intent = new Intent();
        setResult(REQUEST_CODE, intent);
        T.showShort(DealBuyConfirmOrderActivity.this, data);
        DealBuyConfirmOrderActivity.this.finish();

    }

    @Override
    public boolean checkInputInfo() {
        if (null != bean.getId())
            return true;
        else
            return false;
    }

    @Override
    public DealBuyConfirmOrderPresenter initPresenter() {
        return new DealBuyConfirmOrderPresenter();
    }
}
