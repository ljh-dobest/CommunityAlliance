package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.bean.RecommendInfoBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Min on 2017/3/9.
 */

public class MineClaimRecyclerAdapter extends RecyclerView.Adapter<MineClaimRecyclerAdapter.MyViewHolder> {

    private List<RecommendInfoBean> mDatas=new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;

    public MineClaimRecyclerAdapter(Context context){
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
//        holder.iv_mineclaim_userHeader.setText(bean.getFullName());
        holder.tv_mineclaim_name.setText(bean.getMobile());
        holder.tv_mineClaim_time.setText(bean.getRecommendId());
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.mineclaim_rv_item,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
         @BindView(R.id.iv_mineclaim_userHeader)
         RoundedImageView iv_mineclaim_userHeader;
        @BindView(R.id.tv_mineclaim_name)
        TextView tv_mineclaim_name;
        @BindView(R.id.tv_mineClaim_time)
        TextView tv_mineClaim_time;
        public MyViewHolder(View view) {
            super(view);
            iv_mineclaim_userHeader=(RoundedImageView) view.findViewById(R.id.iv_mineclaim_userHeader);
            tv_mineclaim_name=(TextView) view.findViewById(R.id.tv_mineclaim_name);
            tv_mineClaim_time=(TextView) view.findViewById(R.id.tv_mineClaim_time);
        }

    }
}
