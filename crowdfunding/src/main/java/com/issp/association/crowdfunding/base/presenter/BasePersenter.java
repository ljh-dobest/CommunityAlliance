package com.issp.association.crowdfunding.base.presenter;

/**
 * Created by Min on 2017/3/8.
 * 这个是persenter的基类，主要实现绑定或解绑activity对象
 * T：持有的activity类型（改activity实现的接口）
 */

public abstract class BasePersenter<T>{
    public T mView;
    public void attach(T mView){
        this.mView=mView;
    }

    public void dettach(){
     mView=null;
    }
}
