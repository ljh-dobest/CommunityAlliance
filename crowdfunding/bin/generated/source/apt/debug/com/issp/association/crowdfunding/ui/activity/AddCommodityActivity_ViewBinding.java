// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddCommodityActivity_ViewBinding implements Unbinder {
  private AddCommodityActivity target;

  private View view2131624140;

  private View view2131624098;

  private View view2131624099;

  @UiThread
  public AddCommodityActivity_ViewBinding(AddCommodityActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddCommodityActivity_ViewBinding(final AddCommodityActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'onViewClicked'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.etCommodityTitle = Utils.findRequiredViewAsType(source, R.id.et_commodity_title, "field 'etCommodityTitle'", EditText.class);
    target.etCommoditySupportMoney = Utils.findRequiredViewAsType(source, R.id.et_commodity_support_money, "field 'etCommoditySupportMoney'", EditText.class);
    view = Utils.findRequiredView(source, R.id.ll_commodity_content, "field 'llCommodityContent' and method 'onViewClicked'");
    target.llCommodityContent = Utils.castView(view, R.id.ll_commodity_content, "field 'llCommodityContent'", LinearLayout.class);
    view2131624098 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
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
    AddCommodityActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.etCommodityTitle = null;
    target.etCommoditySupportMoney = null;
    target.llCommodityContent = null;
    target.tvSubmit = null;

    view2131624140.setOnClickListener(null);
    view2131624140 = null;
    view2131624098.setOnClickListener(null);
    view2131624098 = null;
    view2131624099.setOnClickListener(null);
    view2131624099 = null;
  }
}
