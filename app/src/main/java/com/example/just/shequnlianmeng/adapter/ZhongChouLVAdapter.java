package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.adpater.BaseAdapters;
import com.example.just.shequnlianmeng.views.XCRoundRectImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Min on 2017/3/3.
 */

public class ZhongChouLVAdapter extends BaseAdapters {
    public ZhongChouLVAdapter(Context context, List data) {
        super(context, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zc_lv_item, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_zc_item_icon)
        XCRoundRectImageView iv_zc_item_icon;
        @BindView(R.id.tv_zc_item_name)
        TextView tv_zc_item_name;
        @BindView(R.id.tv_zc_item_style)
        TextView tv_zc_item_style;
        @BindView(R.id.iv_zc_item_image)
        XCRoundRectImageView iv_zc_item_image;
        @BindView(R.id.tv_zc_item_title)
        TextView tv_zc_item_title;
        @BindView(R.id.tv_zc_item_details)
        TextView tv_zc_item_details;
        @BindView(R.id.tv_zc_item_rcNum)
        TextView tv_zc_item_rcNum;
        @BindView(R.id.tv_zc_item_mbNum)
        TextView tv_zc_item_mbNum;
        @BindView(R.id.pb_zc_item)
        ProgressBar pb_zc_item;
    }

}
