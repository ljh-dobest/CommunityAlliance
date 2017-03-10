package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.bean.ClaimPeopleBean;
import com.example.just.shequnlianmeng.interfaces.IClaimCenterView;
import com.example.just.shequnlianmeng.listeners.OnClaimPeopleFinishListener;
import com.example.just.shequnlianmeng.moudle.ClaimCenterMoudle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min on 2017/3/10.
 */

public class ClaimPresenter extends BasePersenter<IClaimCenterView> implements OnClaimPeopleFinishListener {
    private ClaimCenterMoudle claimCenterMoudle;
    public ClaimPresenter(){
          claimCenterMoudle=new ClaimCenterMoudle();
    }
     public void getClaimPeopleData(String userId){
         claimCenterMoudle.getClaimPeopleData(userId,this);
     }

    @Override
    public void succeedToGetClaimPeople(List<ClaimPeopleBean> peoples) {
              mView.setPeoplesData((ArrayList<ClaimPeopleBean>) peoples);
    }

    @Override
    public void failedToGetClaimPeople(String string) {
          mView.showError(string);
    }

    @Override
    public void showErrorString(String errorString) {
     mView.showError(errorString);
    }
}
