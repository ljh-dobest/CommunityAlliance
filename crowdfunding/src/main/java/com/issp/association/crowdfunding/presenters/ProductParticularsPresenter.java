package com.issp.association.crowdfunding.presenters;


import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.bean.ProductCommentBean;
import com.issp.association.crowdfunding.interfaces.IProductCommentListView;
import com.issp.association.crowdfunding.interfaces.IProductParticularsInfoView;
import com.issp.association.crowdfunding.listeners.OnProductCommentListListener;
import com.issp.association.crowdfunding.listeners.OnProductParticularsListener;
import com.issp.association.crowdfunding.model.ProductCommentModel;
import com.issp.association.crowdfunding.model.ProductParticularsModel;

import java.util.ArrayList;
import java.util.Map;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class ProductParticularsPresenter extends BasePersenter<IProductParticularsInfoView> implements OnProductParticularsListener {
    private ProductParticularsModel recommendInfoMoudle;

    public ProductParticularsPresenter() {
        recommendInfoMoudle = new ProductParticularsModel();
    }

    public void productCommentInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getProductParticularsInfo(formData, this);
    }
    public void postUserPraise(Map<String,String> formData){
        recommendInfoMoudle.postUserPraise(formData,this);
    }
    @Override
    public void getProductParticularsInfo(ProductCollectBean data) {
        mView.setProductParticularsInfoData(data);
    }

    @Override
    public void userPraise(String data) {

    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
