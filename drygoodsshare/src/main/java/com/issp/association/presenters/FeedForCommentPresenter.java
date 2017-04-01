package com.issp.association.presenters;

import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.bean.ShareCommentBean;
import com.issp.association.interfaces.IFeedForCommentListView;
import com.issp.association.listeners.OnFeedForCommentListListener;
import com.issp.association.model.FeedForCommentModel;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> bxh

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class FeedForCommentPresenter extends BasePersenter<IFeedForCommentListView> implements OnFeedForCommentListListener {
    private FeedForCommentModel recommendInfoMoudle;

    public FeedForCommentPresenter() {
        recommendInfoMoudle = new FeedForCommentModel();
    }

<<<<<<< HEAD
    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getFeedCommentInfo(userId, this);
=======
    public void FeedCommentInfo( Map<String, String> formData ) {
        recommendInfoMoudle.getFeedCommentInfo(formData, this);
    }
    public void addFeedCommentInfo( Map<String, String> formData ) {
        recommendInfoMoudle.addCommentInfo(formData, this);
>>>>>>> bxh
    }

    @Override
    public void getFeedCommentInfo(ArrayList<ShareCommentBean> data) {
        mView.setFeedForCommentListData(data);
    }

    @Override
<<<<<<< HEAD
=======
    public void getAddCommentInfo(String data) {
        mView.setAddCommentData(data);
    }

    @Override
>>>>>>> bxh
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
