// Generated code from Butter Knife. Do not modify!
package com.issp.association.crowdfunding.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.issp.association.crowdfunding.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.lang.IllegalStateException;
import java.lang.Override;
import jp.wasabeef.richeditor.RichEditor;

public class GraphicDetailsActivity_ViewBinding implements Unbinder {
  private GraphicDetailsActivity target;

  private View view2131624145;

  private View view2131624285;

  private View view2131624138;

  private View view2131624139;

  @UiThread
  public GraphicDetailsActivity_ViewBinding(GraphicDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GraphicDetailsActivity_ViewBinding(final GraphicDetailsActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lt_main_title_left, "field 'ltMainTitleLeft' and method 'onViewClicked'");
    target.ltMainTitleLeft = Utils.castView(view, R.id.lt_main_title_left, "field 'ltMainTitleLeft'", TextView.class);
    view2131624145 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ltMainTitle = Utils.findRequiredViewAsType(source, R.id.lt_main_title, "field 'ltMainTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lt_main_title_right, "field 'ltMainTitleRight' and method 'onViewClicked'");
    target.ltMainTitleRight = Utils.castView(view, R.id.lt_main_title_right, "field 'ltMainTitleRight'", TextView.class);
    view2131624285 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etContent = Utils.findRequiredViewAsType(source, R.id.et_content, "field 'etContent'", RichEditor.class);
    view = Utils.findRequiredView(source, R.id.iv_ask_camera, "field 'ivAskCamera' and method 'onViewClicked'");
    target.ivAskCamera = Utils.castView(view, R.id.iv_ask_camera, "field 'ivAskCamera'", ImageView.class);
    view2131624138 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_ask_picture, "field 'ivAskPicture' and method 'onViewClicked'");
    target.ivAskPicture = Utils.castView(view, R.id.iv_ask_picture, "field 'ivAskPicture'", ImageView.class);
    view2131624139 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llAskInsert = Utils.findRequiredViewAsType(source, R.id.ll_ask_insert, "field 'llAskInsert'", AutoLinearLayout.class);
    target.llInsert = Utils.findRequiredViewAsType(source, R.id.ll_insert, "field 'llInsert'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GraphicDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ltMainTitleLeft = null;
    target.ltMainTitle = null;
    target.ltMainTitleRight = null;
    target.etContent = null;
    target.ivAskCamera = null;
    target.ivAskPicture = null;
    target.llAskInsert = null;
    target.llInsert = null;

    view2131624145.setOnClickListener(null);
    view2131624145 = null;
    view2131624285.setOnClickListener(null);
    view2131624285 = null;
    view2131624138.setOnClickListener(null);
    view2131624138 = null;
    view2131624139.setOnClickListener(null);
    view2131624139 = null;
  }
}
