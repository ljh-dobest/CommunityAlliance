package com.issp.association.presenters;

import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.bean.ShareCommentBean;
import com.issp.association.interfaces.IFeedForCommentListView;
import com.issp.association.listeners.OnFeedForCommentListListener;
import com.issp.association.model.FeedForCommentModel;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class FeedForCommentPresenter extends BasePersenter<IFeedForCommentListView> implements OnFeedForCommentListListener {
    private FeedForCommentModel recommendInfoMoudle;

    public FeedForCommentPresenter() {
        recommendInfoMoudle = new FeedForCommentModel();
    }

    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getFeedCommentInfo(userId, this);
    }

    @Override
    public void getFeedCommentInfo(ArrayList<ShareCommentBean> data) {
        mView.setFeedForCommentListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
