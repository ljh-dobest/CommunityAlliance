package com.example.just.shequnlianmeng.listeners;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/14.
 */

public interface InterpersonalConnectionsListener {
    /**
     * 请求失败
     * @param string
     */
    void onConnectionsError(String string);

    /**
     * 请求成功
     * @param data
     */
    void onConnectionsSucceed(List data);
}
