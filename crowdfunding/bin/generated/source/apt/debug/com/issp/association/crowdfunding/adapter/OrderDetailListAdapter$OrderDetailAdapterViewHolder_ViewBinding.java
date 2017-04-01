// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderDetailListAdapter$OrderDetailAdapterViewHolder_ViewBinding implements Unbinder {
  private OrderDetailListAdapter.OrderDetailAdapterViewHolder target;

  @UiThread
  public OrderDetailListAdapter$OrderDetailAdapterViewHolder_ViewBinding(OrderDetailListAdapter.OrderDetailAdapterViewHolder target,
      View source) {
    this.target = target;

    target.tvOrderDetailTitle = Utils.findRequiredViewAsType(source, R.id.tv_order_detail_title, "field 'tvOrderDetailTitle'", TextView.class);
    target.tvOrderDetailStatus = Utils.findRequiredViewAsType(source, R.id.tv_order_detail_status, "field 'tvOrderDetailStatus'", TextView.class);
    target.tvOrderDetailComment = Utils.findRequiredViewAsType(source, R.id.tv_order_detail_comment, "field 'tvOrderDetailComment'", TextView.class);
    target.tvOrderDetailRemark = Utils.findRequiredViewAsType(source, R.id.tv_order_detail_remark, "field 'tvOrderDetailRemark'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderDetailListAdapter.OrderDetailAdapterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvOrderDetailTitle = null;
    target.tvOrderDetailStatus = null;
    target.tvOrderDetailComment = null;
    target.tvOrderDetailRemark = null;
  }
}
