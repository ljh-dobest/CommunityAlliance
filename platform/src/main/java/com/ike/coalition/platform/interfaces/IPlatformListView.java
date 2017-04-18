package com.ike.coalition.platform.interfaces;



import com.ike.coalition.platform.base.view.BaseView;
import com.ike.coalition.platform.bean.PlatformBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface IPlatformListView extends BaseView {
    void setPlatformListData(List<PlatformBean> data);

   // void dealBuyPraise(String data);
}
