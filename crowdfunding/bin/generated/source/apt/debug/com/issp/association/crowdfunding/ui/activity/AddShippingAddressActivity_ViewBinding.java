// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddShippingAddressActivity_ViewBinding implements Unbinder {
  private AddShippingAddressActivity target;

  private View view2131624140;

  private View view2131624118;

  @UiThread
  public AddShippingAddressActivity_ViewBinding(AddShippingAddressActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddShippingAddressActivity_ViewBinding(final AddShippingAddressActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.etUserName = Utils.findRequiredViewAsType(source, R.id.et_user_name, "field 'etUserName'", EditText.class);
    target.etUserPhone = Utils.findRequiredViewAsType(source, R.id.et_user_phone, "field 'etUserPhone'", EditText.class);
    target.etUserAddress = Utils.findRequiredViewAsType(source, R.id.et_user_address, "field 'etUserAddress'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_address_submit, "field 'btnAddressSubmit' and method 'addressSubmit'");
    target.btnAddressSubmit = Utils.castView(view, R.id.btn_address_submit, "field 'btnAddressSubmit'", Button.class);
    view2131624118 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addressSubmit();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AddShippingAddressActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.etUserName = null;
    target.etUserPhone = null;
    target.etUserAddress = null;
    target.btnAddressSubmit = null;

    view2131624140.setOnClickListener(null);
    view2131624140 = null;
    view2131624118.setOnClickListener(null);
    view2131624118 = null;
  }
}
