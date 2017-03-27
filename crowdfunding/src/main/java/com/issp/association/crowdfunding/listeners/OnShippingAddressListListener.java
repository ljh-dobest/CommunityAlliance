package com.issp.association.crowdfunding.listeners;


import com.issp.association.crowdfunding.bean.OrderDetailBean;

import java.util.ArrayList;

/**
 * 收货地址管理
 * Created by T-BayMax on 2017/3/25.
 */

public interface OnShippingAddressListListener {
    void getShippingAddressInfo(ArrayList<OrderDetailBean> data);

    void showError(String errorString);
}
