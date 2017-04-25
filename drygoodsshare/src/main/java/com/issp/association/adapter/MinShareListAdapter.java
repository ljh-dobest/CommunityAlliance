package com.issp.association.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.association.R;
import com.issp.association.bean.ShareBean;
import com.issp.association.bean.UserBean;
import com.issp.association.network.HttpUtils;
import com.squareup.picasso.Picasso;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by T-BayMax on 2017/3/20.
 */

public class MinShareListAdapter extends BaseRecyclerAdapter<MinShareListAdapter.MinShareListAdapterHolder> implements View.OnClickListener {

    private List<ShareBean> list;
    private Context context;
    private int position;

    private OnItemClickListener onItemClickListener;

    public MinShareListAdapter(List<ShareBean> list, Context context) {
        this.context=context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(MinShareListAdapterHolder holder, int position, boolean isItem) {
        if (isItem) {
            ShareBean bean = list.get(position);
            holder.llItem.setTag(bean);
            holder.llShare.setTag(bean);
            holder.llLike.setTag(bean);
            holder.llComment.setTag(bean);

      /*      holder.ll_item.setTag(bean);
            holder.ll_like.setTag(bean);
            holder.ll_comment.setTag(bean);*/
            if (null != bean.getUserPortraitUrl()) {
                Picasso.with(context).load(HttpUtils.IMAGE_RUL + bean.getUserPortraitUrl())
                        .into(holder.ivShareIcon);
            }
            holder.tvShareUserName.setText(bean.getNickname());
            holder.tvShareContent.setText(bean.getSynopsis());
            holder.tvShareTitle.setText(bean.getTitle());
            holder.tvLikeBtn.setText(bean.getLikes() + "");
            switch (bean.getLikesStatus()) {
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

            if (null != bean.getImage()) {
                Picasso.with(context).load(HttpUtils.IMAGE_RUL + bean.getImage())
                        .into(holder.ivShareImg);
            }

            holder.tvCommentBtn.setText("" + bean.getCommentNumber());
            holder.tvLikeBtn.setText("" + bean.getLikes());
          /*  holder.ll_item.setOnClickListener(this);
            holder.ll_like.setOnClickListener(this);
            holder.ll_comment.setOnClickListener(this);*/
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

    public void setData(List<ShareBean> list, int page) {
        if (page == 1) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }

        notifyDataSetChanged();
    }

    @Override
    public MinShareListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_share, parent, false);

        MinShareListAdapterHolder vh = new MinShareListAdapterHolder(v, isItem);
        return vh;
    }

    public void insert(ShareBean person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class MinShareListAdapterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_share_icon)
        ImageView ivShareIcon;
        @BindView(R.id.tv_share_user_Name)
        TextView tvShareUserName;
        @BindView(R.id.tv_goods_share)
        TextView tvGoodsShare;
        @BindView(R.id.tv_share_title)
        TextView tvShareTitle;
        @BindView(R.id.tv_share_content)
        TextView tvShareContent;
        @BindView(R.id.iv_share_img)
        ImageView ivShareImg;
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
        @BindView(R.id.ll_item)
        LinearLayout llItem;
        @BindView(R.id.ll_share)
        LinearLayout llShare;
        @BindView(R.id.ll_like)
        LinearLayout llLike;
        @BindView(R.id.ll_comment)
        LinearLayout llComment;

        public MinShareListAdapterHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                ButterKnife.bind(this, itemView);

                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);
                llItem.setOnClickListener(MinShareListAdapter.this);
                llShare.setOnClickListener(MinShareListAdapter.this);
                llLike.setOnClickListener(MinShareListAdapter.this);
                llComment.setOnClickListener(MinShareListAdapter.this);
            }
        }
    }

    public ShareBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_share:
                onItemClickListener.onShareClick(v, (ShareBean) v.getTag());
                break;
            case R.id.ll_comment:
                onItemClickListener.onCommentClick(v, (ShareBean) v.getTag());
                break;
            case R.id.ll_like:
                onItemClickListener.onLikeClick(v, (ShareBean) v.getTag());
                break;
            case R.id.ll_item:
                onItemClickListener.onItemClick(v, (ShareBean) v.getTag());
                break;
        }
    }

    public interface OnItemClickListener {
        public void onShareClick(View view, ShareBean bean);

        public void onItemClick(View view, ShareBean bean);

        public void onLikeClick(View view, ShareBean bean);

        public void onCommentClick(View view, ShareBean bean);
    }

}
