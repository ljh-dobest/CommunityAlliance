package com.example.just.shequnlianmeng.presenters;

import android.content.Context;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.bean.RecommendBean;
import com.example.just.shequnlianmeng.interfaces.IRecommedPresenter;
import com.example.just.shequnlianmeng.interfaces.IRecommedView;
import com.example.just.shequnlianmeng.listeners.OnRecommedFinishListener;
import com.example.just.shequnlianmeng.moudle.RecommedMoudle;

import java.util.ArrayList;

/**
 * Created by just on 2017/3/5.
 */

public class RecommendPresenterImpl extends BasePersenter<IRecommedView>implements IRecommedPresenter,OnRecommedFinishListener{
    private RecommedMoudle recommedMoudle;
    public RecommendPresenterImpl() {
        this.recommedMoudle = new RecommedMoudle();
    }


    @Override
    public void verifyRecommedInfo(RecommendBean recommendBean) {
            recommedMoudle.recommed(recommendBean,this);
    }

    @Override
    public void getParserData(Context context, String fileName) {
                recommedMoudle.getParserData(context,fileName,this);
    }

    @Override
    public void getHobby(ViewGroup group) {
     recommedMoudle.getHobby(group,this);
    }

    @Override
    public void getCharacters(ViewGroup group) {
        recommedMoudle.getCharacters(group,this);
    }

    @Override
    public void showTextEmpty() {
        if (mView!=null){
            mView.showTextEmpty();
        }
    }

    @Override
    public void showRecommedError(String string) {
        if (mView!=null){
            mView.showRecommedError(string);
        }
    }

    @Override
    public void succeedToRecommed(String recommedId) {
        if (mView!=null){
            mView.succeedToRecommed(recommedId);
        }
    }

    @Override
    public void returnParserData(ArrayList<ProvinceBean> provinces) {
        mView.getparserData(provinces);
    }

    @Override
    public void returnHobbys(ArrayList<String> hobbys) {
        mView.setHobbys(hobbys);
    }

    @Override
    public void returnCharacters(ArrayList<String> characters) {
    mView.setCharacters(characters);
    }


}
