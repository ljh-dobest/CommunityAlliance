package com.ike.coalition.platform.base.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

/**
 * Created by T-BayMax on 2017/3/23.
 */

public class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder,  O> extends BaseRecyclerAdapter<T> implements View.OnClickListener{

    public OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public static interface OnRecyclerViewItemClickListener<B> {
        void onItemClick(View view, B data);
    }

    @Override
    public T getViewHolder(View view) {
        return null;
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        return null;
    }

    @Override
    public void onBindViewHolder(T holder, int position, boolean isItem) {

    }

    @Override
    public int getAdapterItemCount() {
        return 0;
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(O)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
