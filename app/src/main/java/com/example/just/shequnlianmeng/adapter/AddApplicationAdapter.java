package com.example.just.shequnlianmeng.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.czp.library.ArcProgress;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.bean.ApplyListItem;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.view_item_add_application, null);

            AutoUtils.autoSize(view, AutoAttr.BASE_HEIGHT);

            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ApplyListItem item = lists.get(position);
        holder.tvApplicationTile.setText(item.getAppName());
        holder.ivApplicationImg.setImageResource(item.getAppImg());
        holder.pbSchedule.setMax(1);
        holder.pbSchedule.setProgress(0);
        return view;

    }

    public void setData(List<ApplyListItem> list) {
        this.lists = list;
    }

    public class ViewHolder {
        @BindView(R.id.iv_application_img)
        ImageView ivApplicationImg;
        @BindView(R.id.pb_schedule)
        ArcProgress pbSchedule;
        @BindView(R.id.iv_download)
        ImageView ivDownload;
        @BindView(R.id.rl_application)
        RelativeLayout rlApplication;
        @BindView(R.id.tv_application_tile)
        TextView tvApplicationTile;
        public int id;

        public void addTaskForViewHolder(final BaseDownloadTask task) {
            id = task.getId();
            task.setTag(ViewHolder.this);
        }

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}


