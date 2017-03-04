package com.example.just.shequnlianmeng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.BaseAdapters;
import com.example.just.shequnlianmeng.views.XCRoundRectImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Min on 2017/3/3.
 */

public class HomePageLVAdapter extends BaseAdapters{
    public HomePageLVAdapter(Context context, List data) {
        super(context, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        GVViewHolder gvHolder=null;
        int type=getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case 0:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_lv_item, parent, false);
                    holder = new ViewHolder();
                  ButterKnife.bind(holder, convertView);
                    convertView.setTag(holder);
                    break;
                case 1:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_lv_item2, parent, false);
                    gvHolder = new GVViewHolder();
                    ButterKnife.bind(gvHolder, convertView);
                    convertView.setTag(gvHolder);
                    break;
            }
        }
     if(type==1){
         gvHolder= (GVViewHolder) convertView.getTag();
         gvHolder.lv_gv.setAdapter(new HomePageItemGVAdapter(parent.getContext()));
     }
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.iv_icon)
        XCRoundRectImageView iv_con;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_style)
        TextView tv_style;
        @BindView(R.id.iv_image)
        XCRoundRectImageView iv_image;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_details)
        TextView tv_details;

    }
    class GVViewHolder{
        @BindView(R.id.iv_home_icon1)
        XCRoundRectImageView iv_home_icon1;
        @BindView(R.id.tv_home_name1)
        TextView tv_home_name1;
        @BindView(R.id.tv_home_style1)
        TextView tv_home_style1;
        @BindView(R.id.lv_gv)
        GridView lv_gv;
        @BindView(R.id.tv_home_title1)
        TextView tv_home_title1;
        @BindView(R.id.tv_home_details1)
        TextView tv_home_details1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==2){
            return 1;
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}
