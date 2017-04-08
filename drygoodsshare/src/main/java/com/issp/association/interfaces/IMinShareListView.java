package com.issp.association.interfaces;


import com.issp.association.base.view.BaseView;
import com.issp.association.bean.ShareBean;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface IMinShareListView extends BaseView {
    void setMinShareListData(List<ShareBean> data);

    void sharePraise(String data);
}
