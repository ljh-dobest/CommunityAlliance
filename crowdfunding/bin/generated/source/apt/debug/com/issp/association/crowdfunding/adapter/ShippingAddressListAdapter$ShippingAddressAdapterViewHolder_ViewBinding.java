// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShippingAddressListAdapter$ShippingAddressAdapterViewHolder_ViewBinding implements Unbinder {
  private ShippingAddressListAdapter.ShippingAddressAdapterViewHolder target;

  @UiThread
  public ShippingAddressListAdapter$ShippingAddressAdapterViewHolder_ViewBinding(ShippingAddressListAdapter.ShippingAddressAdapterViewHolder target,
      View source) {
    this.target = target;

    target.tvUserName = Utils.findRequiredViewAsType(source, R.id.tv_user_name, "field 'tvUserName'", TextView.class);
    target.ivCheck = Utils.findRequiredViewAsType(source, R.id.iv_check, "field 'ivCheck'", ImageView.class);
    target.tvUserPhone = Utils.findRequiredViewAsType(source, R.id.tv_user_phone, "field 'tvUserPhone'", TextView.class);
    target.tvUserAddress = Utils.findRequiredViewAsType(source, R.id.tv_user_address, "field 'tvUserAddress'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShippingAddressListAdapter.ShippingAddressAdapterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvUserName = null;
    target.ivCheck = null;
    target.tvUserPhone = null;
    target.tvUserAddress = null;
  }
}
