// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddSupportProjectActivity_ViewBinding implements Unbinder {
  private AddSupportProjectActivity target;

  private View view2131624137;

  private View view2131624118;

  private View view2131624115;

  @UiThread
  public AddSupportProjectActivity_ViewBinding(AddSupportProjectActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddSupportProjectActivity_ViewBinding(final AddSupportProjectActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624137 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.tvProjectTitle = Utils.findRequiredViewAsType(source, R.id.tv_project_title, "field 'tvProjectTitle'", TextView.class);
    target.tvProjectConfess = Utils.findRequiredViewAsType(source, R.id.tv_project_confess, "field 'tvProjectConfess'", TextView.class);
    target.ivShippingAddress = Utils.findRequiredViewAsType(source, R.id.iv_shipping_address, "field 'ivShippingAddress'", ImageView.class);
    target.tvShippingAddress = Utils.findRequiredViewAsType(source, R.id.tv_shipping_address, "field 'tvShippingAddress'", TextView.class);
    target.etUserName = Utils.findRequiredViewAsType(source, R.id.et_user_name, "field 'etUserName'", EditText.class);
    target.etUserPhone = Utils.findRequiredViewAsType(source, R.id.et_user_phone, "field 'etUserPhone'", EditText.class);
    target.ivZhifubao = Utils.findRequiredViewAsType(source, R.id.iv_zhifubao, "field 'ivZhifubao'", ImageView.class);
    target.ivWeixin = Utils.findRequiredViewAsType(source, R.id.iv_weixin, "field 'ivWeixin'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ll_add_address, "field 'llAddAddress' and method 'addAddress'");
    target.llAddAddress = Utils.castView(view, R.id.ll_add_address, "field 'llAddAddress'", LinearLayout.class);
    view2131624118 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addAddress();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_address_submit, "method 'addressSubmit'");
    view2131624115 = view;
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
    AddSupportProjectActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.tvProjectTitle = null;
    target.tvProjectConfess = null;
    target.ivShippingAddress = null;
    target.tvShippingAddress = null;
    target.etUserName = null;
    target.etUserPhone = null;
    target.ivZhifubao = null;
    target.ivWeixin = null;
    target.llAddAddress = null;

    view2131624137.setOnClickListener(null);
    view2131624137 = null;
    view2131624118.setOnClickListener(null);
    view2131624118 = null;
    view2131624115.setOnClickListener(null);
    view2131624115 = null;
  }
}
