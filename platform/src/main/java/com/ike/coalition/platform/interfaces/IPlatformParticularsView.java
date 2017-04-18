package com.ike.coalition.platform.interfaces;



import com.ike.coalition.platform.base.view.BaseView;
import com.ike.coalition.platform.bean.PlatformBean;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface IPlatformParticularsView extends BaseView {
    void setPlatformParticularsData(PlatformBean data);
    void platformActivesJoinSucceed(String data);

    void userPraise(String data);
   // void dealBuyPraise(String data);
}
