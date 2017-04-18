// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rb_home = Utils.findRequiredViewAsType(source, R.id.rb_home, "field 'rb_home'", RadioButton.class);
    target.rb_chat = Utils.findRequiredViewAsType(source, R.id.rb_chat, "field 'rb_chat'", RadioButton.class);
    target.rb_mine = Utils.findRequiredViewAsType(source, R.id.rb_mine, "field 'rb_mine'", RadioButton.class);
    target.radioGroup = Utils.findRequiredViewAsType(source, R.id.rg, "field 'radioGroup'", RadioGroup.class);
    target.main_vp = Utils.findRequiredViewAsType(source, R.id.main_vp, "field 'main_vp'", ViewPager.class);
    target.rl_main_header = Utils.findRequiredViewAsType(source, R.id.rl_main_header, "field 'rl_main_header'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rb_home = null;
    target.rb_chat = null;
    target.rb_mine = null;
    target.radioGroup = null;
    target.main_vp = null;
    target.rl_main_header = null;

    this.target = null;
  }
}
