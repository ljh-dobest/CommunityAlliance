package com.issp.inspiration.listeners;


import com.issp.inspiration.bean.DealBuyBean;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface OnReadDealBuyListener {
    void getReadDealBuyInfo(DealBuyBean data);

    void dealBuyPraiseInfo(String data);

    void showError(String errorString);
}
