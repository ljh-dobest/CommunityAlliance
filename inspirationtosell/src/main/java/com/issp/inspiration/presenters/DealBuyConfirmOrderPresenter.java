package com.issp.inspiration.presenters;


import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.interfaces.IDealBuyConfirmOrderView;
import com.issp.inspiration.listeners.OnDealBuyConfirmOrderListener;
import com.issp.inspiration.model.DealBuyConfirmOrderModel;

import java.util.Map;

/**
 *Created by T-BayMax on 2017/3/20.
 */

public class DealBuyConfirmOrderPresenter extends BasePersenter<IDealBuyConfirmOrderView> implements OnDealBuyConfirmOrderListener {
    private DealBuyConfirmOrderModel recommendInfoMoudle;

    public DealBuyConfirmOrderPresenter() {
        recommendInfoMoudle = new DealBuyConfirmOrderModel();
    }


    public void addDealBuyCommentInfo( Map<String, String> formData ) {
        recommendInfoMoudle.addConfirmOrderInfo(formData, this);
    }

    @Override
    public void getConfirmOrderInfo(String data) {
        mView.setConfirmOrderData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
