package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCollect;
import com.issp.association.crowdfunding.interfaces.IProductCollectListView;
import com.issp.association.crowdfunding.listeners.OnProductCollectListener;
import com.issp.association.crowdfunding.model.ProductCollectModel;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class ProductCollectPresenter extends BasePersenter<IProductCollectListView> implements OnProductCollectListener {
    private ProductCollectModel recommendInfoMoudle;

    public ProductCollectPresenter() {
        recommendInfoMoudle = new ProductCollectModel();
    }

    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getProductCollectInfo(userId, this);
    }

    @Override
    public void getProductCollectInfo(ArrayList<ProductCollect> data) {
        mView.setProductCollectData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
