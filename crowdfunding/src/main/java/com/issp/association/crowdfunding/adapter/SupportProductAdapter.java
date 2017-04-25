package com.issp.association.crowdfunding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.base.adpater.BaseRecyclerViewAdapter;
import com.issp.association.crowdfunding.bean.ProductCollectBean;

import com.issp.association.crowdfunding.bean.ProductRewardBean;
import com.zhy.autolayout.attr.AutoAttr;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 分享列表item
 * <p>
 * Created by T-BayMax on 2017/3/16.
 */
public class SupportProductAdapter extends BaseRecyclerViewAdapter<SupportProductAdapter.ProductAdapterViewHolder, ProductRewardBean> {

    private List<ProductRewardBean> list;
    private Context context;
    private int position;
    private OnItemClickListener onItemClickListener;

    public SupportProductAdapter(List<ProductRewardBean> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(ProductAdapterViewHolder holder, int position, boolean isItem) {
        if (isItem) {
            ProductRewardBean person = list.get(position);
            holder.itemView.setTag(person);
            holder.tvMinSupport.setTag(person);

            holder.tvProductNumber.setText("认筹人数"+person.getPayNumber()+"2人/"+(person.getLimitNumber()==0?"无限制":person.getLimitNumber()));
            holder.tvPrice.setText(person.getSupportMoney()+"");
            holder.tvProductName.setText(person.getRewardTitle());
            holder.tvProductContent.setText(person.getRewardContent());
            holder.tvRemark.setText("项目介绍后"+person.getDeliveryDays()+"天发货");

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
    public ProductAdapterViewHolder getViewHolder(View view) {
        return new ProductAdapterViewHolder(view, false);
    }

    public void setData(List<ProductRewardBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ProductAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_support_product, parent, false);

        return new ProductAdapterViewHolder(v, isItem);

    }

    public void insert(ProductRewardBean person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class ProductAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_product_number)
        TextView tvProductNumber;
        @BindView(R.id.textView7)
        View textView7;
        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.tv_product_content)
        TextView tvProductContent;
        @BindView(R.id.tv_min_support)
        TextView tvMinSupport;
        @BindView(R.id.tv_remark)
        TextView tvRemark;

        public ProductAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);
                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(SupportProductAdapter.this);
            }
        }

        @OnClick(R.id.tv_min_support)
        void SupportClick(View v) {
            onItemClickListener.onSupportClick(v, (ProductRewardBean) v.getTag());
        }
    }

    public ProductRewardBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        public void onItemClick(View view, ProductRewardBean bean);

        public void onSupportClick(View view, ProductRewardBean bean);

    }

}