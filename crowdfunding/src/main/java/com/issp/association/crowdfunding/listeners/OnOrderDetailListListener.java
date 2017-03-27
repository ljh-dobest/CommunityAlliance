package com.issp.association.crowdfunding.listeners;


import com.issp.association.crowdfunding.bean.OrderDetailBean;

import java.util.ArrayList;

/**
 * 订单详情
 * Created by T-BayMax on 2017/3/20.
 */

public interface OnOrderDetailListListener {
    void getOnOrderDetailInfo(ArrayList<OrderDetailBean> data);

    void showError(String errorString);
}
