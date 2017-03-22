package com.issp.association.presenters;

import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.bean.ShareBean;
import com.issp.association.bean.ShareCommentBean;
import com.issp.association.interfaces.ICommentMessageListView;
import com.issp.association.interfaces.IShareListView;
import com.issp.association.listeners.OnCommentMessageListListener;
import com.issp.association.listeners.OnShareListener;
import com.issp.association.model.CommentMessageModel;
import com.issp.association.model.ShareInfoModel;

import java.util.ArrayList;

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
    public void getCommentMessageInfo(ArrayList<ShareCommentBean> data) {
        mView.setCommentMessageListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
