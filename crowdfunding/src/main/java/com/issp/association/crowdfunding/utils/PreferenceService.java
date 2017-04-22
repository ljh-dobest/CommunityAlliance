package com.issp.association.crowdfunding.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * 管理SharedPreferences
 * Created by T-BayMax on 2017/4/21.
 */

public class PreferenceService {
    private Context context;
    private Activity activity;

    private SharedPreferences sp;

    //此为提供方的包名
    private static String PREFERENCE_PACKAGE="com.example.just.shequnlianmeng";
    public static int MODE = Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE;
    public PreferenceService(Activity activity){
        this.activity=activity;
        try {
            context=activity.createPackageContext(PREFERENCE_PACKAGE, Context.CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        sp=context.getSharedPreferences("ikePS",MODE);
    }

    //取
    public String getPreferences() {
        String content=sp.getString("user","");
        return content;
    }
    /**
     * 获取对象
     * @param context
     * @param key
     * @return
     */
    public   Object getObjectFromShare(Context context, String key) {

        try {
            String wordBase64 = sp.getString(key, "");
            // 将base64格式字符串还原成byte数组
            if (wordBase64 == null || wordBase64.equals("")) { // 不可少，否则在下面会报java.io.StreamCorruptedException
                return null;
            }
            byte[] objBytes = Base64.decode(wordBase64.getBytes(),
                    Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(objBytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            // 将byte数组转换成product对象
            Object obj = ois.readObject();
            bais.close();
            ois.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
