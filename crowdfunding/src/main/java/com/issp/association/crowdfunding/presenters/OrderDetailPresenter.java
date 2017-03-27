package com.issp.association.crowdfunding.presenters;


import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.MessageBean;
import com.issp.association.crowdfunding.bean.OrderDetailBean;
import com.issp.association.crowdfunding.interfaces.IMessageListView;
import com.issp.association.crowdfunding.interfaces.IOrderDetailListView;
import com.issp.association.crowdfunding.listeners.OnMessageListListener;
import com.issp.association.crowdfunding.listeners.OnOrderDetailListListener;
import com.issp.association.crowdfunding.model.MessageModel;
import com.issp.association.crowdfunding.model.OrderDetailModel;

import java.util.ArrayList;

/**
 * 订单详情
 *Created by T-BayMax on 2017/3/25.
 */

public class OrderDetailPresenter extends BasePersenter<IOrderDetailListView> implements OnOrderDetailListListener {
    private OrderDetailModel recommendInfoMoudle;

    public OrderDetailPresenter() {
        recommendInfoMoudle = new OrderDetailModel();
    }

    public void OrderDetailPresenter(String userId) {
        recommendInfoMoudle.getOrderDetailInfo(userId, this);
    }

    @Override
    public void getOnOrderDetailInfo(ArrayList<OrderDetailBean> data) {
        mView.setOrderDetailListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
