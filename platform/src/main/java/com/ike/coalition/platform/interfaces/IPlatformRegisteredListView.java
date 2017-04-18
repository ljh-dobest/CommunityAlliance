package com.ike.coalition.platform.interfaces;



import com.ike.coalition.platform.base.view.BaseView;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.bean.UserBean;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface IPlatformRegisteredListView extends BaseView {
    void setPlatformRegisteredListData(List<UserBean> data);

   // void dealBuyPraise(String data);
}
