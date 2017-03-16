package com.example.just.shequnlianmeng.presenters;

import android.content.Context;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.bean.VerifyRecommedInfoBean;
import com.example.just.shequnlianmeng.interfaces.IVerifyRecommedInfoView;
import com.example.just.shequnlianmeng.listeners.OnVerifyRecommedInfoFinishListener;
import com.example.just.shequnlianmeng.moudle.VerifyRecommedInfoMoudle;

import java.util.ArrayList;

/**
 * Created by just on 2017/3/5.
 */

public class VerifyRecommedInfoPresenter extends BasePersenter<IVerifyRecommedInfoView> implements OnVerifyRecommedInfoFinishListener{
    private VerifyRecommedInfoMoudle verifyRecommedInfoMoudle;
    public VerifyRecommedInfoPresenter() {
        verifyRecommedInfoMoudle=new VerifyRecommedInfoMoudle();
    }
    public void postVerifyRecommedInfo(VerifyRecommedInfoBean verifyRecommedInfoBean){
              verifyRecommedInfoMoudle.verifyRecommedInfo(verifyRecommedInfoBean,this);
    }
    public void parserData(Context mcontext,String fileName){
             verifyRecommedInfoMoudle.getParserData(mcontext,fileName,this);
    }
    public void getHobby(ViewGroup group){
        verifyRecommedInfoMoudle.getHobby(group,this);
    }
    @Override
    public void showTextEmpty() {
        mView.showTextEmpty();
    }

    @Override
    public void succeedToVerifyInfo() {
           mView.succeedVerifyInfo();
    }

    @Override
    public void failedToVerifyInfo(String string) {
           mView.showVerifyInfoError(string);
    }

    @Override
    public void returnParserData(ArrayList<ProvinceBean> data) {
            mView.setProvinceData(data);
    }

    @Override
    public void returnHobby(ArrayList<String> hobbys) {
         mView.setHobby(hobbys);
    }
}
