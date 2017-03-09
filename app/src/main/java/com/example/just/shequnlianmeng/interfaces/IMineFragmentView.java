package com.example.just.shequnlianmeng.interfaces;

import com.example.just.shequnlianmeng.base.BaseView;
import com.example.just.shequnlianmeng.bean.UserInfo;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public interface IMineFragmentView extends BaseView{
    void setData(ArrayList<UserInfo> data);
}
