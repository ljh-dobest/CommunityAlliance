package com.issp.association.presenters;



import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.bean.CommentsBean;
import com.issp.association.interfaces.IFeedForCommentListView;
import com.issp.association.listeners.OnFeedForCommentListListener;
import com.issp.association.model.FeedForCommentModel;

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
