package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class UsefulActivityLVAdapter extends BaseAdapters {
    public UsefulActivityLVAdapter(Context context, List data) {
        super(context, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.usefulactivity_lv_item, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_ua_lv_item_icon)
        XCRoundRectImageView iv_ua_lv_item_icon;
        @BindView(R.id.tv_ua_lv_item_name)
        TextView tv_ua_lv_item_name;
        @BindView(R.id.iv_ua_lv_item_image)
        XCRoundRectImageView iv_ua_lv_item_image;
        @BindView(R.id.tv_ua_lv_item_title)
        TextView tv_ua_lv_item_title;
        @BindView(R.id.tv_ua_lv_item_detail)
        TextView tv_ua_lv_item_detail;

    }

}
