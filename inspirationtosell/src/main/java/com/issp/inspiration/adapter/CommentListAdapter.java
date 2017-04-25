package com.issp.inspiration.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.inspiration.R;
import com.issp.inspiration.bean.CommentsBean;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 消息列表item
 * <p>
 * Created by T-BayMax on 2017/3/16.
 */

public class CommentListAdapter extends BaseRecyclerAdapter<CommentListAdapter.CommentListAdapterViewHolder> {
    private List<CommentsBean> list;
    private Context context;
    private int position;

    public CommentListAdapter(List<CommentsBean> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(CommentListAdapterViewHolder holder, int position, boolean isItem) {
       /* if (isItem){
        ShareCommentBean bean = list.get(position);
        Picasso.with(context).load(HttpUtils.IMAGE_RUL + bean.getUserId().getUserPortraitUrl())
                .into(holder.ivShareIcon);
        holder.tvShareUserName.setText(bean.getUserId().getNickname());
        holder.tvOperation.setText(bean.getContent());
        holder.tvShareTitle.setText(bean.getShareId().getArcTitle());
        holder.tvCommentTime.setText(bean.getCommentTime());
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
    public CommentListAdapterViewHolder getViewHolder(View view) {
        return new CommentListAdapterViewHolder(view, false);
    }

    public void setData(List<CommentsBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public CommentListAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_comment_message, parent, false);

        CommentListAdapterViewHolder vh = new CommentListAdapterViewHolder(v, isItem);
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

    public class CommentListAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_share_icon)
        ImageView ivShareIcon;
        @BindView(R.id.tv_share_user_Name)
        TextView tvShareUserName;
        @BindView(R.id.tv_operation)
        TextView tvOperation;
        @BindView(R.id.tv_share_title)
        TextView tvShareTitle;
        @BindView(R.id.tv_comment_time)
        TextView tvCommentTime;

        public CommentListAdapterViewHolder(View itemView, boolean isItem) {
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

}
