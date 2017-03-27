package com.issp.association.crowdfunding.presenters;


import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.OrderDetailBean;
import com.issp.association.crowdfunding.interfaces.IOrderDetailListView;
import com.issp.association.crowdfunding.interfaces.IShippingAddressListView;
import com.issp.association.crowdfunding.listeners.OnOrderDetailListListener;
import com.issp.association.crowdfunding.listeners.OnShippingAddressListListener;
import com.issp.association.crowdfunding.model.OrderDetailModel;
import com.issp.association.crowdfunding.model.ShippingAddressModel;

import java.util.ArrayList;

/**
 * 收货地址管理
 *Created by T-BayMax on 2017/3/25.
 */

public class ShippingAddressPresenter extends BasePersenter<IShippingAddressListView> implements OnShippingAddressListListener {
    private ShippingAddressModel recommendInfoMoudle;

    public ShippingAddressPresenter() {
        recommendInfoMoudle = new ShippingAddressModel();
    }

    public void OrderDetailPresenter(String userId) {
        recommendInfoMoudle.getShippingAddressInfo(userId, this);
    }

    @Override
    public void getShippingAddressInfo(ArrayList<OrderDetailBean> data) {
        mView.setShippingAddressListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
