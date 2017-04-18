package com.ike.coalition.platform.presenters;

import com.ike.coalition.platform.base.presenter.BasePersenter;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.interfaces.IMinPlatformListView;
import com.ike.coalition.platform.interfaces.IPlatformListView;
import com.ike.coalition.platform.listeners.OnMinPlatformListener;
import com.ike.coalition.platform.listeners.OnPlatformListener;
import com.ike.coalition.platform.model.MinPlatformModel;
import com.ike.coalition.platform.model.PlatformModel;

import java.util.List;
import java.util.Map;


/**
 *Created by T-BayMax on 2017/3/13.
 */

public class MinPlatformPresenter extends BasePersenter<IMinPlatformListView> implements OnMinPlatformListener {
    private MinPlatformModel recommendInfoMoudle;

    public MinPlatformPresenter() {
        recommendInfoMoudle = new MinPlatformModel();
    }


    public void platformInfoPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getProductCollectInfo(formData, this);

    }


    @Override
    public void getMinPlatformBeanList(List<PlatformBean> data) {
        mView.setMinPlatformListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
