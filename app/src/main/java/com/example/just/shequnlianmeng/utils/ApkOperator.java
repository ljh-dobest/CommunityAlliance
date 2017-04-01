package com.example.just.shequnlianmeng.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.example.just.shequnlianmeng.bean.ApkItem;
import com.google.gson.Gson;
import com.morgoo.droidplugin.pm.PluginManager;
import com.morgoo.helper.compat.PackageManagerCompat;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.io.File;

import okhttp3.Cookie;


/**
 * Apk操作, 包含删除\安装\卸载\启动Apk
 * <p>
 *
 * @author T-BayMax
 */
public class ApkOperator {

    public static final int TYPE_STORE = 0; // 存储Apk
    public static final int TYPE_START = 1; // 启动Apk

    private Activity mActivity;       // 绑定Dialog
    // private RemoveCallback mCallback; // 删除Item的回调

    public ApkOperator(Activity activity) {
        mActivity = activity;
    }

    // 删除Apk
    public void deleteApk(final ApkItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("警告");
        builder.setMessage("你确定要删除" + item.title + "么？");
        builder.setNegativeButton("删除", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (new File(item.apkFile).delete()) {
                    // mCallback.removeItem(item);
                    Toast.makeText(mActivity, "删除成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mActivity, "删除失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNeutralButton("取消", null);
        builder.show();
    }

    /**
     * 安装Apk, 耗时较长, 需要使用异步线程
     *
     * @param item Apk项
     * @return [0:成功, 1:已安装, -1:连接失败, -2:权限不足, -3:安装失败]
     */
    public String installApk(final ApkItem item) {
        String res = "成功";
        if (!PluginManager.getInstance().isConnected()) {
            return "连接失败"; // 连接失败
        }
        FileUtils fileUtils = new FileUtils();
        if (isApkInstall(item)) {
            try {
                int info = PluginManager.getInstance().installPackage(item.apkFile, PackageManagerCompat.INSTALL_REPLACE_EXISTING);
                Log.e("", info + "");
                fileUtils.deleteFile(item.apkFile);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return "已安装"; // 已安装
        }

        try {
            int result = PluginManager.getInstance().installPackage(item.apkFile, 0);
            fileUtils.deleteFile(item.apkFile);
            boolean isRequestPermission = (result == PluginManager.INSTALL_FAILED_NO_REQUESTEDPERMISSION);
            if (isRequestPermission) {
                return "权限不足";
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            return "安装失败";
        }
        return res;
    }

    // Apk是否安装
    public boolean isApkInstall(ApkItem apkItem) {
        PackageInfo info = null;
        try {
            info = PluginManager.getInstance().getPackageInfo(apkItem.packageInfo.packageName, 0);
            // openApk(apkItem);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return info != null;
    }

    // Apk是否可更新
    public boolean isApkUpdate(ApkItem apkItem) {
        PackageInfo info = null;
        boolean boo = false;
        try {
            info = PluginManager.getInstance().getPackageInfo(apkItem.packageInfo.packageName, 0);
            if (info.versionCode < apkItem.versionCode) {
                boo = true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return boo;
    }

    public String versionCode(ApkItem apkItem) {
        PackageInfo info = null;
        String code = "0";
        try {
            info = PluginManager.getInstance().getPackageInfo(apkItem.packageInfo.packageName, 0);
            code = info.versionName;
        } catch (RemoteException e) {
            e.printStackTrace();
            code = "0";
        }
        return code;
    }

    // 卸载Apk
    public void uninstallApk(final ApkItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("警告");
        builder.setMessage("警告，你确定要卸载" + item.title + "么？");
        builder.setNegativeButton("卸载", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!PluginManager.getInstance().isConnected()) {
                    Toast.makeText(mActivity, "服务未连接", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        PluginManager.getInstance().deletePackage(item.packageInfo.packageName, 0);
                        // mCallback.removeItem(item);
                        Toast.makeText(mActivity, "卸载完成", Toast.LENGTH_SHORT).show();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        builder.setNeutralButton("取消", null);
        builder.show();
    }

    // 打开Apk
    public void openApk(final ApkItem item) {
        PackageManager pm = mActivity.getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(item.packageInfo.packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        mActivity.startActivity(intent);

    }

    // 删除Item回调, Adapter调用删除Item
    public interface RemoveCallback {
        void removeItem(ApkItem apkItem);
    }
}
