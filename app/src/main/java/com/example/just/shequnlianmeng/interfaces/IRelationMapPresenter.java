package com.example.just.shequnlianmeng.interfaces;

import java.util.Map;

/**
 * 关系图谱
 * Created by T-BayMax on 2017/3/10.
 */

public interface IRelationMapPresenter {
    /**
     * post获取关系图谱
     * @param formData 当前用户
     */
    void postRelationMapData(Map<String,String> formData);
}
