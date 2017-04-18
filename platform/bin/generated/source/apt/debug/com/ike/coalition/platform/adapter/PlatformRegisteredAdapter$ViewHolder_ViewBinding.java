// Generated code from Butter Knife. Do not modify!
package com.ike.coalition.platform.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ike.coalition.platform.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlatformRegisteredAdapter$ViewHolder_ViewBinding implements Unbinder {
  private PlatformRegisteredAdapter.ViewHolder target;

  @UiThread
  public PlatformRegisteredAdapter$ViewHolder_ViewBinding(PlatformRegisteredAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.ivUserPortraitUrl = Utils.findRequiredViewAsType(source, R.id.iv_userPortraitUrl, "field 'ivUserPortraitUrl'", ImageView.class);
    target.tvNickname = Utils.findRequiredViewAsType(source, R.id.tv_nickname, "field 'tvNickname'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlatformRegisteredAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivUserPortraitUrl = null;
    target.tvNickname = null;
  }
}
