package com.example.just.shequnlianmeng.utils;

import com.example.just.shequnlianmeng.bean.Code;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 解析json数据
 * Created by T-BayMax on 2017/1/11.
 */

public class GsonResponsePasare {
    public static <T> T parseJson(String jsonString, Class<T> clazz) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(jsonString, clazz);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("解析json失败");
        }
        return t;

    }

}
