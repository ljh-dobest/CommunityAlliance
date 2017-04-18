package com.ike.coalition.platform.utils;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 解析json数据
 * Created by T-BayMax on 2017/1/11.
 */

public class GsonResponsePasare<T> implements ParameterizedType {

    public T deal(String response) {
        Type gsonType = this;

        T commonResponse = new Gson().fromJson(response, gsonType);

        return commonResponse;
    }

    @Override
    public Type[] getActualTypeArguments() {
        Class clz = this.getClass();
        //这里必须注意在外面使用new GsonResponsePasare<GsonResponsePasare.DataInfo>(){};实例化时必须带上{},否则获取到的superclass为Object
        Type superclass = clz.getGenericSuperclass(); //getGenericSuperclass()获得带有泛型的父类
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return parameterized.getActualTypeArguments();
    }

    @Override
    public Type getOwnerType() {
        return this;
    }

    @Override
    public Type getRawType() {
        return this;
    }

}
