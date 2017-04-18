package com.ike.coalition.platform.listeners;


import com.ike.coalition.platform.bean.PlatformBean;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface OnMinPlatformListener {
    void getMinPlatformBeanList(List<PlatformBean> data);

    void showError(String errorString);
}
