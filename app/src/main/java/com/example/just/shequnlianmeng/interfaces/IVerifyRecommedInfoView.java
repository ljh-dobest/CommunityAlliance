package com.example.just.shequnlianmeng.interfaces;

import android.view.ViewGroup;

import com.example.just.shequnlianmeng.bean.ProvinceBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/6.
 */

public interface IVerifyRecommedInfoView {
    void showTextEmpty();
    void showVerifyInfoError(String string);
    void succeedVerifyInfo();
    void showComfirmDialog();
    void setHobby(ArrayList<String> hobbys);
    void setProvinceData(ArrayList<ProvinceBean> provinceData);
    void getHobby(ViewGroup group);
}
