package com.ike.coalition.platform.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.ike.coalition.platform.R;
import com.ike.coalition.platform.bean.PlatformBean;
import com.ike.coalition.platform.network.HttpUtils;
import com.squareup.picasso.Picasso;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 平台活动列表item
 * <p>
 * Created by T-BayMax on 2017/3/16.
 */
public class SimpleAdapter extends BaseRecyclerAdapter<SimpleAdapter.SimpleAdapterViewHolder>{

    private List<PlatformBean> list;
    private Context context;
    private int position;

    private OnItemClickListener onItemClickListener;


    public SimpleAdapter(List<PlatformBean> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        if (isItem) {
            PlatformBean person = list.get(position);

            holder.rlItem.setTag(person);
            holder.tvPlatformStatus.setText(person.getStatus()==0?"已结束":"进行中");
            holder.tvPlatformTitle.setText(person.getTitle());
            holder.tvAddress.setText(person.getAddress());

            if (null != person.getActivesImage()) {
                Picasso.with(context).load(HttpUtils.IMAGE_RUL + person.getActivesImage())
                        .into(holder.ivPlatform);
            }

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

    public void setData(List<PlatformBean> list, int page) {
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
                R.layout.view_list_item_platform, parent, false);
       /* } else {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_list_itme_share, parent, false);
        }*/
        SimpleAdapterViewHolder vh = new SimpleAdapterViewHolder(v, isItem);
        return vh;
    }

    public void insert(PlatformBean person, int position) {
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


    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_platform)
        ImageView ivPlatform;
        @BindView(R.id.tv_platform_status)
        TextView tvPlatformStatus;
        @BindView(R.id.tv_platform_title)
        TextView tvPlatformTitle;
        @BindView(R.id.tv_address)
        TextView tvAddress;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;

        public SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                ButterKnife.bind(this, itemView);
                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);

            }
        }

        @OnClick(R.id.rl_item)
        void itemClick(View v) {
            onItemClickListener.onItemClick(v, (PlatformBean) v.getTag());
        }
    }

    public PlatformBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, PlatformBean bean);
    }
}