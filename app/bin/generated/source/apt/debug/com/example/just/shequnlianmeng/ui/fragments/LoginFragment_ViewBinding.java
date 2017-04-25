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

public class LoginFragment_ViewBinding<T extends LoginFragment> implements Unbinder {
  protected T target;

  private View view2131558751;

  @UiThread
  public LoginFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.et_userName = Utils.findRequiredViewAsType(source, R.id.et_userName, "field 'et_userName'", EditText.class);
    target.et_pw = Utils.findRequiredViewAsType(source, R.id.et_login_pw, "field 'et_pw'", EditText.class);
    view = Utils.findRequiredView(source, R.id.sign_in_btn, "method 'loginOnClick'");
    view2131558751 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loginOnClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.et_userName = null;
    target.et_pw = null;

    view2131558751.setOnClickListener(null);
    view2131558751 = null;

    this.target = null;
  }
}
