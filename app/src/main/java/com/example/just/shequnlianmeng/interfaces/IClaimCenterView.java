package com.example.just.shequnlianmeng.interfaces;

import com.example.just.shequnlianmeng.base.view.BaseView;
import com.example.just.shequnlianmeng.bean.ClaimPeopleBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public interface IClaimCenterView extends BaseView {
    void setPeoplesData(ArrayList<ClaimPeopleBean> data);
}
