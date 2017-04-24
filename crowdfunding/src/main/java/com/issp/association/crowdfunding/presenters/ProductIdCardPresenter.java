package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.interfaces.IAddCrowdFundingView;
import com.issp.association.crowdfunding.interfaces.IProductIDCardView;
import com.issp.association.crowdfunding.listeners.OnAddProductCollectListener;
import com.issp.association.crowdfunding.listeners.OnProductIDCardListener;
import com.issp.association.crowdfunding.model.AddProductCollectModel;
import com.issp.association.crowdfunding.model.ProductIDCardModel;

import java.util.Map;

/**
 * Created by T-BayMax on 2017/4/21.
 */

public class ProductIdCardPresenter extends BasePersenter<IProductIDCardView> implements OnProductIDCardListener {
    private ProductIDCardModel model;

    public ProductIdCardPresenter() {
        model = new ProductIDCardModel();
    }
    public void addProductIdCard(Map<String,String> formData){
        model.productIDCard(formData,this);
    }
    public void checkIdCardPresenter(String formData){
        model.checkIdCard(formData,this);
    }

    @Override
    public void productIDCard(String data) {
        mView.productIDcardView(data);
    }

    @Override
    public void checkIdCard(String data) {
        mView.checkIdCardView(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
