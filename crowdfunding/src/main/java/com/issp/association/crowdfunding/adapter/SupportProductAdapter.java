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
<<<<<<< HEAD
=======
import com.zhy.autolayout.attr.AutoAttr;
>>>>>>> bxh
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 分享列表item
 * <p>
 * Created by T-BayMax on 2017/3/16.
 */
public class SupportProductAdapter extends BaseRecyclerViewAdapter<SupportProductAdapter.ProductAdapterViewHolder,ProductCollectBean> {

    private List<ProductCollectBean> list;
    private Context context;
    private int position;


    public SupportProductAdapter(List<ProductCollectBean> list, Context context) {
        this.list = list;
    }

    @Override
    public void onBindViewHolder(ProductAdapterViewHolder holder, int position, boolean isItem) {
        if (isItem) {
            ProductCollectBean person=list.get(position);
            holder.itemView.setTag(person);

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

    public void setData(List<ProductCollectBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ProductAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.view_list_itme_support_product, parent, false);
<<<<<<< HEAD
        AutoUtils.autoSize(v);

        return new ProductAdapterViewHolder(v, isItem);
=======
         return new ProductAdapterViewHolder(v, isItem);
>>>>>>> bxh
    }

    public void insert(ProductCollectBean person, int position) {
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
<<<<<<< HEAD
=======
                AutoUtils.autoSize(itemView, AutoAttr.BASE_HEIGHT);
>>>>>>> bxh
                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(SupportProductAdapter.this);
            }
        }
    }

    public ProductCollectBean getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }


}