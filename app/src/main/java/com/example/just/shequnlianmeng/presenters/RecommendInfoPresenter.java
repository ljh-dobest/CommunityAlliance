package com.example.just.shequnlianmeng.presenters;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.bean.RecommendInfoBean;
import com.example.just.shequnlianmeng.interfaces.IWasRecommedList;
import com.example.just.shequnlianmeng.listeners.OngetRecommedInfoFinishListener;
import com.example.just.shequnlianmeng.moudle.RecommedInfoMoudle;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public class RecommendInfoPresenter extends BasePersenter<IWasRecommedList> implements OngetRecommedInfoFinishListener {
      private RecommedInfoMoudle recommendInfoMoudle;
    public RecommendInfoPresenter(){
        recommendInfoMoudle=new RecommedInfoMoudle();
    }
      public void getRecommedInfo(String userId){
           recommendInfoMoudle.getRecommedInfo(userId,this);
      }

    @Override
    public void getRecommedInfo(ArrayList<RecommendInfoBean> data) {
        mView.setRecommedListData(data);
    }

    @Override
    public void showError(String errorString) {
      mView.showError(errorString);
    }
}
