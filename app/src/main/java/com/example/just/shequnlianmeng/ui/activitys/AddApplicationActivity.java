package com.example.just.shequnlianmeng.ui.activitys;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteException;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.adapter.AddApplicationAdapter;
import com.example.just.shequnlianmeng.base.presenter.BasePersenter;
import com.example.just.shequnlianmeng.base.view.BaseActivity;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;

import com.example.just.shequnlianmeng.bean.ApkItem;
import com.example.just.shequnlianmeng.bean.ApplyListItem;
import com.example.just.shequnlianmeng.utils.ApkOperator;
import com.example.just.shequnlianmeng.utils.FileUtils;
import com.example.just.shequnlianmeng.utils.T;
import com.morgoo.droidplugin.pm.PluginManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import butterknife.OnItemClick;


/**
 * Created by T-BayMax on 2017/3/27.
 */

public class AddApplicationActivity extends BaseActivity {

    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.gv_application)
    GridView gvApplication;

    private List<ApplyListItem> list;
    private AddApplicationAdapter adapter;

    private ApkOperator mApkOperator; // Apk操作
    private List<String> listApk;
    private static String pageName = "app";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_application);
        ButterKnife.bind(this);
        initData();

        writeToSDFromInput();
        apkTask();

    }

    @OnClick(R.id.lt_main_title_left)
    void leftClick() {
        AddApplicationActivity.this.finish();
    }

    private void initData() {


        list = new ArrayList<ApplyListItem>(0);
        list.add(new ApplyListItem("shareApp", "干货分享", R.mipmap.ganhuo, 1, "com.issp.association", 0));
        list.add(new ApplyListItem("", "灵感贩卖", R.mipmap.linggan, 1, "", 0));
        list.add(new ApplyListItem("", "认领中心", R.mipmap.lingyang, 1, "", 0));
        list.add(new ApplyListItem("", "直播中心", R.mipmap.zhibo, 1, "", 0));
        list.add(new ApplyListItem("", "联盟打车", R.mipmap.dache, 1, "", 0));
        list.add(new ApplyListItem("", "求助中心", R.mipmap.qiuzhu, 1, "", 0));
        list.add(new ApplyListItem("crowdApp", "众筹", R.mipmap.qiuzhu, 1, "com.issp.association.crowdfunding", 0));
        adapter = new AddApplicationAdapter(list, AddApplicationActivity.this);
        gvApplication.setAdapter(adapter);
    }

    @OnItemClick(R.id.gv_application)
    void itemClick(int position) {
        ArrayList<ApkItem> apkFromInstall = getApkFromInstall();
        for (int i = 0; i < apkFromInstall.size(); i++) {
            if (apkFromInstall.get(i).packageInfo.packageName.equals(list.get(position).getPackageName())) {
                mApkOperator.openApk(apkFromInstall.get(position));
            } else {
                T.showShort(AddApplicationActivity.this, "亲还没有添加哦");
            }

        }

    }

    private void writeToSDFromInput() {
        listApk = new ArrayList<String>(0);
        String str[] = new String[0];
        FileUtils fileUtils = new FileUtils(AddApplicationActivity.this);
        try {
            str = getAssets().list(pageName);
            for (int i = 0; i < str.length; i++) {
                String name =pageName +"/"+ str[i];
                InputStream is = getAssets().open(name);
                fileUtils.deepFile(str[i], is);
                listApk.add(str[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 从下载文件夹获取Apk
    private ArrayList<ApkItem> getApkFromDownload() {
        FileUtils fileUtils = new FileUtils(AddApplicationActivity.this);
       // for (int i = 0; i <listApk.size() ; i++) {
            File files = fileUtils.redFile("");
       // }
        PackageManager pm = getApplicationContext().getPackageManager();
        ArrayList<ApkItem> apkItems = new ArrayList<>(0);
        try {
            if (null != files.listFiles()) {
                for (File file : files.listFiles()) {
                    if (file.exists() && file.getPath().toLowerCase().endsWith(".apk")) {
                        final PackageInfo info = pm.getPackageArchiveInfo(file.getPath(), 0);
                        apkItems.add(new ApkItem(pm, info, file.getPath()));
                    }
                }
            }
        } catch (Exception e) {

        }

        return apkItems;
    }

    // 在安装中获取Apk

    private ArrayList<ApkItem> getApkFromInstall() {
        ArrayList<ApkItem> apkItems = new ArrayList<>(0);
        try {
            final List<PackageInfo> infos = PluginManager.getInstance().getInstalledPackages(0);
            if (infos == null) {
                return apkItems;
            }
            final PackageManager pm = getPackageManager();
            // noinspection all
            for (final PackageInfo info : infos) {
                apkItems.add(new ApkItem(pm, info, info.applicationInfo.publicSourceDir));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return apkItems;
    }

    public int apkTask() {
        int size = 0;
        mApkOperator = new ApkOperator(this);
        ArrayList<ApkItem> apkFromDownload = getApkFromDownload();
        if (null != apkFromDownload && apkFromDownload.size() > 0) {
            size = apkFromDownload.size();
            for (int i = 0; i < size; i++) {

                new InstallApkTask(apkFromDownload.get(i)).execute();
            }
            // Toast.makeText(this, "正在初始化中、、、请稍后", Toast.LENGTH_LONG).show();
        }

        return size;
    }

    // 安装Apk的线程, Rx无法使用.
    private class InstallApkTask extends AsyncTask<Void, Void, String> {

        private ApkItem mApkItem; // Apk项

        public InstallApkTask(ApkItem mApkItem) {
            this.mApkItem = mApkItem;
        }

        @Override
        protected void onPostExecute(String v) {
            // Toast.makeText(com.t.baymax.navi.activity, v, Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(Void... params) {
            return mApkOperator.installApk(mApkItem);
        }

    }

}
