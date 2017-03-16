package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.bean.ClaimPeopleBean;
import com.example.just.shequnlianmeng.views.OvalImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min on 2017/3/9.
 */

public class ClaimCenterRecyclerAdapter extends RecyclerView.Adapter<ClaimCenterRecyclerAdapter.MyViewHolder> {
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    private List<ClaimPeopleBean> mDatas=new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;

    public ClaimCenterRecyclerAdapter(Context context){
        this. mContext=context;
        inflater=LayoutInflater. from(mContext);
    }
    public void setmDatas(List<ClaimPeopleBean> data){
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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ClaimPeopleBean bean = mDatas.get(position);
        String imgUrl=bean.getUserPortraitUrl();
        if(imgUrl==null){
            holder.iv_claim_lv_item.setImageResource(R.drawable.test);
        }else{
            Picasso.with(mContext).load(bean.getUserPortraitUrl()).into(holder.iv_claim_lv_item);
        }
        holder.tv_claim_lv_item.setText(bean.getUserId());

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.iv_claim_lv_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.claim_lv_item,parent, false);
        MyViewHolder holder= new MyViewHolder(view);

        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        OvalImageView iv_claim_lv_item;
        TextView tv_claim_lv_item;
        public MyViewHolder(View view) {
            super(view);
            iv_claim_lv_item= (OvalImageView) view.findViewById(R.id.iv_claim_lv_item);
            tv_claim_lv_item= (TextView) view.findViewById(R.id.tv_claim_lv_item);
        }

    }
}
