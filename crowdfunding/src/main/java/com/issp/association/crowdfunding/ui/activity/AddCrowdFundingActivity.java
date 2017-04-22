package com.issp.association.crowdfunding.ui.activity;


import android.os.Bundle;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.base.view.BaseMvpActivity;
import com.issp.association.crowdfunding.interfaces.IAddCrowdFunding;
import com.issp.association.crowdfunding.presenters.AddProductCollectPresenter;

/**
 * 添加众筹
 * Created by T-BayMax on 2017/4/21.
 */

public class AddCrowdFundingActivity extends BaseMvpActivity<IAddCrowdFunding, AddProductCollectPresenter> implements IAddCrowdFunding {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crowd_funding);
    }

    @Override
    public AddProductCollectPresenter initPresenter() {
        return new AddProductCollectPresenter();
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
    public void productCollectView(String data) {

    }
}
