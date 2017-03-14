package com.issp.association.utils;

import android.util.Log;

/**
 * Created by Min on 2016/11/23.
 * Log封装类
 */

public class L {
    public static boolean isDebug=true;

    private static final String TAG="way";

    //默认的tag的函数
    public static void i(String msg){
        if(isDebug){
            Log.i(TAG,msg);
        }
    }
    public static void d(String msg){
        if(isDebug){
            Log.d(TAG,msg);
        }
    }
    public static void e(String msg){
        if(isDebug){
            Log.e(TAG,msg);
        }
    }
    public static void v(String msg){
        if(isDebug){
            Log.v(TAG,msg);
        }
    }

    //自定义tag
    public static void i(String tag, String msg){
        if (isDebug){
            Log.i(tag,msg);
        }
    }
    public static void d(String tag, String msg){
        if (isDebug){
            Log.d(tag,msg);
        }
    }
    public static void e(String tag, String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
    public static void v(String tag, String msg){
        if (isDebug){
            Log.v(tag,msg);
        }
    }

}
