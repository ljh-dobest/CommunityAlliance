package com.issp.association.interfaces;


import com.issp.association.base.view.BaseView;
import com.issp.association.bean.ShareBean;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 *Created by T-BayMax on 2017/3/13.
=======
 * Created by T-BayMax on 2017/3/13.
>>>>>>> bxh
 */

public interface IShareListView extends BaseView {
    void setShareListData(ArrayList<ShareBean> data);

    void sharePraise(String data);
}
