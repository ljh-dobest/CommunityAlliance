// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductIDCardActivity_ViewBinding implements Unbinder {
  private ProductIDCardActivity target;

  private View view2131624145;

  private View view2131624099;

  @UiThread
  public ProductIDCardActivity_ViewBinding(ProductIDCardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductIDCardActivity_ViewBinding(final ProductIDCardActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'onViewClicked'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624145 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.etUserName = Utils.findRequiredViewAsType(source, R.id.et_userName, "field 'etUserName'", EditText.class);
    target.etIdcard = Utils.findRequiredViewAsType(source, R.id.et_idcard, "field 'etIdcard'", EditText.class);
    target.etMobile = Utils.findRequiredViewAsType(source, R.id.et_mobile, "field 'etMobile'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'tvSubmit' and method 'onViewClicked'");
    target.tvSubmit = Utils.castView(view, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
    view2131624099 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductIDCardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.etUserName = null;
    target.etIdcard = null;
    target.etMobile = null;
    target.tvSubmit = null;

    view2131624145.setOnClickListener(null);
    view2131624145 = null;
    view2131624099.setOnClickListener(null);
    view2131624099 = null;
  }
}
