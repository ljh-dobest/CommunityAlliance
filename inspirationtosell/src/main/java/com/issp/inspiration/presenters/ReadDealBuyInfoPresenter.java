package com.issp.inspiration.presenters;


import com.issp.inspiration.base.presenter.BasePersenter;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.interfaces.IDealBuyListView;
import com.issp.inspiration.interfaces.IReadDealBuyView;
import com.issp.inspiration.listeners.OnReadDealBuyListener;
import com.issp.inspiration.model.ReadDealBuyInfoModel;

import java.util.Map;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public class ReadDealBuyInfoPresenter extends BasePersenter<IReadDealBuyView> implements OnReadDealBuyListener {
    private ReadDealBuyInfoModel recommendInfoMoudle;

    public ReadDealBuyInfoPresenter() {
        recommendInfoMoudle = new ReadDealBuyInfoModel();
    }

    public void ReadShareInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getReadShareInfo(formData, this);
    }

    public void sharePraiseInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getSharePraiseInfo(formData, this);
    }

    @Override
    public void getReadDealBuyInfo(DealBuyBean data) {
        mView.setDealBuyData(data);
    }

    @Override
    public void dealBuyPraiseInfo(String data) {
        mView.dealBuyPraise(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
