package com.ike.coalition.platform.presenters;

import com.ike.coalition.platform.base.presenter.BasePersenter;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.interfaces.IPlatformListView;
import com.ike.coalition.platform.listeners.OnPlatformListener;
import com.ike.coalition.platform.model.PlatformModel;

import java.util.List;
import java.util.Map;


/**
 *Created by T-BayMax on 2017/3/13.
 */

public class PlatformPresenter extends BasePersenter<IPlatformListView> implements OnPlatformListener {
    private PlatformModel recommendInfoMoudle;

    public PlatformPresenter() {
        recommendInfoMoudle = new PlatformModel();
    }


    public void ShareInfoPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getProductCollectInfo(formData, this);

    }


    @Override
    public void getPlatformList(List<PlatformBean> data) {
        mView.setPlatformListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
