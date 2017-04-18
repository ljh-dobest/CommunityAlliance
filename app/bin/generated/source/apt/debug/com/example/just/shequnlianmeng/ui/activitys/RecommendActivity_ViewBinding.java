// Generated code from Butter Knife. Do not modify!
package com.example.just.shequnlianmeng.ui.activitys;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.just.shequnlianmeng.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecommendActivity_ViewBinding<T extends RecommendActivity> implements Unbinder {
  protected T target;

  @UiThread
  public RecommendActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.et_recom_name = Utils.findRequiredViewAsType(source, R.id.et_recom_name, "field 'et_recom_name'", EditText.class);
    target.et_recom_mobile = Utils.findRequiredViewAsType(source, R.id.et_recom_mobile, "field 'et_recom_mobile'", EditText.class);
    target.et_recom_creditScore = Utils.findRequiredViewAsType(source, R.id.et_recom_creditScore, "field 'et_recom_creditScore'", EditText.class);
    target.et_recom_relationship = Utils.findRequiredViewAsType(source, R.id.et_recom_relationship, "field 'et_recom_relationship'", EditText.class);
    target.et_recom_birthday = Utils.findRequiredViewAsType(source, R.id.et_recom_birthday, "field 'et_recom_birthday'", TextView.class);
    target.et_recom_school = Utils.findRequiredViewAsType(source, R.id.et_recom_school, "field 'et_recom_school'", EditText.class);
    target.et_recom_company = Utils.findRequiredViewAsType(source, R.id.et_recom_company, "field 'et_recom_company'", EditText.class);
    target.et_recom_dadName = Utils.findRequiredViewAsType(source, R.id.et_recom_dadName, "field 'et_recom_dadName'", EditText.class);
    target.et_recom_momName = Utils.findRequiredViewAsType(source, R.id.et_recom_momName, "field 'et_recom_momName'", EditText.class);
    target.et_recom_spouseName = Utils.findRequiredViewAsType(source, R.id.et_recom_spouseName, "field 'et_recom_spouseName'", EditText.class);
    target.et_recom_childrenName = Utils.findRequiredViewAsType(source, R.id.et_recom_childrenName, "field 'et_recom_childrenName'", EditText.class);
    target.et_recom_childrenSchool = Utils.findRequiredViewAsType(source, R.id.et_recom_childrenSchool, "field 'et_recom_childrenSchool'", EditText.class);
    target.rg_recom_sex = Utils.findRequiredViewAsType(source, R.id.rg_recom_sex, "field 'rg_recom_sex'", RadioGroup.class);
    target.rg_recom_like = Utils.findRequiredViewAsType(source, R.id.rg_recom_like, "field 'rg_recom_like'", RadioGroup.class);
    target.rg_recom_character = Utils.findRequiredViewAsType(source, R.id.rg_recom_character, "field 'rg_recom_character'", RadioGroup.class);
    target.rg_recom_marriage = Utils.findRequiredViewAsType(source, R.id.rg_recom_marriage, "field 'rg_recom_marriage'", RadioGroup.class);
    target.ll_recom_relationship = Utils.findRequiredViewAsType(source, R.id.ll_recom_relationship, "field 'll_recom_relationship'", LinearLayout.class);
    target.btn_recommend = Utils.findRequiredViewAsType(source, R.id.btn_recommend, "field 'btn_recommend'", Button.class);
    target.ll_recomm_marriaged = Utils.findRequiredViewAsType(source, R.id.ll_recomm_marriaged, "field 'll_recomm_marriaged'", LinearLayout.class);
    target.ll_recom_creditScore = Utils.findRequiredViewAsType(source, R.id.ll_recom_creditScore, "field 'll_recom_creditScore'", LinearLayout.class);
    target.sp_recom_province = Utils.findRequiredViewAsType(source, R.id.sp_recom_province, "field 'sp_recom_province'", Spinner.class);
    target.sp_recom_city = Utils.findRequiredViewAsType(source, R.id.sp_recom_city, "field 'sp_recom_city'", Spinner.class);
    target.sp_recom_county = Utils.findRequiredViewAsType(source, R.id.sp_recom_county, "field 'sp_recom_county'", Spinner.class);
    target.sp_recom_jgprovince = Utils.findRequiredViewAsType(source, R.id.sp_recom_jgprovince, "field 'sp_recom_jgprovince'", Spinner.class);
    target.sp_recom_jgcitys = Utils.findRequiredViewAsType(source, R.id.sp_recom_jgcitys, "field 'sp_recom_jgcitys'", Spinner.class);
    target.sp_recom_jgcountys = Utils.findRequiredViewAsType(source, R.id.sp_recom_jgcountys, "field 'sp_recom_jgcountys'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.et_recom_name = null;
    target.et_recom_mobile = null;
    target.et_recom_creditScore = null;
    target.et_recom_relationship = null;
    target.et_recom_birthday = null;
    target.et_recom_school = null;
    target.et_recom_company = null;
    target.et_recom_dadName = null;
    target.et_recom_momName = null;
    target.et_recom_spouseName = null;
    target.et_recom_childrenName = null;
    target.et_recom_childrenSchool = null;
    target.rg_recom_sex = null;
    target.rg_recom_like = null;
    target.rg_recom_character = null;
    target.rg_recom_marriage = null;
    target.ll_recom_relationship = null;
    target.btn_recommend = null;
    target.ll_recomm_marriaged = null;
    target.ll_recom_creditScore = null;
    target.sp_recom_province = null;
    target.sp_recom_city = null;
    target.sp_recom_county = null;
    target.sp_recom_jgprovince = null;
    target.sp_recom_jgcitys = null;
    target.sp_recom_jgcountys = null;

    this.target = null;
  }
}
