package com.ike.coalition.platform.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ike.coalition.platform.R;
import com.ike.coalition.platform.bean.UserBean;
import com.ike.coalition.platform.network.HttpUtils;
import com.ike.coalition.platform.utils.CircleTransform;
import com.squareup.picasso.Picasso;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 平台活动报名用户列表item
 * <p>
 * Created by T-BayMax on 2017/3/16.
 */
public class PlatformRegisteredAdapter extends BaseAdapter {

    private List<UserBean> list;
    private  Context context;
    public PlatformRegisteredAdapter (List<UserBean> list,Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void setData(List<UserBean> list, int page) {
        if (page == 1) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }
        PlatformRegisteredAdapter.this.notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.view_list_item_registered, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        UserBean person = list.get(position);

        holder.tvNickname.setText(person.getNickname());

        if (null != person.getUserPortraitUrl()) {
            Picasso.with(context).load(HttpUtils.IMAGE_RUL + person.getUserPortraitUrl())
                    .transform(new CircleTransform()).into(holder.ivUserPortraitUrl);
        }
        return convertView;
    }

     class ViewHolder {
        @BindView(R.id.iv_userPortraitUrl)
        ImageView ivUserPortraitUrl;
        @BindView(R.id.tv_nickname)
        TextView tvNickname;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            AutoUtils.autoSize(view, AutoAttr.BASE_HEIGHT);
        }
    }

}