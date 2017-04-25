// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddCrowdFundingActivity_ViewBinding implements Unbinder {
  private AddCrowdFundingActivity target;

  private View view2131624139;

  private View view2131624094;

  private View view2131624106;

  private View view2131624093;

  private View view2131624108;

  @UiThread
  public AddCrowdFundingActivity_ViewBinding(AddCrowdFundingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddCrowdFundingActivity_ViewBinding(final AddCrowdFundingActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'onViewClicked'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624139 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_imgage, "field 'tvImgage' and method 'onViewClicked'");
    target.tvImgage = Utils.castView(view, R.id.tv_imgage, "field 'tvImgage'", TextView.class);
    view2131624094 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rbProduct = Utils.findRequiredViewAsType(source, R.id.rb_product, "field 'rbProduct'", RadioButton.class);
    target.rbSeekHelp = Utils.findRequiredViewAsType(source, R.id.rb_seek_help, "field 'rbSeekHelp'", RadioButton.class);
    target.rgType = Utils.findRequiredViewAsType(source, R.id.rg_type, "field 'rgType'", RadioGroup.class);
    target.etTitle = Utils.findRequiredViewAsType(source, R.id.et_title, "field 'etTitle'", EditText.class);
    target.etObjective = Utils.findRequiredViewAsType(source, R.id.et_objective, "field 'etObjective'", EditText.class);
    target.etCapital = Utils.findRequiredViewAsType(source, R.id.et_capital, "field 'etCapital'", EditText.class);
    target.tvProductDays = Utils.findRequiredViewAsType(source, R.id.tv_product_days, "field 'tvProductDays'", TextView.class);
    target.tvDays = Utils.findRequiredViewAsType(source, R.id.tv_days, "field 'tvDays'", TextView.class);
    target.etDays = Utils.findRequiredViewAsType(source, R.id.et_days, "field 'etDays'", EditText.class);
    view = Utils.findRequiredView(source, R.id.ll_product_content, "field 'llProductContent' and method 'onViewClicked'");
    target.llProductContent = Utils.castView(view, R.id.ll_product_content, "field 'llProductContent'", LinearLayout.class);
    view2131624106 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llProductCommodity = Utils.findRequiredViewAsType(source, R.id.ll_product_commodity, "field 'llProductCommodity'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_submit, "field 'tvSubmit' and method 'onViewClicked'");
    target.tvSubmit = Utils.castView(view, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
    view2131624093 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_add_commodity, "field 'ivAddCommodity' and method 'onViewClicked'");
    target.ivAddCommodity = Utils.castView(view, R.id.iv_add_commodity, "field 'ivAddCommodity'", ImageView.class);
    view2131624108 = view;
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
    AddCrowdFundingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.tvImgage = null;
    target.rbProduct = null;
    target.rbSeekHelp = null;
    target.rgType = null;
    target.etTitle = null;
    target.etObjective = null;
    target.etCapital = null;
    target.tvProductDays = null;
    target.tvDays = null;
    target.etDays = null;
    target.llProductContent = null;
    target.llProductCommodity = null;
    target.tvSubmit = null;
    target.ivAddCommodity = null;

    view2131624139.setOnClickListener(null);
    view2131624139 = null;
    view2131624094.setOnClickListener(null);
    view2131624094 = null;
    view2131624106.setOnClickListener(null);
    view2131624106 = null;
    view2131624093.setOnClickListener(null);
    view2131624093 = null;
    view2131624108.setOnClickListener(null);
    view2131624108 = null;
  }
}
