package com.example.just.shequnlianmeng.base;

/**
 * Created by Min on 2017/3/8.
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
