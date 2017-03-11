package com.example.just.shequnlianmeng.interfaces;

import com.example.just.shequnlianmeng.bean.RelationBean;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/10.
 */

public interface IRelationMapView {
    /**
     *  检查输入的合法性
     * @return
     */
    boolean checkInputInfo();

    /**
     * 请求成功
     */
    void onRelationSucceed(RelationBean relation);

    /**
     * 请求失败
     */
    void onRelationFailed(String failed);
}
