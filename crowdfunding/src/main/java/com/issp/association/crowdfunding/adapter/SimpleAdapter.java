package com.issp.association.crowdfunding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.bean.ProductCollect;
import com.issp.association.crowdfunding.bean.UserBean;

import java.util.List;


/**
 * 分享列表item
 *
 * Created by T-BayMax on 2017/3/16.
 */
public class SimpleAdapter extends BaseRecyclerAdapter<SimpleAdapter.SimpleAdapterViewHolder> {
    private List<ProductCollect> list;
    private Context context;
    private int position;


    public SimpleAdapter(List<ProductCollect> list, Context context) {
        this.list = list;
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        ProductCollect person = list.get(position);
        holder.tv_share_title.setText(person.getTitle());
        /*holder.iv_like_btn ;
        holder.iv_comment_btn ;
        holder.tv_like_btn .setText(person.getArcTitle());
        holder.tv_comment_btn.setText(person.getArcTitle());*/
        if (position < 3) {
            //holder.tv_time.setText(person.getSendDate());
            //holder.iv_share_img
        } else {
            UserBean user = person.getUserId();
            holder.tv_share_content.setText(person.getContent());
           /* Picasso.with(context).load(HttpUtils.IMAGE_RUL + user.getUserPortraitUrl())
                    .into(holder.iv_share_icon);*/
            //holder.tv_share_user_Name.setText(user.getNickname());
            //holder.tv_goods_share
            /*holder.gv_share_img
                    holder.iv_share_btn
            holder.tv_share_btn*/
        }

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

    public void setData(List<ProductCollect> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_list_itme_share, parent, false);

        SimpleAdapterViewHolder vh = new SimpleAdapterViewHolder(v, isItem);
        return vh;
    }

    public void insert(ProductCollect person, int position) {
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
        GridView gv_share_img;

        ImageView iv_share_btn;
        ImageView iv_like_btn;
        ImageView iv_comment_btn;
        TextView tv_share_btn;
        TextView tv_like_btn;
        TextView tv_comment_btn;
        TextView tv_time;
        ImageView iv_share_img;

        public SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);

            tv_share_title = (TextView) itemView.findViewById(R.id.tv_share_title);
            iv_like_btn = (ImageView) itemView.findViewById(R.id.iv_like_btn);
            iv_comment_btn = (ImageView) itemView.findViewById(R.id.iv_comment_btn);
            tv_like_btn = (TextView) itemView.findViewById(R.id.tv_like_btn);
            tv_comment_btn = (TextView) itemView.findViewById(R.id.tv_comment_btn);
                tv_share_content = (TextView) itemView.findViewById(R.id.tv_share_content);
                iv_share_icon = (ImageView) itemView.findViewById(R.id.iv_share_icon);
                tv_share_user_Name = (TextView) itemView.findViewById(R.id.tv_share_user_Name);
                tv_goods_share = (TextView) itemView.findViewById(R.id.tv_goods_share);
                iv_share_btn = (ImageView) itemView.findViewById(R.id.iv_share_btn);
                tv_share_btn = (TextView) itemView.findViewById(R.id.tv_share_btn);

                iv_share_img = (ImageView) itemView.findViewById(R.id.iv_share_img);


        }
    }

    public ProductCollect getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}