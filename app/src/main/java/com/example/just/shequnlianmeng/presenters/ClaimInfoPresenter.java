package com.example.just.shequnlianmeng.presenters;

import android.content.Context;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.bean.ClaimInfoBean;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.interfaces.IClaimInfoView;
import com.example.just.shequnlianmeng.listeners.OnClaimFinishListener;
import com.example.just.shequnlianmeng.moudle.ClaimInfoMoudle;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/10.
 */

public class ClaimInfoPresenter extends BasePersenter<IClaimInfoView> implements OnClaimFinishListener {
    private  ClaimInfoMoudle claimInfoMoudle;
    public ClaimInfoPresenter(){
        claimInfoMoudle=new ClaimInfoMoudle();
    }
     public void postClaimPeopleInfo(ClaimInfoBean claimInfo ){
         mView.showLoading();
            claimInfoMoudle.postClaimInfo(claimInfo,this);
     }

      public void getParserData(Context context, String fileName){
          claimInfoMoudle.getParserData(context,fileName,this);
      }
     public void getHobbys(ViewGroup group){
                claimInfoMoudle.getHobby(group,this);
     }

    @Override
    public void showTextEmpty() {
          mView.showTextEmpty();
        mView.hideLoading();
    }

    @Override
    public void succeedToClaim() {
        mView.hideLoading();
      mView.showSucceedClaim();
    }

    @Override
    public void failedToClaim(String string) {
        mView.hideLoading();
        mView.showError(string);
    }

    @Override
    public void returnParserData(ArrayList<ProvinceBean> provinces) {
          mView.setprovinceData(provinces);
    }

    @Override
    public void retturnHobbys(ArrayList<String> hobbys) {
        mView.setHobbys(hobbys);
    }
}
