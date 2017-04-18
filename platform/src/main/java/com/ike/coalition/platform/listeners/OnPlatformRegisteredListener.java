package com.ike.coalition.platform.listeners;


import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.bean.UserBean;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface OnPlatformRegisteredListener {
    void getPlatformRegisteredList(List<UserBean> data);

    void showError(String errorString);
}
