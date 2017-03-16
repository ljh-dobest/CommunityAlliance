package com.example.just.shequnlianmeng.interfaces;

import android.view.ViewGroup;

import com.example.just.shequnlianmeng.base.view.BaseView;
import com.example.just.shequnlianmeng.bean.ProvinceBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/10.
 */

public interface IClaimInfoView extends BaseView {
    void showTextEmpty();
    void showSucceedClaim();
    void getHobbys(ViewGroup group);
    void setHobbys(ArrayList<String> hobbys);
    void setprovinceData(ArrayList<ProvinceBean> data);
}
