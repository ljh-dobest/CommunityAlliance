package com.issp.inspiration.listeners;



import com.issp.inspiration.bean.DealBuyBean;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.

 */

public interface OnMinDealBuyListener {
    void getMinDealBuyInfo(List<DealBuyBean> data);

    void dealBuyPraiseInfo(String data);

    void showError(String errorString);
}
