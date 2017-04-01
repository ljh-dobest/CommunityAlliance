package com.issp.inspiration.interfaces;


import com.issp.inspiration.base.view.BaseView;
import com.issp.inspiration.bean.DealBuyBean;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface IReadDealBuyView extends BaseView {
    void setDealBuyData(DealBuyBean data);

    void dealBuyPraise(String data);
}
