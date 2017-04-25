package com.issp.association.crowdfunding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.adpater.BaseRecyclerViewAdapter;
import com.issp.association.crowdfunding.bean.OrderDetailBean;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单详情item
 * <p>
 * Created by T-BayMax on 2017/3/25.
 */

public class ShippingAddressListAdapter extends BaseRecyclerViewAdapter<ShippingAddressListAdapter.ShippingAddressAdapterViewHolder, OrderDetailBean> {

    private List<OrderDetailBean> list;
    private Context context;
    private int position;

    public ShippingAddressListAdapter(List<OrderDetailBean> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(ShippingAddressAdapterViewHolder holder, int position, boolean isItem) {
      /*  ShareCommentBean bean = list.get(position);

            holder.itemView.setTag(bean);
        Picasso.with(context).load(HttpUtils.IMAGE_RUL + bean.getUserId().getUserPortraitUrl())
                .into(holder.ivShareIcon);
        holder.tvShareUserName.setText(bean.getUserId().getNickname());
        holder.tvOperation.setText(bean.getContent());
        holder.tvShareTitle.setText(bean.getShareId().getArcTitle());
        holder.tvCommentTime.setText(bean.getCommentTime());
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
    public ShippingAddressAdapterViewHolder getViewHolder(View view) {
        return new ShippingAddressAdapterViewHolder(view, false);
    }

    public void setData(List<OrderDetailBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ShippingAddressAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_shipping_address, parent, false);

        return new ShippingAddressAdapterViewHolder(v, isItem);
    }

    public void insert(OrderDetailBean person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class ShippingAddressAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.iv_check)
        ImageView ivCheck;
        @BindView(R.id.tv_user_phone)
        TextView tvUserPhone;
        @BindView(R.id.tv_user_address)
        TextView tvUserAddress;

        public ShippingAddressAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(ShippingAddressListAdapter.this);
                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);
            }
        }
    }

    public OrderDetailBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }

}
