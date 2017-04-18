// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding<T extends LoginActivity> implements Unbinder {
  protected T target;

  @UiThread
  public LoginActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tl_login = Utils.findRequiredViewAsType(source, R.id.tl_login, "field 'tl_login'", TabLayout.class);
    target.vp_login = Utils.findRequiredViewAsType(source, R.id.vp_login, "field 'vp_login'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tl_login = null;
    target.vp_login = null;

    this.target = null;
  }
}
