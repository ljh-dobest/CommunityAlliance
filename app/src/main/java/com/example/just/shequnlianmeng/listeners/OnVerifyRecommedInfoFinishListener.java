package com.example.just.shequnlianmeng.listeners;

import com.example.just.shequnlianmeng.bean.ProvinceBean;

import java.util.ArrayList;

/**
 * Created by just on 2017/3/5.
 */

public interface OnVerifyRecommedInfoFinishListener {
    void showTextEmpty();
    void succeedToVerifyInfo();
    void failedToVerifyInfo(String string);
    void returnParserData(ArrayList<ProvinceBean> data);
    void returnHobby(ArrayList<String> hobbys);
}
