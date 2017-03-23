package com.issp.association.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.association.R;
import com.issp.association.bean.ShareBean;
import com.issp.association.bean.UserBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by T-BayMax on 2017/3/20.
 */

public class MinShareListAdapter extends BaseRecyclerAdapter<MinShareListAdapter.MinShareListAdapterHolder> {
    private List<ShareBean> list;
    private Context context;
    private int position;


    public MinShareListAdapter(List<ShareBean> list, Context context) {
        this.list = list;
    }

    @Override
    public void onBindViewHolder(MinShareListAdapterHolder holder, int position, boolean isItem) {
        if (isItem) {
            ShareBean person = list.get(position);
            holder.tvShareTitle.setText(person.getArcTitle());
        /*holder.iv_like_btn ;
        holder.iv_comment_btn ;
        holder.tv_like_btn .setText(person.getArcTitle());
        holder.tv_comment_btn.setText(person.getArcTitle());*/

            UserBean user = person.getUserId();
            holder.tvShareContent.setText(person.getShareContent());
           /* Picasso.with(context).load(HttpUtils.IMAGE_RUL + user.getUserPortraitUrl())
                    .into(holder.iv_share_icon);*/
            //holder.tv_share_user_Name.setText(user.getNickname());
            //holder.tv_goods_share
            /*holder.gv_share_img
                    holder.iv_share_btn
            holder.tv_share_btn*/

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

    public void setData(List<ShareBean> list) {
        this.list = list;
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

        public MinShareListAdapterHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem)
                ButterKnife.bind(this, itemView);


        }
    }

    public ShareBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}
