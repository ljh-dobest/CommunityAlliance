// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.andview.refreshview.XRefreshView;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SupportProductActivity_ViewBinding implements Unbinder {
  private SupportProductActivity target;

  private View view2131624121;

  @UiThread
  public SupportProductActivity_ViewBinding(SupportProductActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SupportProductActivity_ViewBinding(final SupportProductActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624121 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.tvConfessTotal = Utils.findRequiredViewAsType(source, R.id.tv_confess_total, "field 'tvConfessTotal'", TextView.class);
    target.tvAmountTotal = Utils.findRequiredViewAsType(source, R.id.tv_amount_total, "field 'tvAmountTotal'", TextView.class);
    target.pbSchedule = Utils.findRequiredViewAsType(source, R.id.pb_schedule, "field 'pbSchedule'", ProgressBar.class);
    target.tvSchedule = Utils.findRequiredViewAsType(source, R.id.tv_schedule, "field 'tvSchedule'", TextView.class);
    target.ivSupportPeopleNumber = Utils.findRequiredViewAsType(source, R.id.iv_support_people_number, "field 'ivSupportPeopleNumber'", ImageView.class);
    target.tvSupportPeopleNumber = Utils.findRequiredViewAsType(source, R.id.tv_support_people_number, "field 'tvSupportPeopleNumber'", TextView.class);
    target.ivTimeRemaining = Utils.findRequiredViewAsType(source, R.id.iv_time_remaining, "field 'ivTimeRemaining'", ImageView.class);
    target.tvTimeRemaining = Utils.findRequiredViewAsType(source, R.id.tv_time_remaining, "field 'tvTimeRemaining'", TextView.class);
    target.recyclerViewTestRv = Utils.findRequiredViewAsType(source, R.id.recycler_view_test_rv, "field 'recyclerViewTestRv'", RecyclerView.class);
    target.xrefreshview = Utils.findRequiredViewAsType(source, R.id.xrefreshview, "field 'xrefreshview'", XRefreshView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SupportProductActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.tvConfessTotal = null;
    target.tvAmountTotal = null;
    target.pbSchedule = null;
    target.tvSchedule = null;
    target.ivSupportPeopleNumber = null;
    target.tvSupportPeopleNumber = null;
    target.ivTimeRemaining = null;
    target.tvTimeRemaining = null;
    target.recyclerViewTestRv = null;
    target.xrefreshview = null;

    view2131624121.setOnClickListener(null);
    view2131624121 = null;
  }
}
