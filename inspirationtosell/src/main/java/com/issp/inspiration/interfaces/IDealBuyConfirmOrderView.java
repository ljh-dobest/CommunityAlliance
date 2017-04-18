package com.issp.inspiration.interfaces;




import com.issp.inspiration.base.view.BaseView;

/**
 * 产品众筹评论
 *Created by T-BayMax on 2017/3/20.
 */

public interface IDealBuyConfirmOrderView extends BaseView {
    void setConfirmOrderData(String data);
    boolean checkInputInfo();
}
