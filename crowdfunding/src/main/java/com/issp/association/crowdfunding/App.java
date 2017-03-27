package com.issp.association.crowdfunding;


import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by T-BayMax on 2017/3/21.
 */

public class App extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
<<<<<<< HEAD
        AutoLayoutConifg.getInstance().useDeviceSize();
=======
        AutoLayoutConifg.getInstance().useDeviceSize().init(this);
>>>>>>> bxh
    }
}
