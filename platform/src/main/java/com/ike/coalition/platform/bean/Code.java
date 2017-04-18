package com.ike.coalition.platform.bean;

/**
 *Created by T-BayMax on 2017/3/13.
 */

public class Code<T> {
    private int code;
    private T data;
    private String msgs;

    public Code() {
    }

    public Code(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsgs() {
        return msgs;
    }

    public void setMsgs(String msgs) {
        this.msgs = msgs;
    }
}
