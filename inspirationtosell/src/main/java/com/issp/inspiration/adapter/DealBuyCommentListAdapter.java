package com.issp.inspiration.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.issp.inspiration.R;
import com.issp.inspiration.base.adpater.BaseRecyclerViewAdapter;
import com.issp.inspiration.bean.DealBuyCommentBean;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 分享评论列表item
 * Created by T-BayMax on 2017/3/20.
 */

public class DaelBuyCommentListAdapter extends BaseRecyclerViewAdapter<DaelBuyCommentListAdapter.ShareCommentListAdapterViewHolder,DealBuyCommentBean> {

    private List<DealBuyCommentBean> list;
    private Context context;
    private int position;

    public DaelBuyCommentListAdapter(List<DealBuyCommentBean> list, Context context) {
        this.list = list;
    }

    @Override
    public void onBindViewHolder(ShareCommentListAdapterViewHolder holder, int position, boolean isItem) {
       /*if(isItem){
       ShareCommentBean bean = list.get(position);

            holder.itemView.setTag(bean);
        Picasso.with(context).load(HttpUtils.IMAGE_RUL + bean.getUserId().getUserPortraitUrl())
                .into(holder.ivShareIcon);
        holder.tvShareUserName.setText(bean.getUserId().getNickname());
        holder.tvContent.setText(bean.getContent());
        holder.tvLikeBtn.setText(bean.getShareId().getArcTitle());
        holder.tvShareCommentTime.setText(bean.getCommentTime());
        }
*/
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
    public ShareCommentListAdapterViewHolder getViewHolder(View view) {
        return new ShareCommentListAdapterViewHolder(view, false);
    }

    public void setData(List<DealBuyCommentBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ShareCommentListAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_deal_buy_comment, parent, false);

        ShareCommentListAdapterViewHolder vh = new ShareCommentListAdapterViewHolder(v, isItem);
        return vh;
    }

    public void insert(DealBuyCommentBean person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class ShareCommentListAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_share_icon)
        ImageView ivShareIcon;
        @BindView(R.id.tv_share_user_Name)
        TextView tvShareUserName;
        @BindView(R.id.tv_like_btn)
        TextView tvLikeBtn;
        @BindView(R.id.iv_like_btn)
        ImageView ivLikeBtn;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_share_comment_time)
        TextView tvShareCommentTime;

        public ShareCommentListAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(DaelBuyCommentListAdapter.this);
                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);
            }
        }
    }

    public DealBuyCommentBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}
