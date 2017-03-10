package com.example.just.shequnlianmeng.presenters;

import android.content.Context;

import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.interfaces.IRecommedPresenter;
import com.example.just.shequnlianmeng.interfaces.IRecommedView;
import com.example.just.shequnlianmeng.listeners.OnRecommedFinishListener;
import com.example.just.shequnlianmeng.moudle.RecommedMoudle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by just on 2017/3/5.
 */

public class RecommendPresenterImpl implements IRecommedPresenter,OnRecommedFinishListener{
    private IRecommedView recommedView;
    private RecommedMoudle recommedMoudle;

    public RecommendPresenterImpl(IRecommedView recommedView) {
        this.recommedView = recommedView;
        this.recommedMoudle = new RecommedMoudle();
    }


    @Override
    public void verifyRecommedInfo(String userId, String fullName, String mobile, String sex,
                                   List<String> hobby, List<String> address, List<String> relationship,List<String> character, String creditScore,
                                   String birthday, String homeplace, String finishSchool, String company,
                                   String fatherName, String motherName, String marriage, String spouseName,
                                  String childrenName, String childrenSchool) {
            recommedMoudle.recommed(userId,fullName,mobile,sex,hobby,address,relationship,character,creditScore,
                    birthday,homeplace,finishSchool,company,fatherName, motherName,marriage,
                    spouseName,childrenName,childrenSchool,this);
     }

    @Override
    public void getParserData(Context context, String fileName) {
                recommedMoudle.getParserData(context,fileName,this);
    }

    @Override
    public void onDestroy() {
    recommedView=null;
    }

    @Override
    public void showTextEmpty() {
        if (recommedView!=null){
            recommedView.showTextEmpty();
        }
    }

    @Override
    public void showRecommedError(String string) {
        if (recommedView!=null){
            recommedView.showRecommedError(string);
        }
    }

    @Override
    public void succeedToRecommed(String recommedId) {
        if (recommedView!=null){
            recommedView.succeedToRecommed(recommedId);
        }
    }

    @Override
    public void returnParserData(ArrayList<ProvinceBean> provinces) {
              recommedView.getparserData(provinces);
    }


}
