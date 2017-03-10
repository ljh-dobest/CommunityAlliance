package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.interfaces.IClaimInfoView;
import com.example.just.shequnlianmeng.presenters.ClaimInfoPresenter;

public class ClaimInfoActivity extends BaseMvpActivity<IClaimInfoView,ClaimInfoPresenter> implements IClaimInfoView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_info);
    }

    @Override
    public ClaimInfoPresenter initPresenter() {
        return new ClaimInfoPresenter();
    }

    @Override
    public void showSucceedClaim() {

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
}
