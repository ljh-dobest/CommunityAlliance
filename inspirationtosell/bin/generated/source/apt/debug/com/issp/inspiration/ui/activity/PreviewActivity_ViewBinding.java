// Generated code from Butter Knife. Do not modify!
package com.issp.inspiration.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.inspiration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PreviewActivity_ViewBinding implements Unbinder {
  private PreviewActivity target;

  private View view2131624266;

  @UiThread
  public PreviewActivity_ViewBinding(PreviewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PreviewActivity_ViewBinding(final PreviewActivity target, View source) {
    this.target = target;

    View view;
    target.ltMainTitleLeft = Utils.findRequiredViewAsType(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lt_main_title_right, "field 'ltMainTitleRight' and method 'onViewClicked'");
    target.ltMainTitleRight = Utils.castView(view, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    view2131624266 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.ivImage = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'ivImage'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivDealBuyIcon = Utils.findRequiredViewAsType(source, R.id.iv_deal_buy_icon, "field 'ivDealBuyIcon'", ImageView.class);
    target.tvDealBuyUserName = Utils.findRequiredViewAsType(source, R.id.tv_deal_buy_user_Name, "field 'tvDealBuyUserName'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.wvContent = Utils.findRequiredViewAsType(source, R.id.wv_content, "field 'wvContent'", WebView.class);
    target.wvDealContent = Utils.findRequiredViewAsType(source, R.id.wv_dealContent, "field 'wvDealContent'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PreviewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.ivImage = null;
    target.tvTitle = null;
    target.ivDealBuyIcon = null;
    target.tvDealBuyUserName = null;
    target.tvTime = null;
    target.wvContent = null;
    target.wvDealContent = null;

    view2131624266.setOnClickListener(null);
    view2131624266 = null;
  }
}
