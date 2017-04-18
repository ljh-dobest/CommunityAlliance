// Generated code from Butter Knife. Do not modify!
package com.issp.inspiration.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.inspiration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DealBuyConfirmOrderActivity_ViewBinding implements Unbinder {
  private DealBuyConfirmOrderActivity target;

  private View view2131624196;

  private View view2131624103;

  @UiThread
  public DealBuyConfirmOrderActivity_ViewBinding(DealBuyConfirmOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DealBuyConfirmOrderActivity_ViewBinding(final DealBuyConfirmOrderActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624196 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.ivDealBuyIcon = Utils.findRequiredViewAsType(source, R.id.iv_deal_buy_icon, "field 'ivDealBuyIcon'", ImageView.class);
    target.tvDealBuyTitle = Utils.findRequiredViewAsType(source, R.id.tv_deal_buy_title, "field 'tvDealBuyTitle'", TextView.class);
    target.ivDealContribution = Utils.findRequiredViewAsType(source, R.id.iv_deal_Contribution, "field 'ivDealContribution'", ImageView.class);
    target.tvDealContribution = Utils.findRequiredViewAsType(source, R.id.tv_deal_Contribution, "field 'tvDealContribution'", TextView.class);
    target.textView6 = Utils.findRequiredViewAsType(source, R.id.textView6, "field 'textView6'", TextView.class);
    target.tvDealContributionTotal = Utils.findRequiredViewAsType(source, R.id.tv_deal_Contribution_total, "field 'tvDealContributionTotal'", TextView.class);
    target.imageView2 = Utils.findRequiredViewAsType(source, R.id.imageView2, "field 'imageView2'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.tv_buy_button, "field 'tvBuyButton' and method 'buyClick'");
    target.tvBuyButton = Utils.castView(view, R.id.tv_buy_button, "field 'tvBuyButton'", TextView.class);
    view2131624103 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.buyClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DealBuyConfirmOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.ivDealBuyIcon = null;
    target.tvDealBuyTitle = null;
    target.ivDealContribution = null;
    target.tvDealContribution = null;
    target.textView6 = null;
    target.tvDealContributionTotal = null;
    target.imageView2 = null;
    target.tvBuyButton = null;

    view2131624196.setOnClickListener(null);
    view2131624196 = null;
    view2131624103.setOnClickListener(null);
    view2131624103 = null;
  }
}
