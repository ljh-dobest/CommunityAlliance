package com.example.just.shequnlianmeng.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 管理SharedPreferences
 * 用于用户数据共享
 * Created by T-BayMax on 2017/4/21.
 */

public class PreferenceService {
    //声明 初始化
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    //MODE还有其它模式
    public static int MODE = Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE;

    //文件为mySp  存放在/data/data/<packagename>/shared_prefs/目录下的
    public PreferenceService(Context context) {

        sp = context.getSharedPreferences("ikePS", MODE);

        editor = sp.edit();
    }

    /**
     * 存  还有一些其它类型
     */
    public void setPreferences() {
        editor.putString("user", "");
        editor.commit();
    }

    //取
    public String getPreferences() {
        String content = sp.getString("user", "");
        return content;
    }

    /**
     * 保存对象
     * @param context
     * @param object
     * @param key
     * @return
     */
    public boolean setObjectToShare(Context context, Object object,
                                       String key) {

        if (object == null) {
            editor = sp.edit().remove(key);
            return editor.commit();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        // 将对象放到OutputStream中
        // 将对象转换成byte数组，并将其进行base64编码
        String objectStr = new String(Base64.encode(baos.toByteArray(),
                Base64.DEFAULT));
        try {
            baos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor editor = sp.edit();
        // 将编码后的字符串写到base64.xml文件中
        editor.putString(key, objectStr);
        return editor.commit();
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
