package com.issp.association.interfaces;


import com.issp.association.base.view.BaseView;
import com.issp.association.bean.ShareBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public interface IShareList extends BaseView {
    void setShareListData(ArrayList<ShareBean> data);
}
