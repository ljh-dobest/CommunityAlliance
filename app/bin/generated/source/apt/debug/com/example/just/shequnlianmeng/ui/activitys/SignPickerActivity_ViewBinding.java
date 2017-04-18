// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.views.mydatepicker.DatePicker2;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignPickerActivity_ViewBinding<T extends SignPickerActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SignPickerActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.picker = Utils.findRequiredViewAsType(source, R.id.my_datepicker, "field 'picker'", DatePicker2.class);
    target.btn_signpicker_sign = Utils.findRequiredViewAsType(source, R.id.btn_signpicker_sign, "field 'btn_signpicker_sign'", Button.class);
    target.tv_signpicker_back = Utils.findRequiredViewAsType(source, R.id.tv_signpicker_back, "field 'tv_signpicker_back'", TextView.class);
    target.tv_signpicker_date = Utils.findRequiredViewAsType(source, R.id.tv_signpicker_date, "field 'tv_signpicker_date'", TextView.class);
    target.iv_signpicker_lastmonth = Utils.findRequiredViewAsType(source, R.id.iv_signpicker_lastmonth, "field 'iv_signpicker_lastmonth'", ImageView.class);
    target.iv_signpicker_nextmonth = Utils.findRequiredViewAsType(source, R.id.iv_signpicker_nextmonth, "field 'iv_signpicker_nextmonth'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.picker = null;
    target.btn_signpicker_sign = null;
    target.tv_signpicker_back = null;
    target.tv_signpicker_date = null;
    target.iv_signpicker_lastmonth = null;
    target.iv_signpicker_nextmonth = null;

    this.target = null;
  }
}
