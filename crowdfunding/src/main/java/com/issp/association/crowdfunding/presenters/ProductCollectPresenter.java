package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IProductCollectListView;
import com.issp.association.crowdfunding.listeners.OnProductCollectListener;
import com.issp.association.crowdfunding.model.ProductCollectModel;

import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> bxh
=======
import java.util.Map;
>>>>>>> bxh

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class ProductCollectPresenter extends BasePersenter<IProductCollectListView> implements OnProductCollectListener {
    private ProductCollectModel recommendInfoMoudle;

    public ProductCollectPresenter() {
        recommendInfoMoudle = new ProductCollectModel();
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getProductCollectInfo(userId, this);
=======
    public void ShareInfoPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getProductCollectInfo(formData, this);
>>>>>>> bxh
=======
    public void ShareInfoPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getProductCollectInfo(formData, this);
>>>>>>> bxh
    }

    @Override
    public void getProductCollectInfo(ArrayList<ProductCollectBean> data) {
        mView.setProductCollectData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
