package com.issp.association.crowdfunding.presenters;

import com.issp.association.crowdfunding.base.presenter.BasePersenter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.interfaces.IAddSupportProjectView;
import com.issp.association.crowdfunding.listeners.OnAddSupportProjectListener;
import com.issp.association.crowdfunding.model.AddSupportProjectModel;

import java.util.ArrayList;
import java.util.Map;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class AddSupportProjectPresenter extends BasePersenter<IAddSupportProjectView> implements OnAddSupportProjectListener {
    private AddSupportProjectModel recommendInfoMoudle;

    public AddSupportProjectPresenter() {
        recommendInfoMoudle = new AddSupportProjectModel();
    }

    public void ShareInfoPresenter(Map<String,String> fromData) {
        recommendInfoMoudle.getAddSupportProductInfo(fromData, this);
    }

    @Override
    public void getAddSupportProjectInfo(String data) {
        mView.setAddSupportProjectData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
