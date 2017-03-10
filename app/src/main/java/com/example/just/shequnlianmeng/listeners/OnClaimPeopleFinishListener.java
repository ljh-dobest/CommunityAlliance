package com.example.just.shequnlianmeng.listeners;

import com.example.just.shequnlianmeng.bean.ClaimPeopleBean;

import java.util.List;

/**
 * Created by just on 2017/3/5.
 */

public interface OnClaimPeopleFinishListener {
    void succeedToGetClaimPeople(List<ClaimPeopleBean> peoples);
    void failedToGetClaimPeople(String string);
    void showErrorString(String errorString);
}
