// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClaimActiviy_ViewBinding<T extends ClaimActiviy> implements Unbinder {
  protected T target;

  private View view2131558718;

  private View view2131558719;

  @UiThread
  public ClaimActiviy_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.rv_calim = Utils.findRequiredViewAsType(source, R.id.rv_calim, "field 'rv_calim'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.iv_claim_back, "field 'iv_claim_back' and method 'claimViewOnCliick'");
    target.iv_claim_back = Utils.castView(view, R.id.iv_claim_back, "field 'iv_claim_back'", ImageView.class);
    view2131558718 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.claimViewOnCliick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_claim_more, "field 'iv_claim_more' and method 'claimViewOnCliick'");
    target.iv_claim_more = Utils.castView(view, R.id.iv_claim_more, "field 'iv_claim_more'", ImageView.class);
    view2131558719 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.claimViewOnCliick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rv_calim = null;
    target.iv_claim_back = null;
    target.iv_claim_more = null;

    view2131558718.setOnClickListener(null);
    view2131558718 = null;
    view2131558719.setOnClickListener(null);
    view2131558719 = null;

    this.target = null;
  }
}
