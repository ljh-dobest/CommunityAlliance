package com.ike.coalition.platform.presenters;

import com.ike.coalition.platform.base.presenter.BasePersenter;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.bean.UserBean;
import com.ike.coalition.platform.interfaces.IPlatformListView;
import com.ike.coalition.platform.interfaces.IPlatformRegisteredListView;
import com.ike.coalition.platform.listeners.OnPlatformListener;
import com.ike.coalition.platform.listeners.OnPlatformRegisteredListener;
import com.ike.coalition.platform.model.PlatformModel;
import com.ike.coalition.platform.model.PlatformRegisteredModel;

import java.util.List;
import java.util.Map;


/**
 *Created by T-BayMax on 2017/3/13.
 */

public class PlatformRegisteredPresenter extends BasePersenter<IPlatformRegisteredListView> implements OnPlatformRegisteredListener {
    private PlatformRegisteredModel recommendInfoMoudle;

    public PlatformRegisteredPresenter() {
        recommendInfoMoudle = new PlatformRegisteredModel();
    }


    public void PlatformRegisteredPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getPlatformRegisteredInfo(formData, this);

    }


    @Override
    public void getPlatformRegisteredList(List<UserBean> data) {
        mView.setPlatformRegisteredListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
