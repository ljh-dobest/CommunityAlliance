// Generated code from Butter Knife. Do not modify!
package com.issp.association.ui.activity;

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
import com.issp.association.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReadShareActivity_ViewBinding implements Unbinder {
  private ReadShareActivity target;

  private View view2131624110;

  private View view2131624126;

  private View view2131624129;

  @UiThread
  public ReadShareActivity_ViewBinding(ReadShareActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReadShareActivity_ViewBinding(final ReadShareActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'leftClick'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624110 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick();
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    target.ltMainTitleRight = Utils.findRequiredViewAsType(source, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.ivShareIcon = Utils.findRequiredViewAsType(source, R.id.iv_share_icon, "field 'ivShareIcon'", ImageView.class);
    target.tvShareUserName = Utils.findRequiredViewAsType(source, R.id.tv_share_user_Name, "field 'tvShareUserName'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.ivShareBtn = Utils.findRequiredViewAsType(source, R.id.iv_share_btn, "field 'ivShareBtn'", ImageView.class);
    target.tvShareBtn = Utils.findRequiredViewAsType(source, R.id.tv_share_btn, "field 'tvShareBtn'", TextView.class);
    target.ivLikeBtn = Utils.findRequiredViewAsType(source, R.id.iv_like_btn, "field 'ivLikeBtn'", ImageView.class);
    target.tvLikeBtn = Utils.findRequiredViewAsType(source, R.id.tv_like_btn, "field 'tvLikeBtn'", TextView.class);
    target.ivCommentBtn = Utils.findRequiredViewAsType(source, R.id.iv_comment_btn, "field 'ivCommentBtn'", ImageView.class);
    target.tvCommentBtn = Utils.findRequiredViewAsType(source, R.id.tv_comment_btn, "field 'tvCommentBtn'", TextView.class);
    target.ivCollectBtn = Utils.findRequiredViewAsType(source, R.id.iv_collect_btn, "field 'ivCollectBtn'", ImageView.class);
    target.tvCollectBtn = Utils.findRequiredViewAsType(source, R.id.tv_collect_btn, "field 'tvCollectBtn'", TextView.class);
    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.linearLayout, "field 'linearLayout'", LinearLayout.class);
    target.textView2 = Utils.findRequiredViewAsType(source, R.id.textView2, "field 'textView2'", TextView.class);
    target.wvContent = Utils.findRequiredViewAsType(source, R.id.wv_content, "field 'wvContent'", WebView.class);
    view = Utils.findRequiredView(source, R.id.ll_like, "field 'llLike' and method 'likeClick'");
    target.llLike = Utils.castView(view, R.id.ll_like, "field 'llLike'", LinearLayout.class);
    view2131624126 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.likeClick();
      }
    });
    target.llShare = Utils.findRequiredViewAsType(source, R.id.ll_share, "field 'llShare'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ll_comment, "field 'llComment' and method 'commentClick'");
    target.llComment = Utils.castView(view, R.id.ll_comment, "field 'llComment'", LinearLayout.class);
    view2131624129 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.commentClick();
      }
    });
    target.llCollect = Utils.findRequiredViewAsType(source, R.id.ll_collect, "field 'llCollect'", LinearLayout.class);
    target.ivImage = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'ivImage'", ImageView.class);
    target.wvCynopsis = Utils.findRequiredViewAsType(source, R.id.wv_cynopsis, "field 'wvCynopsis'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReadShareActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.tvTitle = null;
    target.ivShareIcon = null;
    target.tvShareUserName = null;
    target.tvTime = null;
    target.ivShareBtn = null;
    target.tvShareBtn = null;
    target.ivLikeBtn = null;
    target.tvLikeBtn = null;
    target.ivCommentBtn = null;
    target.tvCommentBtn = null;
    target.ivCollectBtn = null;
    target.tvCollectBtn = null;
    target.linearLayout = null;
    target.textView2 = null;
    target.wvContent = null;
    target.llLike = null;
    target.llShare = null;
    target.llComment = null;
    target.llCollect = null;
    target.ivImage = null;
    target.wvCynopsis = null;

    view2131624110.setOnClickListener(null);
    view2131624110 = null;
    view2131624126.setOnClickListener(null);
    view2131624126 = null;
    view2131624129.setOnClickListener(null);
    view2131624129 = null;
  }
}
