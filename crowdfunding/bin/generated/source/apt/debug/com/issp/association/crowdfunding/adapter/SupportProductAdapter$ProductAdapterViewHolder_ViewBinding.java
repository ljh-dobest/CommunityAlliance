// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SupportProductAdapter$ProductAdapterViewHolder_ViewBinding implements Unbinder {
  private SupportProductAdapter.ProductAdapterViewHolder target;

  private View view2131624237;

  @UiThread
  public SupportProductAdapter$ProductAdapterViewHolder_ViewBinding(final SupportProductAdapter.ProductAdapterViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
    target.tvProductNumber = Utils.findRequiredViewAsType(source, R.id.tv_product_number, "field 'tvProductNumber'", TextView.class);
    target.textView7 = Utils.findRequiredView(source, R.id.textView7, "field 'textView7'");
    target.tvProductName = Utils.findRequiredViewAsType(source, R.id.tv_product_name, "field 'tvProductName'", TextView.class);
    target.tvProductContent = Utils.findRequiredViewAsType(source, R.id.tv_product_content, "field 'tvProductContent'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_min_support, "field 'tvMinSupport' and method 'SupportClick'");
    target.tvMinSupport = Utils.castView(view, R.id.tv_min_support, "field 'tvMinSupport'", TextView.class);
    view2131624237 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.SupportClick(p0);
      }
    });
    target.tvRemark = Utils.findRequiredViewAsType(source, R.id.tv_remark, "field 'tvRemark'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SupportProductAdapter.ProductAdapterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvPrice = null;
    target.tvProductNumber = null;
    target.textView7 = null;
    target.tvProductName = null;
    target.tvProductContent = null;
    target.tvMinSupport = null;
    target.tvRemark = null;

    view2131624237.setOnClickListener(null);
    view2131624237 = null;
  }
}
