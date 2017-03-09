package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.bean.RecommendInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Min on 2017/3/9.
 */

public class RecommedInfoRecyclerAdapter extends RecyclerView.Adapter<RecommedInfoRecyclerAdapter.MyViewHolder> {

    private List<RecommendInfoBean> mDatas=new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;

    public RecommedInfoRecyclerAdapter(Context context){
        this. mContext=context;
        inflater=LayoutInflater. from(mContext);
    }
    public void setmDatas(List<RecommendInfoBean> data){
        mDatas.clear();
        mDatas=data;
        notifyDataSetChanged();
    }
    public void clearData(){
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        RecommendInfoBean bean = mDatas.get(position);
        holder.tv_recom_info_item_fullName.setText(bean.getFullName());
        holder.tv_recom_info_item_mobile.setText(bean.getMobile());
        holder.tv_recom_info_item_recommId.setText(bean.getRecommendId());
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recom_info_rv_item,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
         @BindView(R.id.tv_recom_info_item_fullName)
        TextView tv_recom_info_item_fullName;
        @BindView(R.id.tv_recom_info_item_mobile)
        TextView tv_recom_info_item_mobile;
        @BindView(R.id.tv_recom_info_item_recommId)
        TextView tv_recom_info_item_recommId;
        public MyViewHolder(View view) {
            super(view);
            tv_recom_info_item_fullName=(TextView) view.findViewById(R.id.tv_recom_info_item_fullName);
            tv_recom_info_item_mobile=(TextView) view.findViewById(R.id.tv_recom_info_item_mobile);
            tv_recom_info_item_recommId=(TextView) view.findViewById(R.id.tv_recom_info_item_recommId);
        }

    }
}
