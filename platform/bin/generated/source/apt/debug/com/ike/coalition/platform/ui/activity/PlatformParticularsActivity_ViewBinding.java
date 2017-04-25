// Generated code from Butter Knife. Do not modify!
package com.ike.coalition.platform.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ike.coalition.platform.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlatformParticularsActivity_ViewBinding implements Unbinder {
  private PlatformParticularsActivity target;

  private View view2131624090;

  private View view2131624102;

  private View view2131624105;

  private View view2131624106;

  private View view2131624107;

  @UiThread
  public PlatformParticularsActivity_ViewBinding(PlatformParticularsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PlatformParticularsActivity_ViewBinding(final PlatformParticularsActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'onViewClicked'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624090 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ivPlatform = Utils.findRequiredViewAsType(source, R.id.iv_platform, "field 'ivPlatform'", ImageView.class);
    target.tvPlatformTitle = Utils.findRequiredViewAsType(source, R.id.tv_platform_title, "field 'tvPlatformTitle'", TextView.class);
    target.tvActivesAddress = Utils.findRequiredViewAsType(source, R.id.tv_actives_address, "field 'tvActivesAddress'", TextView.class);
    target.tvActivesTime = Utils.findRequiredViewAsType(source, R.id.tv_actives_time, "field 'tvActivesTime'", TextView.class);
    target.tvAddress = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tvAddress'", TextView.class);
    target.tvDeadline = Utils.findRequiredViewAsType(source, R.id.tv_deadline, "field 'tvDeadline'", TextView.class);
    target.tvCostMoney = Utils.findRequiredViewAsType(source, R.id.tv_cost_money, "field 'tvCostMoney'", TextView.class);
    target.tvDescription = Utils.findRequiredViewAsType(source, R.id.tv_description, "field 'tvDescription'", TextView.class);
    target.wvContent = Utils.findRequiredViewAsType(source, R.id.wv_content, "field 'wvContent'", WebView.class);
    target.tvJoinUsersNumber = Utils.findRequiredViewAsType(source, R.id.tv_join_users_number, "field 'tvJoinUsersNumber'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_more, "field 'tvMore' and method 'onViewClicked'");
    target.tvMore = Utils.castView(view, R.id.tv_more, "field 'tvMore'", TextView.class);
    view2131624102 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.gvUser = Utils.findRequiredViewAsType(source, R.id.gv_user, "field 'gvUser'", GridView.class);
    target.ivShare = Utils.findRequiredViewAsType(source, R.id.iv_share, "field 'ivShare'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.iv_like, "field 'ivLike', method 'onClick', and method 'onViewClicked'");
    target.ivLike = Utils.castView(view, R.id.iv_like, "field 'ivLike'", ImageView.class);
    view2131624105 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_comment_btn, "field 'ivCommentBtn' and method 'onViewClicked'");
    target.ivCommentBtn = Utils.castView(view, R.id.iv_comment_btn, "field 'ivCommentBtn'", ImageView.class);
    view2131624106 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_add_register, "field 'tvAddRegister' and method 'onViewClicked'");
    target.tvAddRegister = Utils.castView(view, R.id.tv_add_register, "field 'tvAddRegister'", TextView.class);
    view2131624107 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llHandle = Utils.findRequiredViewAsType(source, R.id.ll_handle, "field 'llHandle'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlatformParticularsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ivPlatform = null;
    target.tvPlatformTitle = null;
    target.tvActivesAddress = null;
    target.tvActivesTime = null;
    target.tvAddress = null;
    target.tvDeadline = null;
    target.tvCostMoney = null;
    target.tvDescription = null;
    target.wvContent = null;
    target.tvJoinUsersNumber = null;
    target.tvMore = null;
    target.gvUser = null;
    target.ivShare = null;
    target.ivLike = null;
    target.ivCommentBtn = null;
    target.tvAddRegister = null;
    target.llHandle = null;

    view2131624090.setOnClickListener(null);
    view2131624090 = null;
    view2131624102.setOnClickListener(null);
    view2131624102 = null;
    view2131624105.setOnClickListener(null);
    view2131624105 = null;
    view2131624106.setOnClickListener(null);
    view2131624106 = null;
    view2131624107.setOnClickListener(null);
    view2131624107 = null;
  }
}
