package com.issp.inspiration.presenters;


import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.bean.CommentsBean;
import com.issp.inspiration.bean.DealBuyCommentBean;
import com.issp.inspiration.interfaces.IDealBuyCommentListView;
import com.issp.inspiration.listeners.OnDealBuyCommentListListener;
import com.issp.inspiration.model.DealBuyCommentModel;

import java.util.List;
import java.util.Map;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class DealBuyCommentPresenter extends BasePersenter<IDealBuyCommentListView> implements OnDealBuyCommentListListener {
    private DealBuyCommentModel recommendInfoMoudle;

    public DealBuyCommentPresenter() {
        recommendInfoMoudle = new DealBuyCommentModel();
    }

    public void DealBuyCommentInfo( Map<String, String> formData ) {
        recommendInfoMoudle.getDealBuyCommentInfo(formData, this);
    }
    public void addDealBuyCommentInfo( Map<String, String> formData ) {
        recommendInfoMoudle.addCommentInfo(formData, this);
    }
    @Override
    public void getDealBuyCommentInfo(List<CommentsBean> data) {
        mView.setDealBuyCommentListData(data);
    }

    @Override
    public void getAddCommentInfo(String data) {
        mView.setAddCommentData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
