package com.issp.inspiration.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.inspiration.R;
import com.issp.inspiration.bean.CommentsBean;
import com.issp.inspiration.network.HttpUtils;
import com.issp.inspiration.utils.CircleTransform;
import com.squareup.picasso.Picasso;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 分享评论列表item
 * Created by T-BayMax on 2017/3/20.
 */

public class FeedForCommentListAdapter extends BaseRecyclerAdapter<FeedForCommentListAdapter.AdapterViewHolder>{

    private List<CommentsBean> list;
    private Context context;
    private int position;

    public OnItemClickListener onItemClickListener;

    public FeedForCommentListAdapter(List<CommentsBean> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(final AdapterViewHolder holder, int position, boolean isItem) {

        if (isItem) {
            final CommentsBean bean = list.get(position);
            if (null!=bean.getUserPortraitUrl()) {
                Picasso.with(context).load(HttpUtils.IMAGE_RUL + bean.getUserPortraitUrl())
                        .transform(new CircleTransform()).into(holder.ivShareIcon);
            }
            holder.tvShareUserName.setText(bean.getNickname()+(bean.getFromNickname()!=null?"  回复  "+bean.getFromNickname():""));
            holder.tvContent.setText(bean.getContent());
            holder.tvLikeBtn.setText(bean.getLikes() + "");
            holder.tvShareCommentTime.setText(bean.getCommentTime());
            if (bean.getLikesStatus() == 1) {
                holder.ivLikeBtn.setImageResource(R.mipmap.img_comments_have_thumb_up_btn);
            } else {
                holder.ivLikeBtn.setImageResource(R.mipmap.img_like_btn_no);
            }
            holder.llLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onLikeClick(holder, bean);
                }
            });
            holder.rlItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder, (CommentsBean) bean);
                }
            });
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
    public AdapterViewHolder getViewHolder(View view) {
        return new AdapterViewHolder(view, false);
    }

    public void setData(List<CommentsBean> list, int page) {
        if (page == 1) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }

        notifyDataSetChanged();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_feed_for_comment, parent, false);

        AdapterViewHolder vh = new AdapterViewHolder(v, isItem);
        return vh;
    }

    public void insert(CommentsBean person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_share_icon)
        ImageView ivShareIcon;
        @BindView(R.id.tv_share_user_Name)
        TextView tvShareUserName;
        @BindView(R.id.tv_like_btn)
        public TextView tvLikeBtn;
        @BindView(R.id.iv_like_btn)
        public ImageView ivLikeBtn;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_share_comment_time)
        TextView tvShareCommentTime;
        @BindView(R.id.ll_like)
        LinearLayout llLike;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;

        public AdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                ButterKnife.bind(this, itemView);
                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);
            }
        }
    }

    public CommentsBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        public void onItemClick(AdapterViewHolder viewHolder, CommentsBean bean);

        public void onLikeClick(AdapterViewHolder viewHolder, CommentsBean bean);

    }
}
