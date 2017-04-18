package com.ike.coalition.platform.presenters;

import com.ike.coalition.platform.base.presenter.BasePersenter;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.interfaces.IPlatformListView;
import com.ike.coalition.platform.interfaces.IPlatformParticularsView;
import com.ike.coalition.platform.listeners.OnPlatformListener;
import com.ike.coalition.platform.listeners.OnPlatformParticularsListener;
import com.ike.coalition.platform.model.PlatformModel;
import com.ike.coalition.platform.model.PlatformParticularsModel;

import java.util.List;
import java.util.Map;


/**
 *Created by T-BayMax on 2017/3/13.
 */

public class PlatformParticularsPresenter extends BasePersenter<IPlatformParticularsView> implements OnPlatformParticularsListener {
    private PlatformParticularsModel recommendInfoMoudle;

    public PlatformParticularsPresenter() {
        recommendInfoMoudle = new PlatformParticularsModel();
    }


    public void ParticularsPresenter(Map<String ,String> formData) {
        recommendInfoMoudle.getProductCollectInfo(formData, this);

    }
    public void platformActivesJoin(Map<String,String> formData){
        recommendInfoMoudle.platformActivesJoin(formData,this);
    }

    public void addUserPraise(Map<String,String> formData){
        recommendInfoMoudle.userPraise(formData,this);
    }


    @Override
    public void getPlatformParticulars(PlatformBean data) {
        mView.setPlatformParticularsData(data);
    }

    @Override
    public void platformActivesJoinSucceed(String data) {
        mView.platformActivesJoinSucceed(data);
    }

    @Override
    public void userPraise(String data) {
        mView.userPraise(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
