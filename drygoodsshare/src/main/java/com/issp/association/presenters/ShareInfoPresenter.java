package com.issp.association.presenters;

import com.issp.association.base.presenter.BasePersenter;
import com.issp.association.bean.ShareBean;
import com.issp.association.interfaces.IShareList;
import com.issp.association.listeners.OnShareListener;
import com.issp.association.model.ShareInfoModel;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public class ShareInfoPresenter extends BasePersenter<IShareList> implements OnShareListener {
    private ShareInfoModel recommendInfoMoudle;

    public ShareInfoPresenter() {
        recommendInfoMoudle = new ShareInfoModel();
    }

    public void ShareInfoPresenter(String userId) {
        recommendInfoMoudle.getShareInfo(userId, this);
    }

    @Override
    public void getShareInfo(ArrayList<ShareBean> data) {
        mView.setShareListData(data);
    }

    @Override
    public void showError(String errorString) {
        mView.showError(errorString);
    }
}
