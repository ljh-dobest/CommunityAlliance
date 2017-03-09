package com.example.just.shequnlianmeng.interfaces;

import com.example.just.shequnlianmeng.base.BaseView;
import com.example.just.shequnlianmeng.bean.RecommendInfoBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public interface IWasRecommedList extends BaseView{
    void setRecommedListData(ArrayList<RecommendInfoBean> data);
}
