// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.views.XCRoundRectImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UsefulActivityLVAdapter$ViewHolder_ViewBinding<T extends UsefulActivityLVAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public UsefulActivityLVAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_ua_lv_item_icon = Utils.findRequiredViewAsType(source, R.id.iv_ua_lv_item_icon, "field 'iv_ua_lv_item_icon'", XCRoundRectImageView.class);
    target.tv_ua_lv_item_name = Utils.findRequiredViewAsType(source, R.id.tv_ua_lv_item_name, "field 'tv_ua_lv_item_name'", TextView.class);
    target.iv_ua_lv_item_image = Utils.findRequiredViewAsType(source, R.id.iv_ua_lv_item_image, "field 'iv_ua_lv_item_image'", XCRoundRectImageView.class);
    target.tv_ua_lv_item_title = Utils.findRequiredViewAsType(source, R.id.tv_ua_lv_item_title, "field 'tv_ua_lv_item_title'", TextView.class);
    target.tv_ua_lv_item_detail = Utils.findRequiredViewAsType(source, R.id.tv_ua_lv_item_detail, "field 'tv_ua_lv_item_detail'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_ua_lv_item_icon = null;
    target.tv_ua_lv_item_name = null;
    target.iv_ua_lv_item_image = null;
    target.tv_ua_lv_item_title = null;
    target.tv_ua_lv_item_detail = null;

    this.target = null;
  }
}
