package com.example.just.shequnlianmeng.listeners;

/**
 * Created by just on 2017/3/5.
 */

public interface OnRecommedFinishListener {
    void showTextEmpty();
    void showRecommedError(String string);
    void succeedToRecommed(String recommedId);
}
