package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.interfaces.IAddCrowdFunding;
import com.issp.association.crowdfunding.listeners.OnAddProductCollectListener;
import com.issp.association.crowdfunding.model.AddProductCollectModel;

import java.util.Map;

/**
 * Created by T-BayMax on 2017/4/21.
 */

public class AddProductCollectPresenter extends BasePersenter<IAddCrowdFunding> implements OnAddProductCollectListener {
    private AddProductCollectModel model;

    public AddProductCollectPresenter() {
        model = new AddProductCollectModel();
    }
    public void addProductCollect(Map<String,String> formData){
        model.productCollect(formData,this);
    }

    @Override
    public void productCollect(String data) {
        mView.productCollectView(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
