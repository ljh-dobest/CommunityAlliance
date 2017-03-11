package com.example.just.shequnlianmeng.listeners;

import com.example.just.shequnlianmeng.bean.RelationBean;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/11.
 */

public interface RelationMapListener {
    /**
     * 请求失败
     * @param string
     */
    void onRelationError(String string);

    /**
     * 请求成功
     * @param relation
     */
    void onRelationSucceed(RelationBean relation);
}
