package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IMinProductListView;
import com.issp.association.crowdfunding.interfaces.IProductCollectListView;
import com.issp.association.crowdfunding.listeners.OnMinProductListener;
import com.issp.association.crowdfunding.listeners.OnProductCollectListener;
import com.issp.association.crowdfunding.model.MinProductModel;
import com.issp.association.crowdfunding.model.ProductCollectModel;

import java.util.List;
import java.util.Map;


/**
 *Created by T-BayMax on 2017/3/13.
 */

public class MinProductPresenter extends BasePersenter<IMinProductListView> implements OnMinProductListener {
    private MinProductModel recommendInfoMoudle;

    public MinProductPresenter() {
        recommendInfoMoudle = new MinProductModel();
    }


    public void ShareInfoPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getMinProductInfo(formData, this);

    }

    @Override
    public void getMinProductInfo(List<ProductCollectBean> data) {
        mView.setMinProductListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
