// Generated code from Butter Knife. Do not modify!
package com.issp.inspiration.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.inspiration.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReadDealBuyActivity_ViewBinding implements Unbinder {
  private ReadDealBuyActivity target;

  private View view2131624264;

  private View view2131624127;

  private View view2131624130;

  private View view2131624136;

  @UiThread
  public ReadDealBuyActivity_ViewBinding(ReadDealBuyActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReadDealBuyActivity_ViewBinding(final ReadDealBuyActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624264 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivDealBuyIcon = Utils.findRequiredViewAsType(source, R.id.iv_deal_buy_icon, "field 'ivDealBuyIcon'", ImageView.class);
    target.tvDealBuyUserName = Utils.findRequiredViewAsType(source, R.id.tv_deal_buy_user_Name, "field 'tvDealBuyUserName'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.ivShareBtn = Utils.findRequiredViewAsType(source, R.id.iv_share_btn, "field 'ivShareBtn'", ImageView.class);
    target.tvShareBtn = Utils.findRequiredViewAsType(source, R.id.tv_share_btn, "field 'tvShareBtn'", TextView.class);
    target.llShare = Utils.findRequiredViewAsType(source, R.id.ll_share, "field 'llShare'", LinearLayout.class);
    target.ivLikeBtn = Utils.findRequiredViewAsType(source, R.id.iv_like_btn, "field 'ivLikeBtn'", ImageView.class);
    target.tvLikeBtn = Utils.findRequiredViewAsType(source, R.id.tv_like_btn, "field 'tvLikeBtn'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_like, "field 'llLike' and method 'likeClick'");
    target.llLike = Utils.castView(view, R.id.ll_like, "field 'llLike'", LinearLayout.class);
    view2131624127 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.likeClick();
      }
    });
    target.ivCommentBtn = Utils.findRequiredViewAsType(source, R.id.iv_comment_btn, "field 'ivCommentBtn'", ImageView.class);
    target.tvCommentBtn = Utils.findRequiredViewAsType(source, R.id.tv_comment_btn, "field 'tvCommentBtn'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_comment, "field 'llComment' and method 'commentClick'");
    target.llComment = Utils.castView(view, R.id.ll_comment, "field 'llComment'", LinearLayout.class);
    view2131624130 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.commentClick();
      }
    });
    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.linearLayout, "field 'linearLayout'", LinearLayout.class);
    target.textView2 = Utils.findRequiredViewAsType(source, R.id.textView2, "field 'textView2'", TextView.class);
    target.llBuy = Utils.findRequiredViewAsType(source, R.id.ll_buy, "field 'llBuy'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_buy, "field 'tvBuy' and method 'buyClick'");
    target.tvBuy = Utils.castView(view, R.id.tv_buy, "field 'tvBuy'", TextView.class);
    view2131624136 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.buyClick();
      }
    });
    target.llPlay = Utils.findRequiredViewAsType(source, R.id.ll_play, "field 'llPlay'", LinearLayout.class);
    target.tvPlayTime = Utils.findRequiredViewAsType(source, R.id.tv_play_time, "field 'tvPlayTime'", TextView.class);
    target.llBuyAndPlay = Utils.findRequiredViewAsType(source, R.id.ll_buy_and_play, "field 'llBuyAndPlay'", LinearLayout.class);
    target.wvContent = Utils.findRequiredViewAsType(source, R.id.wv_content, "field 'wvContent'", WebView.class);
    target.wvPlay = Utils.findRequiredViewAsType(source, R.id.wv_play, "field 'wvPlay'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReadDealBuyActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.tvTitle = null;
    target.ivDealBuyIcon = null;
    target.tvDealBuyUserName = null;
    target.tvTime = null;
    target.ivShareBtn = null;
    target.tvShareBtn = null;
    target.llShare = null;
    target.ivLikeBtn = null;
    target.tvLikeBtn = null;
    target.llLike = null;
    target.ivCommentBtn = null;
    target.tvCommentBtn = null;
    target.llComment = null;
    target.linearLayout = null;
    target.textView2 = null;
    target.llBuy = null;
    target.tvBuy = null;
    target.llPlay = null;
    target.tvPlayTime = null;
    target.llBuyAndPlay = null;
    target.wvContent = null;
    target.wvPlay = null;

    view2131624264.setOnClickListener(null);
    view2131624264 = null;
    view2131624127.setOnClickListener(null);
    view2131624127 = null;
    view2131624130.setOnClickListener(null);
    view2131624130 = null;
    view2131624136.setOnClickListener(null);
    view2131624136 = null;
  }
}
