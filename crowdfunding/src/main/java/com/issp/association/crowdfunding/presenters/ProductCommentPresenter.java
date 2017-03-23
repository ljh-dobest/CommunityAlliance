package com.issp.association.crowdfunding.presenters;


import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCommentBean;
import com.issp.association.crowdfunding.interfaces.IProductCommentListView;
import com.issp.association.crowdfunding.listeners.OnProductCommentListListener;
import com.issp.association.crowdfunding.model.ProductCommentModel;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class ProductCommentPresenter extends BasePersenter<IProductCommentListView> implements OnProductCommentListListener {
    private ProductCommentModel recommendInfoMoudle;

    public ProductCommentPresenter() {
        recommendInfoMoudle = new ProductCommentModel();
    }

    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getProductCommentInfo(userId, this);
    }

    @Override
    public void getProductCommentInfo(ArrayList<ProductCommentBean> data) {
        mView.setProductCommentListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
