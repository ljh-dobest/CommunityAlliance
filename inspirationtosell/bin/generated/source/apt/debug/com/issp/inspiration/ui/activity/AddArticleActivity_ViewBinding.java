// Generated code from Butter Knife. Do not modify!
package com.issp.inspiration.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.inspiration.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import java.lang.IllegalStateException;
import java.lang.Override;
import jp.wasabeef.richeditor.RichEditor;

public class AddArticleActivity_ViewBinding implements Unbinder {
  private AddArticleActivity target;

  private View view2131624080;

  private View view2131624082;

  private View view2131624083;

  private View view2131624084;

  private View view2131624085;

  private View view2131624086;

  private View view2131624087;

  private View view2131624089;

  private View view2131624090;

  private View view2131624091;

  @UiThread
  public AddArticleActivity_ViewBinding(AddArticleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddArticleActivity_ViewBinding(final AddArticleActivity target, View source) {
    this.target = target;

    View view;
    target.ivAskBack = Utils.findRequiredViewAsType(source, R.id.iv_ask_back, "field 'ivAskBack'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ll_ask_back, "field 'llAskBack' and method 'onViewClicked'");
    target.llAskBack = Utils.castView(view, R.id.ll_ask_back, "field 'llAskBack'", AutoLinearLayout.class);
    view2131624080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_ask_release, "field 'tvAskRelease' and method 'onViewClicked'");
    target.tvAskRelease = Utils.castView(view, R.id.tv_ask_release, "field 'tvAskRelease'", TextView.class);
    view2131624082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_preview, "field 'tvPreview' and method 'onViewClicked'");
    target.tvPreview = Utils.castView(view, R.id.tv_preview, "field 'tvPreview'", TextView.class);
    view2131624083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_image, "field 'tvImage' and method 'onViewClicked'");
    target.tvImage = Utils.castView(view, R.id.tv_image, "field 'tvImage'", TextView.class);
    view2131624084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.et_title, "field 'etTitle' and method 'onViewClicked'");
    target.etTitle = Utils.castView(view, R.id.et_title, "field 'etTitle'", EditText.class);
    view2131624085 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.et_content, "field 'etContent' and method 'onViewClicked'");
    target.etContent = Utils.castView(view, R.id.et_content, "field 'etContent'", RichEditor.class);
    view2131624086 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.et_deal_content, "field 'etDealContent' and method 'onViewClicked'");
    target.etDealContent = Utils.castView(view, R.id.et_deal_content, "field 'etDealContent'", RichEditor.class);
    view2131624087 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_ask_camera, "field 'ivAskCamera' and method 'onViewClicked'");
    target.ivAskCamera = Utils.castView(view, R.id.iv_ask_camera, "field 'ivAskCamera'", ImageView.class);
    view2131624089 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_ask_picture, "field 'ivAskPicture' and method 'onViewClicked'");
    target.ivAskPicture = Utils.castView(view, R.id.iv_ask_picture, "field 'ivAskPicture'", ImageView.class);
    view2131624090 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_ask_gold, "field 'ivAskGold' and method 'onViewClicked'");
    target.ivAskGold = Utils.castView(view, R.id.iv_ask_gold, "field 'ivAskGold'", ImageView.class);
    view2131624091 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llAskInsert = Utils.findRequiredViewAsType(source, R.id.ll_ask_insert, "field 'llAskInsert'", AutoLinearLayout.class);
    target.activityAsk = Utils.findRequiredViewAsType(source, R.id.activity_ask, "field 'activityAsk'", AutoRelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddArticleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivAskBack = null;
    target.llAskBack = null;
    target.tvAskRelease = null;
    target.tvPreview = null;
    target.tvImage = null;
    target.etTitle = null;
    target.etContent = null;
    target.etDealContent = null;
    target.ivAskCamera = null;
    target.ivAskPicture = null;
    target.ivAskGold = null;
    target.llAskInsert = null;
    target.activityAsk = null;

    view2131624080.setOnClickListener(null);
    view2131624080 = null;
    view2131624082.setOnClickListener(null);
    view2131624082 = null;
    view2131624083.setOnClickListener(null);
    view2131624083 = null;
    view2131624084.setOnClickListener(null);
    view2131624084 = null;
    view2131624085.setOnClickListener(null);
    view2131624085 = null;
    view2131624086.setOnClickListener(null);
    view2131624086 = null;
    view2131624087.setOnClickListener(null);
    view2131624087 = null;
    view2131624089.setOnClickListener(null);
    view2131624089 = null;
    view2131624090.setOnClickListener(null);
    view2131624090 = null;
    view2131624091.setOnClickListener(null);
    view2131624091 = null;
  }
}
