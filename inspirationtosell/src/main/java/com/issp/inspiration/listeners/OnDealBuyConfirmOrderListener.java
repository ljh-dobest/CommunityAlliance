package com.issp.inspiration.listeners;


/**
 *Created by T-BayMax on 2017/3/20.
 */

public interface OnDealBuyConfirmOrderListener {
    void getConfirmOrderInfo(String data);
    void showError(String errorString);
}
