package com.issp.association.crowdfunding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.adpater.BaseRecyclerViewAdapter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;
import com.issp.association.crowdfunding.bean.UserBean;

import com.issp.association.crowdfunding.network.HttpUtils;
import com.squareup.picasso.Picasso;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by T-BayMax on 2017/3/20.
 */

public class MinProductListAdapter extends BaseRecyclerViewAdapter<MinProductListAdapter.MinShareListAdapterHolder, ProductCollectBean> {
    private List<ProductCollectBean> list;
    private Context context;
    private int position;


    public MinProductListAdapter(List<ProductCollectBean> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(MinShareListAdapterHolder holder, int position, boolean isItem) {
        if (isItem) {
            ProductCollectBean person = list.get(position);
            holder.itemView.setTag(person);

            Picasso.with(context).load(HttpUtils.IMAGE_RUL + person.getImage())
                    .into(holder.ivProductIcon);

            holder.tvProductUserName.setText(person.getNickname());
            holder.tvProductTitle.setText(person.getTitle());
            holder.tvProductContent.setText(person.getObjective());
            holder.tvSurplusDate.setText("剩余" + person.getDays() + "天");
            holder.tvConfessTotal.setText("认筹总额：" + person.getContribution());
            holder.tvAmountTotal.setText("目标总额：" + person.getCapital());
            int schedule = (int) (person.getContribution() / person.getCapital() * 100);
            holder.tvSchedule.setText(schedule + "%");
            holder.pbSchedule.setProgress(schedule);
            holder.tvLikeBtn.setText(person.getLikes() + "");
            switch (person.getLikeStatus()) {
                case 0:
                    holder.ivLikeBtn.setImageResource(R.mipmap.img_like_btn);
                    break;
                case 1:
                    holder.ivLikeBtn.setImageResource(R.mipmap.img_have_thumb_up_btn);
                    break;
                case 2:
                    holder.ivLikeBtn.setImageResource(R.mipmap.img_like_btn_no);
                    break;
                case 3:
                    holder.ivLikeBtn.setImageResource(R.mipmap.img_comments_have_thumb_up_btn);
                    break;
            }
            Picasso.with(context).load(HttpUtils.IMAGE_RUL + person.getImage())
                    .into(holder.ivProductImg);
        }
    }

    @Override
    public int getAdapterItemViewType(int position) {
        this.position = position;
        return position;
    }

    @Override
    public int getAdapterItemCount() {
        return list.size();
    }

    @Override
    public MinShareListAdapterHolder getViewHolder(View view) {
        return new MinShareListAdapterHolder(view, false);
    }

    public void setData(List<ProductCollectBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MinShareListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_product_collect, parent, false);

        MinShareListAdapterHolder vh = new MinShareListAdapterHolder(v, isItem);
        return vh;
    }

    public void insert(ProductCollectBean person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class MinShareListAdapterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_product_icon)
        ImageView ivProductIcon;
        @BindView(R.id.tv_product_user_Name)
        TextView tvProductUserName;
        @BindView(R.id.tv_goods_product)
        TextView tvGoodsProduct;
        @BindView(R.id.iv_product_img)
        ImageView ivProductImg;
        @BindView(R.id.tv_surplus_date)
        TextView tvSurplusDate;
        @BindView(R.id.tv_product_title)
        TextView tvProductTitle;
        @BindView(R.id.tv_product_content)
        TextView tvProductContent;
        @BindView(R.id.tv_confess_total)
        TextView tvConfessTotal;
        @BindView(R.id.tv_amount_total)
        TextView tvAmountTotal;
        @BindView(R.id.pb_schedule)
        ProgressBar pbSchedule;
        @BindView(R.id.tv_schedule)
        TextView tvSchedule;
        @BindView(R.id.iv_share_btn)
        ImageView ivShareBtn;
        @BindView(R.id.tv_share_btn)
        TextView tvShareBtn;
        @BindView(R.id.iv_like_btn)
        ImageView ivLikeBtn;
        @BindView(R.id.tv_like_btn)
        TextView tvLikeBtn;
        @BindView(R.id.iv_comment_btn)
        ImageView ivCommentBtn;
        @BindView(R.id.tv_comment_btn)
        TextView tvCommentBtn;

        public MinShareListAdapterHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {

                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);

                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(MinProductListAdapter.this);
            }
        }
    }

    public ProductCollectBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}
