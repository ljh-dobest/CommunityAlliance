package com.issp.association.crowdfunding.interfaces;



import com.issp.association.crowdfunding.base.view.BaseView;
import com.issp.association.crowdfunding.bean.ProductCollectBean;

import java.util.ArrayList;

/**
 * 支持项目
 *Created by T-BayMax on 2017/3/13.
 */

public interface IAddSupportProjectView extends BaseView {
    boolean checkInputInfo();
    void setAddSupportProjectData(String data);
}
