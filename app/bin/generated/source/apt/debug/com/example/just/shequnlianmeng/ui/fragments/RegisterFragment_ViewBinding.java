// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterFragment_ViewBinding<T extends RegisterFragment> implements Unbinder {
  protected T target;

  private View view2131558757;

  @UiThread
  public RegisterFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.et_re_ph = Utils.findRequiredViewAsType(source, R.id.et_re_ph, "field 'et_re_ph'", EditText.class);
    target.et_re_nickname = Utils.findRequiredViewAsType(source, R.id.et_re_nickname, "field 'et_re_nickname'", EditText.class);
    target.et_re_pw = Utils.findRequiredViewAsType(source, R.id.et_re_pw, "field 'et_re_pw'", EditText.class);
    target.et_re_invite_code = Utils.findRequiredViewAsType(source, R.id.et_re_invite_code, "field 'et_re_invite_code'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_register, "method 'registerOnClick'");
    view2131558757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.registerOnClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.et_re_ph = null;
    target.et_re_nickname = null;
    target.et_re_pw = null;
    target.et_re_invite_code = null;

    view2131558757.setOnClickListener(null);
    view2131558757 = null;

    this.target = null;
  }
}
