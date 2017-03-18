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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleAdapter extends BaseRecyclerAdapter<SimpleAdapter.SimpleAdapterViewHolder> {
    private List<ShareBean> list;
    private int largeCardHeight, smallCardHeight;
    private int position;

    public SimpleAdapter(List<ShareBean> list, Context context) {
        this.list = list;
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        ShareBean person = list.get(position);
        holder.tv_share_title.setText(person.getArcTitle());
        holder.tv_share_content.setText(person.getShareContent());
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();

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
    public SimpleAdapterViewHolder getViewHolder(View view) {
        return new SimpleAdapterViewHolder(view, false);
    }

    public void setData(List<ShareBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v;
        if (position < 3) {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_list_itme_share_rl, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_list_itme_share, parent, false);
        }
        SimpleAdapterViewHolder vh = new SimpleAdapterViewHolder(v, isItem);
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

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_share_icon;
        TextView tv_share_user_Name;
        TextView tv_goods_share;
        TextView tv_share_title;
        TextView tv_share_content;
        ImageView iv_share_img;
        ImageView iv_share_btn;
        ImageView iv_like_btn;
        ImageView iv_comment_btn;

        public SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                iv_share_icon = (ImageView) itemView.findViewById(R.id.iv_share_icon);
                tv_share_user_Name = (TextView) itemView.findViewById(R.id.tv_share_user_Name);
                tv_goods_share = (TextView) itemView.findViewById(R.id.tv_goods_share);
                tv_share_title = (TextView) itemView.findViewById(R.id.tv_share_title);
                tv_share_content = (TextView) itemView.findViewById(R.id.tv_share_content);
                iv_share_img = (ImageView) itemView.findViewById(R.id.iv_share_img);
                iv_share_btn = (ImageView) itemView.findViewById(R.id.iv_share_btn);
                iv_like_btn = (ImageView) itemView.findViewById(R.id.iv_like_btn);
                iv_comment_btn = (ImageView) itemView.findViewById(R.id.iv_comment_btn);

            }

        }
    }

    public class SimpleAdapterViewHolderBN extends RecyclerView.ViewHolder {
        ImageView iv_share_icon;
        TextView tv_share_user_Name;
        TextView tv_goods_share;
        TextView tv_share_title;
        TextView tv_share_content;
        ImageView iv_share_img;
        ImageView iv_share_btn;
        ImageView iv_like_btn;
        GridView gv_share_img;

        public SimpleAdapterViewHolderBN(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                iv_share_icon = (ImageView) itemView.findViewById(R.id.iv_share_icon);
                tv_share_user_Name = (TextView) itemView.findViewById(R.id.tv_share_user_Name);
                tv_goods_share = (TextView) itemView.findViewById(R.id.tv_goods_share);
                tv_share_title = (TextView) itemView.findViewById(R.id.tv_share_title);
                tv_share_content = (TextView) itemView.findViewById(R.id.tv_share_content);
                iv_share_img = (ImageView) itemView.findViewById(R.id.iv_share_img);
                iv_share_btn = (ImageView) itemView.findViewById(R.id.iv_share_btn);
                iv_like_btn = (ImageView) itemView.findViewById(R.id.iv_like_btn);
                gv_share_img = (GridView) itemView.findViewById(R.id.gv_share_img);
            }

        }
    }

    public class SimpleAdapterViewHolderRL extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_share_title)
        TextView tv_share_title;
        @BindView(R.id.tv_share_content)
        TextView tv_share_content;
        @BindView(R.id.iv_share_btn)
        ImageView iv_share_btn;
        @BindView(R.id.iv_like_btn)
        ImageView iv_like_btn;
        @BindView(R.id.tv_like_btn)
        TextView tv_like_btn;
        @BindView(R.id.iv_comment_btn)
        ImageView iv_comment_btn;
        @BindView(R.id.tv_comment)
        TextView tv_comment;
        @BindView(R.id.tv_time)
        TextView tv_time;

        public SimpleAdapterViewHolderRL(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                ButterKnife.bind(this, itemView);
            }

        }
    }

    public ShareBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}