package com.issp.association.crowdfunding.presenters;


import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.interfaces.IAddShippingAddressListView;
import com.issp.association.crowdfunding.listeners.OnAddShippingAddressListListener;
import com.issp.association.crowdfunding.model.AddShippingAddressModel;

import java.util.Map;


/**
 * 添加收货地址
 *Created by T-BayMax on 2017/3/25.
 */

public class AddShippingAddressPresenter extends BasePersenter<IAddShippingAddressListView> implements OnAddShippingAddressListListener {
    private AddShippingAddressModel recommendInfoMoudle;

    public AddShippingAddressPresenter() {
        recommendInfoMoudle = new AddShippingAddressModel();
    }

    public void OrderDetailPresenter(Map<String,String> fromData) {
        recommendInfoMoudle.getShippingAddressInfo(fromData, this);
    }

    @Override
    public void getShippingAddressInfo(String data) {
        mView.setShippingAddressData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
