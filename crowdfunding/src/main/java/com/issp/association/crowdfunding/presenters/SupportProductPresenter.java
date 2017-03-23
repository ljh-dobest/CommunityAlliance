package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.ISupportProductListView;
import com.issp.association.crowdfunding.listeners.OnSupportProductListener;
import com.issp.association.crowdfunding.model.SupportProductModel;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class SupportProductPresenter extends BasePersenter<ISupportProductListView> implements OnSupportProductListener {
    private SupportProductModel recommendInfoMoudle;

    public SupportProductPresenter() {
        recommendInfoMoudle = new SupportProductModel();
    }

    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getSupportProductInfo(userId, this);
    }

    @Override
    public void getProductCollectInfo(ArrayList<ProductCollectBean> data) {
        mView.setSupportProductData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
