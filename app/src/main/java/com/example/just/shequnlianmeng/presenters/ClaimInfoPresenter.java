package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.bean.ClaimInfoBean;
import com.example.just.shequnlianmeng.interfaces.IClaimInfoView;
import com.example.just.shequnlianmeng.listeners.OnClaimFinishListener;
import com.example.just.shequnlianmeng.moudle.ClaimInfoMoudle;

/**
 * Created by Min on 2017/3/10.
 */

public class ClaimInfoPresenter extends BasePersenter<IClaimInfoView> implements OnClaimFinishListener {
    private  ClaimInfoMoudle claimInfoMoudle;
    public ClaimInfoPresenter(){
        claimInfoMoudle=new ClaimInfoMoudle();
    }
     public void postClaimPeopleInfo(ClaimInfoBean claimInfo ){
            claimInfoMoudle.postClaimInfo(claimInfo,this);
     }

    @Override
    public void showTextEmpty() {

    }

    @Override
    public void succeedToClaim() {

    }

    @Override
    public void failedToClaim(String string) {

    }
}
