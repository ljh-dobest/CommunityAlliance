package com.ike.coalition.platform.presenters;


import com.ike.coalition.platform.base.presenter.BasePersenter;
import com.ike.coalition.platform.bean.CommentsBean;
import com.ike.coalition.platform.interfaces.IFeedForCommentListView;
import com.ike.coalition.platform.listeners.OnFeedForCommentListListener;
import com.ike.coalition.platform.model.FeedForCommentModel;

import java.util.List;
import java.util.Map;


/**
 *Created by T-BayMax on 2017/3/20.
 */

public class FeedForCommentPresenter extends BasePersenter<IFeedForCommentListView> implements OnFeedForCommentListListener {
    private FeedForCommentModel recommendInfoMoudle;

    public FeedForCommentPresenter() {
        recommendInfoMoudle = new FeedForCommentModel();
    }

    public void FeedCommentInfo( Map<String, String> formData ) {
        recommendInfoMoudle.getFeedCommentInfo(formData, this);
    }
    public void addFeedCommentInfo( Map<String, String> formData ) {
        recommendInfoMoudle.addCommentInfo(formData, this);

    }
    public void addCommentLikes( Map<String, String> formData){
        recommendInfoMoudle.commentLikes(formData,this);
    }


    @Override
    public void getFeedCommentInfo(List<CommentsBean> data) {
        mView.setFeedForCommentListData(data);
    }

    @Override

    public void getAddCommentInfo(String data) {
        mView.setAddCommentData(data);
    }

    @Override
    public void commentLikes(String data) {
        mView.commentLikes(data);
    }

    @Override

    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
