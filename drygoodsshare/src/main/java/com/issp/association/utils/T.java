package com.issp.association.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Min on 2016/11/23.
 */

public class T {
    public static boolean isShow=true;

    public static void showShort(Context context, CharSequence message){
        if(isShow){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
    public static void showShort(Context context, int message){
        if(isShow){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showLong(Context context, CharSequence message){
        if(isShow){
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    public static void showLong(Context context, int message){
        if(isShow){
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}
