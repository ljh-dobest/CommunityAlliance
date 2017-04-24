package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IProductCollectListView;
import com.issp.association.crowdfunding.listeners.OnProductCollectListener;
import com.issp.association.crowdfunding.model.ProductCollectModel;

import java.util.ArrayList;

import java.util.Map;


/**
 *Created by T-BayMax on 2017/3/13.
 */

public class ProductCollectPresenter extends BasePersenter<IProductCollectListView> implements OnProductCollectListener {
    private ProductCollectModel recommendInfoMoudle;

    public ProductCollectPresenter() {
        recommendInfoMoudle = new ProductCollectModel();
    }


    public void ShareInfoPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getProductCollectInfo(formData, this);

    }
    public void selectProductIdCardPresenter(Map<String ,String> formData){
        recommendInfoMoudle.selectProductIdCardView(formData,this);
    }

    public void postUserPraise(Map<String,String> formData){
        recommendInfoMoudle.postUserPraise(formData,this);
    }

    @Override
    public void getProductCollectInfo(ArrayList<ProductCollectBean> data) {
        mView.setProductCollectData(data);
    }

    @Override
    public void selectProductIdCard(String data) {
        mView.selectProductIdCardView(data);
    }

    @Override
    public void userPraise(String data) {

    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
