package com.example.just.shequnlianmeng.interfaces;

import android.view.ViewGroup;

import com.example.just.shequnlianmeng.bean.ProvinceBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min on 2017/3/6.
 */

public interface IRecommedView {
    void showTextEmpty();
    void showRecommedError(String string);
    void succeedToRecommed(String RecommendId);
    void initView();
    void getViewData();
    void getparserData(ArrayList<ProvinceBean> provinces);
    void getHobbys(ViewGroup group);
    void setHobbys(List<String> hobbys);
    void getCharacters(ViewGroup group);
    void setCharacters(List<String> characters);
}
