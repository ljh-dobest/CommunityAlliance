package com.issp.inspiration.presenters;



import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.bean.CommentsBean;
import com.issp.inspiration.interfaces.ICommentMessageListView;
import com.issp.inspiration.listeners.OnCommentMessageListListener;
import com.issp.inspiration.model.CommentMessageModel;

import java.util.List;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class CommentMessagePresenter extends BasePersenter<ICommentMessageListView> implements OnCommentMessageListListener {
    private CommentMessageModel recommendInfoMoudle;

    public CommentMessagePresenter() {
        recommendInfoMoudle = new CommentMessageModel();
    }

    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getCommentMessageInfo(userId, this);
    }

    @Override
    public void getCommentMessageInfo(List<CommentsBean> data) {
        mView.setCommentMessageListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
