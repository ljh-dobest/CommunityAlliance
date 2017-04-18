package com.example.just.shequnlianmeng;

import android.app.Application;
import android.content.Context;

import com.example.just.shequnlianmeng.network.HttpUtils;
import com.liulishuo.filedownloader.FileDownloader;
import com.morgoo.droidplugin.PluginApplication;
import com.morgoo.droidplugin.PluginHelper;

/**
 * Created by Min on 2017/3/2.
 */

public class APP extends PluginApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.init(getApplicationContext());
        PluginHelper.getInstance().applicationOnCreate(getBaseContext());
        HttpUtils.setCookie(this);
    }
    @Override
    protected void attachBaseContext(Context base) {
        PluginHelper.getInstance().applicationAttachBaseContext(base);
        super.attachBaseContext(base);
    }
}
