package com.issp.inspiration.presenters;


import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.interfaces.IMinDealBuyListView;
import com.issp.inspiration.listeners.OnMinDealBuyListener;
import com.issp.inspiration.model.MinDealBuyInfoModel;

import java.util.List;
import java.util.Map;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class MinDealBuyInfoPresenter extends BasePersenter<IMinDealBuyListView> implements OnMinDealBuyListener {
    private MinDealBuyInfoModel recommendInfoMoudle;

    public MinDealBuyInfoPresenter() {
        recommendInfoMoudle = new MinDealBuyInfoModel();
    }

    public void MinShareInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getMinDealBuyInfo(formData, this);
    }
    public void sharePraiseInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getDealBuyPraiseInfo(formData, this);
    }

    @Override
    public void getMinDealBuyInfo(List<DealBuyBean> data) {
        mView.setMinDealBuyListData(data);
    }

    @Override
    public void dealBuyPraiseInfo(String data) {
        mView.sharePraise(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
