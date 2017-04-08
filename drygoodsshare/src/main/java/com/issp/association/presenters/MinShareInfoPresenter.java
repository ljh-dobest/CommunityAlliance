package com.issp.association.presenters;

import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.bean.ShareBean;
import com.issp.association.interfaces.IMinShareListView;
import com.issp.association.interfaces.IShareListView;
import com.issp.association.listeners.OnMinShareListener;
import com.issp.association.listeners.OnShareListener;
import com.issp.association.model.MinShareInfoModel;
import com.issp.association.model.ShareInfoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class MinShareInfoPresenter extends BasePersenter<IMinShareListView> implements OnMinShareListener {
    private MinShareInfoModel recommendInfoMoudle;

    public MinShareInfoPresenter() {
        recommendInfoMoudle = new MinShareInfoModel();
    }

    public void MinShareInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getMinShareInfo(formData, this);
    }
    public void sharePraiseInfoPresenter(Map<String, String> formData) {
        recommendInfoMoudle.getSharePraiseInfo(formData, this);
    }

    @Override
    public void getMinShareInfo(List<ShareBean> data) {
        mView.setMinShareListData(data);
    }

    @Override
    public void sharePraiseInfo(String data) {
        mView.sharePraise(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
