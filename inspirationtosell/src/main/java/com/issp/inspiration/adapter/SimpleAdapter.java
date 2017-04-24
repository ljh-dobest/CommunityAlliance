package com.issp.inspiration.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.inspiration.R;
import com.issp.inspiration.bean.DealBuyBean;
import com.issp.inspiration.network.HttpUtils;
import com.issp.inspiration.utils.DateConversionUtils;
import com.squareup.picasso.Picasso;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;


/**
 * 分享列表item
 * <p>
 * Created by T-BayMax on 2017/3/16.
 */
public class SimpleAdapter extends BaseRecyclerAdapter<SimpleAdapter.SimpleAdapterViewHolder> implements View.OnClickListener {
    private List<DealBuyBean> list;
    private Context context;
    private int position;

    private OnItemClickListener onItemClickListener;

    public SimpleAdapter(List<DealBuyBean> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        if (isItem) {
            DealBuyBean person = list.get(position);

            holder.ll_item.setTag(person);
            holder.ll_like.setTag(person);
            holder.ll_comment.setTag(person);


            holder.tv_share_title.setText(person.getTitle());
            if (null != person.getTime())
                holder.tv_time.setText(DateConversionUtils.setRefreshTime(context, person.getTime(), "yyyy-MM-dd HH:mm:ss"));
            holder.tv_like_btn.setText(person.getLikes() + "");
            holder.tv_comment_btn.setText(person.getCommentNumber()+"");
            switch (person.getStatusLikes()) {
                case 0:
                    holder.iv_like_btn.setImageResource(R.mipmap.img_like_btn);
                    break;
                case 1:
                    holder.iv_like_btn.setImageResource(R.mipmap.img_have_thumb_up_btn);
                    break;
                case 2:
                    holder.iv_like_btn.setImageResource(R.mipmap.img_like_btn_no);
                    break;
                case 3:
                    holder.iv_like_btn.setImageResource(R.mipmap.img_comments_have_thumb_up_btn);
                    break;
            }

            if (null != person.getImage()) {
                Picasso.with(context).load(HttpUtils.IMAGE_RUL + person.getImage())
                        .into(holder.iv_share_img);
            }
            holder.ll_item.setOnClickListener(this);
            holder.ll_like.setOnClickListener(this);
            holder.ll_comment.setOnClickListener(this);
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
    public SimpleAdapterViewHolder getViewHolder(View view) {
        return new SimpleAdapterViewHolder(view, false);
    }

    public void setData(List<DealBuyBean> list, int page) {
        if (page == 1) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }

        notifyDataSetChanged();
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v;
        // if (position < 3) {
        v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_inspiration_rl, parent, false);
       /* } else {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_list_itme_share, parent, false);
        }*/
        SimpleAdapterViewHolder vh = new SimpleAdapterViewHolder(v, isItem);
        return vh;
    }

    public void insert(DealBuyBean person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_comment:
                onItemClickListener.onCommentClick(v, (DealBuyBean) v.getTag());
                break;
            case R.id.ll_like:
                onItemClickListener.onLikeClick(v, (DealBuyBean) v.getTag());
                break;
            case R.id.ll_item:
                onItemClickListener.onItemClick(v, (DealBuyBean) v.getTag());
                break;
        }
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

        LinearLayout ll_item;
        LinearLayout ll_like;
        LinearLayout ll_comment;

        public SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);
                tv_share_title = (TextView) itemView.findViewById(R.id.tv_share_title);
                iv_like_btn = (ImageView) itemView.findViewById(R.id.iv_like_btn);
                iv_comment_btn = (ImageView) itemView.findViewById(R.id.iv_comment_btn);
                tv_like_btn = (TextView) itemView.findViewById(R.id.tv_like_btn);
                tv_comment_btn = (TextView) itemView.findViewById(R.id.tv_comment_btn);
               /* if (isItem) {
                    tv_share_content = (TextView) itemView.findViewById(R.id.tv_share_content);
                    iv_share_icon = (ImageView) itemView.findViewById(R.id.iv_share_icon);
                    tv_share_user_Name = (TextView) itemView.findViewById(R.id.tv_share_user_Name);
                    tv_goods_share = (TextView) itemView.findViewById(R.id.tv_goods_share);
                    gv_share_img = (GridView) itemView.findViewById(R.id.gv_share_img);
                    iv_share_btn = (ImageView) itemView.findViewById(R.id.iv_share_btn);
                    tv_share_btn = (TextView) itemView.findViewById(R.id.tv_share_btn);
                } else {*/

                tv_time = (TextView) itemView.findViewById(R.id.tv_time);
                iv_share_img = (ImageView) itemView.findViewById(R.id.iv_share_img);
                ll_item = (LinearLayout) itemView.findViewById(R.id.ll_item);
                ll_like = (LinearLayout) itemView.findViewById(R.id.ll_like);
                ll_comment = (LinearLayout) itemView.findViewById(R.id.ll_comment);
                //}
            }
        }
    }

    public DealBuyBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, DealBuyBean bean);

        public void onLikeClick(View view, DealBuyBean bean);

        public void onCommentClick(View view, DealBuyBean bean);
    }
}