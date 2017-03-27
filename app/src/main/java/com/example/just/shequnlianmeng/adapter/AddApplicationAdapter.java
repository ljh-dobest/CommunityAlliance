package com.example.just.shequnlianmeng.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.bean.ApplyListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min on 2016/7/6.
 */
public class AddApplicationAdapter extends BaseAdapter {
    private Activity activity;
    private List<ApplyListItem> lists;
    private Context context;
    private LayoutInflater inflater;

    public AddApplicationAdapter(List<ApplyListItem> lists, Context context) {
        this.lists = lists;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        MyViewHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.view_item_add_application, null);
            holder = new MyViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.iv_application_img);
            holder.textView = (TextView) view.findViewById(R.id.tv_application_tile);
            view.setTag(holder);
        } else {
            holder = (MyViewHolder) view.getTag();
        }

        ApplyListItem item = lists.get(position);
        holder.textView.setText(item.getAppName());
        holder.imageView.setImageResource(item.getAppImg());
        return view;

    }

    public void setData(List<ApplyListItem> list) {
        this.lists = list;
    }
}


class MyViewHolder {
    TextView textView;
    ImageView imageView;
}
