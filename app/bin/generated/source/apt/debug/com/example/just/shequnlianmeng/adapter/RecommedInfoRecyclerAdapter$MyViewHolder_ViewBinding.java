// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecommedInfoRecyclerAdapter$MyViewHolder_ViewBinding<T extends RecommedInfoRecyclerAdapter.MyViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public RecommedInfoRecyclerAdapter$MyViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_recom_info_item_fullName = Utils.findRequiredViewAsType(source, R.id.tv_recom_info_item_fullName, "field 'tv_recom_info_item_fullName'", TextView.class);
    target.tv_recom_info_item_mobile = Utils.findRequiredViewAsType(source, R.id.tv_recom_info_item_mobile, "field 'tv_recom_info_item_mobile'", TextView.class);
    target.tv_recom_info_item_recommId = Utils.findRequiredViewAsType(source, R.id.tv_recom_info_item_recommId, "field 'tv_recom_info_item_recommId'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_recom_info_item_fullName = null;
    target.tv_recom_info_item_mobile = null;
    target.tv_recom_info_item_recommId = null;

    this.target = null;
  }
}
