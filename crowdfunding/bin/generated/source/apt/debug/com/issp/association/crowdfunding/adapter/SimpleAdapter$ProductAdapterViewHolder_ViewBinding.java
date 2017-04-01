// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SimpleAdapter$ProductAdapterViewHolder_ViewBinding implements Unbinder {
  private SimpleAdapter.ProductAdapterViewHolder target;

  @UiThread
  public SimpleAdapter$ProductAdapterViewHolder_ViewBinding(SimpleAdapter.ProductAdapterViewHolder target,
      View source) {
    this.target = target;

    target.ivProductIcon = Utils.findRequiredViewAsType(source, R.id.iv_product_icon, "field 'ivProductIcon'", ImageView.class);
    target.tvProductUserName = Utils.findRequiredViewAsType(source, R.id.tv_product_user_Name, "field 'tvProductUserName'", TextView.class);
    target.tvGoodsProduct = Utils.findRequiredViewAsType(source, R.id.tv_goods_product, "field 'tvGoodsProduct'", TextView.class);
    target.ivProductImg = Utils.findRequiredViewAsType(source, R.id.iv_product_img, "field 'ivProductImg'", ImageView.class);
    target.tvSurplusDate = Utils.findRequiredViewAsType(source, R.id.tv_surplus_date, "field 'tvSurplusDate'", TextView.class);
    target.tvProductTitle = Utils.findRequiredViewAsType(source, R.id.tv_product_title, "field 'tvProductTitle'", TextView.class);
    target.tvProductContent = Utils.findRequiredViewAsType(source, R.id.tv_product_content, "field 'tvProductContent'", TextView.class);
    target.tvConfessTotal = Utils.findRequiredViewAsType(source, R.id.tv_confess_total, "field 'tvConfessTotal'", TextView.class);
    target.tvAmountTotal = Utils.findRequiredViewAsType(source, R.id.tv_amount_total, "field 'tvAmountTotal'", TextView.class);
    target.pbSchedule = Utils.findRequiredViewAsType(source, R.id.pb_schedule, "field 'pbSchedule'", ProgressBar.class);
    target.tvSchedule = Utils.findRequiredViewAsType(source, R.id.tv_schedule, "field 'tvSchedule'", TextView.class);
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
    SimpleAdapter.ProductAdapterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivProductIcon = null;
    target.tvProductUserName = null;
    target.tvGoodsProduct = null;
    target.ivProductImg = null;
    target.tvSurplusDate = null;
    target.tvProductTitle = null;
    target.tvProductContent = null;
    target.tvConfessTotal = null;
    target.tvAmountTotal = null;
    target.pbSchedule = null;
    target.tvSchedule = null;
    target.ivShareBtn = null;
    target.tvShareBtn = null;
    target.ivLikeBtn = null;
    target.tvLikeBtn = null;
    target.ivCommentBtn = null;
    target.tvCommentBtn = null;
  }
}
