package com.issp.association.crowdfunding.presenters;


import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.CommentsBean;
import com.issp.association.crowdfunding.interfaces.IProductCommentListView;
import com.issp.association.crowdfunding.listeners.OnProductCommentListListener;
import com.issp.association.crowdfunding.model.ProductCommentModel;

import java.util.List;
import java.util.Map;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class ProductCommentPresenter extends BasePersenter<IProductCommentListView> implements OnProductCommentListListener {
    private ProductCommentModel recommendInfoMoudle;

    public ProductCommentPresenter() {
        recommendInfoMoudle = new ProductCommentModel();
    }

    public void productCommentInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getProductCommentInfo(formData, this);
    }

    @Override
    public void getProductCommentInfo(List<CommentsBean> data) {
        mView.setProductCommentListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
