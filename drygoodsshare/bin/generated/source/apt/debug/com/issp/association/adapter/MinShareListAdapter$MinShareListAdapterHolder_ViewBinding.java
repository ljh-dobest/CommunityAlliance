// Generated code from Butter Knife. Do not modify!
package com.issp.association.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.issp.association.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MinShareListAdapter$MinShareListAdapterHolder_ViewBinding implements Unbinder {
  private MinShareListAdapter.MinShareListAdapterHolder target;

  @UiThread
  public MinShareListAdapter$MinShareListAdapterHolder_ViewBinding(MinShareListAdapter.MinShareListAdapterHolder target,
      View source) {
    this.target = target;

    target.ivShareIcon = Utils.findRequiredViewAsType(source, R.id.iv_share_icon, "field 'ivShareIcon'", ImageView.class);
    target.tvShareUserName = Utils.findRequiredViewAsType(source, R.id.tv_share_user_Name, "field 'tvShareUserName'", TextView.class);
    target.tvGoodsShare = Utils.findRequiredViewAsType(source, R.id.tv_goods_share, "field 'tvGoodsShare'", TextView.class);
    target.tvShareTitle = Utils.findRequiredViewAsType(source, R.id.tv_share_title, "field 'tvShareTitle'", TextView.class);
    target.tvShareContent = Utils.findRequiredViewAsType(source, R.id.tv_share_content, "field 'tvShareContent'", TextView.class);
    target.ivShareImg = Utils.findRequiredViewAsType(source, R.id.iv_share_img, "field 'ivShareImg'", ImageView.class);
    target.ivShareBtn = Utils.findRequiredViewAsType(source, R.id.iv_share_btn, "field 'ivShareBtn'", ImageView.class);
    target.tvShareBtn = Utils.findRequiredViewAsType(source, R.id.tv_share_btn, "field 'tvShareBtn'", TextView.class);
    target.ivLikeBtn = Utils.findRequiredViewAsType(source, R.id.iv_like_btn, "field 'ivLikeBtn'", ImageView.class);
    target.tvLikeBtn = Utils.findRequiredViewAsType(source, R.id.tv_like_btn, "field 'tvLikeBtn'", TextView.class);
    target.ivCommentBtn = Utils.findRequiredViewAsType(source, R.id.iv_comment_btn, "field 'ivCommentBtn'", ImageView.class);
    target.tvCommentBtn = Utils.findRequiredViewAsType(source, R.id.tv_comment_btn, "field 'tvCommentBtn'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MinShareListAdapter.MinShareListAdapterHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivShareIcon = null;
    target.tvShareUserName = null;
    target.tvGoodsShare = null;
    target.tvShareTitle = null;
    target.tvShareContent = null;
    target.ivShareImg = null;
    target.ivShareBtn = null;
    target.tvShareBtn = null;
    target.ivLikeBtn = null;
    target.tvLikeBtn = null;
    target.ivCommentBtn = null;
    target.tvCommentBtn = null;
  }
}
