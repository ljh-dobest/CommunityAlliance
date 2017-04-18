// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.views.XCRoundRectImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ZhongChouLVAdapter$ViewHolder_ViewBinding<T extends ZhongChouLVAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ZhongChouLVAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_zc_item_icon = Utils.findRequiredViewAsType(source, R.id.iv_zc_item_icon, "field 'iv_zc_item_icon'", XCRoundRectImageView.class);
    target.tv_zc_item_name = Utils.findRequiredViewAsType(source, R.id.tv_zc_item_name, "field 'tv_zc_item_name'", TextView.class);
    target.tv_zc_item_style = Utils.findRequiredViewAsType(source, R.id.tv_zc_item_style, "field 'tv_zc_item_style'", TextView.class);
    target.iv_zc_item_image = Utils.findRequiredViewAsType(source, R.id.iv_zc_item_image, "field 'iv_zc_item_image'", XCRoundRectImageView.class);
    target.tv_zc_item_title = Utils.findRequiredViewAsType(source, R.id.tv_zc_item_title, "field 'tv_zc_item_title'", TextView.class);
    target.tv_zc_item_details = Utils.findRequiredViewAsType(source, R.id.tv_zc_item_details, "field 'tv_zc_item_details'", TextView.class);
    target.tv_zc_item_rcNum = Utils.findRequiredViewAsType(source, R.id.tv_zc_item_rcNum, "field 'tv_zc_item_rcNum'", TextView.class);
    target.tv_zc_item_mbNum = Utils.findRequiredViewAsType(source, R.id.tv_zc_item_mbNum, "field 'tv_zc_item_mbNum'", TextView.class);
    target.pb_zc_item = Utils.findRequiredViewAsType(source, R.id.pb_zc_item, "field 'pb_zc_item'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_zc_item_icon = null;
    target.tv_zc_item_name = null;
    target.tv_zc_item_style = null;
    target.iv_zc_item_image = null;
    target.tv_zc_item_title = null;
    target.tv_zc_item_details = null;
    target.tv_zc_item_rcNum = null;
    target.tv_zc_item_mbNum = null;
    target.pb_zc_item = null;

    this.target = null;
  }
}
