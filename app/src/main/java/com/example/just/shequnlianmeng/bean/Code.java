package com.example.just.shequnlianmeng.bean;

/**
 * Created by Min on 2016/11/28.
 */

public class Code<T> {
    private int code;
    private T msg;

    public Code() {
    }

    public Code(int code, T msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
