package com.issp.association.crowdfunding.presenters;


import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.MessageBean;
import com.issp.association.crowdfunding.interfaces.IMessageListView;
import com.issp.association.crowdfunding.listeners.OnMessageListListener;
import com.issp.association.crowdfunding.model.MessageModel;

import java.util.ArrayList;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class MessagePresenter extends BasePersenter<IMessageListView> implements OnMessageListListener {
    private MessageModel recommendInfoMoudle;

    public MessagePresenter() {
        recommendInfoMoudle = new MessageModel();
    }

    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getCommentMessageInfo(userId, this);
    }

    @Override
    public void getCommentMessageInfo(ArrayList<MessageBean> data) {
        mView.setCommentMessageListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
