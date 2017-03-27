package com.issp.association.crowdfunding.listeners;


import com.issp.association.crowdfunding.bean.ProductCollectBean;

import java.util.ArrayList;

/**
 * 支持项目
 *Created by T-BayMax on 2017/3/13.
 */

public interface OnAddSupportProjectListener {
    void getAddSupportProjectInfo(String data);
    void showError(String errorString);
}
