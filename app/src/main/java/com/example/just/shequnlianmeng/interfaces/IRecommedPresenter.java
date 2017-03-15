package com.example.just.shequnlianmeng.interfaces;

import android.content.Context;
import android.view.ViewGroup;

import com.example.just.shequnlianmeng.bean.RecommendBean;

/**
 * Created by just on 2017/3/5.
 */

public interface IRecommedPresenter {
    void verifyRecommedInfo(RecommendBean recommendBean);
   void getParserData(Context context,String fileName);
    void getHobby(ViewGroup group);
    void getCharacters(ViewGroup group);
}
