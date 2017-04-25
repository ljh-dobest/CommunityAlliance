// Generated code from Butter Knife. Do not modify!
package com.ike.coalition.platform.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ike.coalition.platform.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SimpleAdapter$SimpleAdapterViewHolder_ViewBinding implements Unbinder {
  private SimpleAdapter.SimpleAdapterViewHolder target;

  private View view2131624241;

  @UiThread
  public SimpleAdapter$SimpleAdapterViewHolder_ViewBinding(final SimpleAdapter.SimpleAdapterViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.ivPlatform = Utils.findRequiredViewAsType(source, R.id.iv_platform, "field 'ivPlatform'", ImageView.class);
    target.tvPlatformStatus = Utils.findRequiredViewAsType(source, R.id.tv_platform_status, "field 'tvPlatformStatus'", TextView.class);
    target.tvPlatformTitle = Utils.findRequiredViewAsType(source, R.id.tv_platform_title, "field 'tvPlatformTitle'", TextView.class);
    target.tvAddress = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tvAddress'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_item, "field 'rlItem' and method 'itemClick'");
    target.rlItem = Utils.castView(view, R.id.rl_item, "field 'rlItem'", RelativeLayout.class);
    view2131624241 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.itemClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SimpleAdapter.SimpleAdapterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivPlatform = null;
    target.tvPlatformStatus = null;
    target.tvPlatformTitle = null;
    target.tvAddress = null;
    target.rlItem = null;

    view2131624241.setOnClickListener(null);
    view2131624241 = null;
  }
}
