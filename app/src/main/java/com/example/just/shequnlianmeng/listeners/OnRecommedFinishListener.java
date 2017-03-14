package com.example.just.shequnlianmeng.listeners;

import com.example.just.shequnlianmeng.bean.ProvinceBean;

import java.util.ArrayList;

/**
 * Created by just on 2017/3/5.
 */

public interface OnRecommedFinishListener {
    void showTextEmpty();
    void showRecommedError(String string);
    void succeedToRecommed(String recommedId);
    void returnParserData(ArrayList<ProvinceBean> provinces);
    void returnHobbys(ArrayList<String> hobbys);
    void returnCharacters(ArrayList<String> characters);
}
