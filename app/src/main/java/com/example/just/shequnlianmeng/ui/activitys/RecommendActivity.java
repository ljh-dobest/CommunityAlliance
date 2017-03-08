package com.example.just.shequnlianmeng.ui.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.bean.CityBean;
import com.example.just.shequnlianmeng.bean.CountyBean;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.interfaces.IRecommedView;
import com.example.just.shequnlianmeng.presenters.RecommedPresenterImpl;
import com.example.just.shequnlianmeng.utils.T;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,IRecommedView, View.OnClickListener, AdapterView.OnItemSelectedListener {
    @BindView(R.id.et_recom_name)
    EditText et_recom_name;
    @BindView(R.id.et_recom_mobile)
    EditText et_recom_mobile;
    @BindView(R.id.et_recom_addressdetail)
    EditText et_recom_addressdetail;
    @BindView(R.id.et_recom_creditScore)
    EditText et_recom_creditScore;
    @BindView(R.id.et_recom_birthday)
    TextView et_recom_birthday;
    @BindView(R.id.et_recom_homeplace)
    EditText et_recom_homeplace;
    @BindView(R.id.et_recom_school)
    EditText et_recom_school;
    @BindView(R.id.et_recom_company)
    EditText et_recom_company;
    @BindView(R.id.et_recom_dadName)
    EditText et_recom_dadName;
    @BindView(R.id.et_recom_momName)
    EditText et_recom_momName;
    @BindView(R.id.et_recom_spouseName)
    EditText et_recom_spouseName;
    @BindView(R.id.et_recom_spouseAge)
    EditText et_recom_spouseAge;
    @BindView(R.id.et_recom_childrenName)
    EditText et_recom_childrenName;
    @BindView(R.id.et_recom_childrenSchool)
    EditText et_recom_childrenSchool;

    @BindView(R.id.rg_recom_sex)
    RadioGroup rg_recom_sex;
    @BindView(R.id.rg_recom_like)
    RadioGroup rg_recom_like;
    @BindView(R.id.rg_recom_marriage)
    RadioGroup rg_recom_marriage;
    @BindView(R.id.ll_recom_relationship)
    LinearLayout ll_recom_relationship;
    @BindView(R.id.btn_recommend)
    Button btn_recommend;
    @BindView(R.id.ll_recomm_marriaged)
    LinearLayout ll_recomm_marriaged;
    @BindView(R.id.sp_recom_province)
    Spinner sp_recom_province;
    @BindView(R.id.sp_recom_city)
    Spinner sp_recom_city;
    @BindView(R.id.sp_recom_county)
    Spinner sp_recom_county;
    private String userId;
    private String fullName;
    private String mobile;
    private RecommedPresenterImpl recommendPersenter;
private String sex="1";
    private ArrayList<String> hobby=new ArrayList<>();
    private List<String> address=new ArrayList<>();
    private ArrayList<String> relationship=new ArrayList<>();
    private String creditScore;
    private String birthday;
    private String homeplace;
    private String finishSchool;
    private String company;
    private String fatherName;
    private String motherName;
    private String marriage="0";
    private String spouseName;
    private String spouseAge;
    private String childrenName;
    private String childrenSchool;
    private ArrayList<String> options1Items=new ArrayList<>();
    private ArrayList<String> options2Items=new ArrayList<>();
     private ArrayList<String> options3Items=new ArrayList<>();
    private ArrayAdapter province_adapter;
    private ArrayAdapter city_adapter;
    private ArrayAdapter county_adapter;
     private ArrayList<ProvinceBean> data;
    private ArrayList<CityBean> citys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_recommend);
        ButterKnife.bind(this);
        recommendPersenter=new RecommedPresenterImpl(this);
        recommendPersenter.getParserData(this,"data.txt");
        initView();
    }

    @Override
    public void showTextEmpty() {
        T.showShort(this,"必填项不能为空！");
    }

    @Override
    public void showRecommedError(String string) {
       T.showShort(this,string);
    }

    @Override
    public void succeedToRecommed(String recommendId) {
        T.showShort(this,"推荐成功:推荐码："+recommendId);
    }

    @Override
    public void initView() {
        rg_recom_marriage.setOnCheckedChangeListener(this);
        et_recom_birthday.setOnClickListener(this);
        btn_recommend.setOnClickListener(this);
        sp_recom_province.setOnItemSelectedListener(this);
        sp_recom_city.setOnItemSelectedListener(this);
    }
      //获取控件的信息
    @Override
    public void getViewData() {
        userId="110";
        fullName=et_recom_name.getText().toString().trim();
        mobile=et_recom_mobile.getText().toString().trim();
       address.add(sp_recom_province.getSelectedItem().toString());
       address.add(sp_recom_city.getSelectedItem().toString());
       address.add(sp_recom_county.getSelectedItem().toString());
       address.add(et_recom_addressdetail.getText().toString().trim());
        getHobby();
        getRelationship();
        creditScore=et_recom_creditScore.getText().toString().trim();
        birthday=et_recom_birthday.getText().toString().trim();
        homeplace=et_recom_homeplace.getText().toString().trim();
        finishSchool=et_recom_school.getText().toString().trim();
        company=et_recom_company.getText().toString().trim();
        fatherName=et_recom_dadName.getText().toString().trim();
        motherName=et_recom_momName.getText().toString().trim();
        spouseName=et_recom_spouseName.getText().toString().trim();
        spouseAge=et_recom_spouseAge.getText().toString().trim();
        childrenName=et_recom_childrenName.getText().toString().trim();
        childrenSchool=et_recom_childrenSchool.getText().toString().trim();
    }

    //获得解析好的省市区数据
    @Override
    public void getparserData(ArrayList<ProvinceBean> province) {
               data=province;
        for (int i = 0; i < data.size(); i++) {
                options1Items.add(province.get(i).getName());
        }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    T.showShort(RecommendActivity.this,"数据已加载好");
                    //适配器
                    province_adapter = new ArrayAdapter<String>(RecommendActivity.this, android.R.layout.simple_spinner_item, options1Items);
                    //设置样式
                    province_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    //加载适配器
                    sp_recom_province.setAdapter(province_adapter);
                }
            });

    }
//获取选择的亲情
    private void getRelationship() {
            for (int j= 0; j < ll_recom_relationship.getChildCount(); j++) {
                RadioButton rb= (RadioButton) ll_recom_relationship.getChildAt(j);
                if (rb.isChecked()){
                    relationship.add(rb.getText().toString());
                }
            }
    }
 //获取选择的爱好
    private void getHobby() {
        for (int i = 0; i < rg_recom_like.getChildCount(); i++) {
            LinearLayout ll= (LinearLayout) rg_recom_like.getChildAt(i);
            for (int j= 0; j < ll.getChildCount(); j++) {
                RadioButton rb= (RadioButton) ll.getChildAt(j);
                if (rb.isChecked()){
                    hobby.add(rb.getText().toString());
                }
            }
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.rg_recom_sex://性别选项
                if(checkedId == R.id.rb_recom_man){
                    sex="1";
                }else{
                    sex="0";
                }
                break;
            case R.id.rg_recom_marriage://婚姻选项
                if(checkedId == R.id.rb_recom_unmarriage){
                    marriage="0";
                  //不显示填写婚姻信息项
                    ll_recomm_marriaged.setVisibility(View.GONE);
                }else{
                    marriage="1";
                    //显示填写婚姻信息项
                    ll_recomm_marriaged.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_recom_birthday:
             TimePickerView  pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
                        birthday = dateFormat.format(date);
                        et_recom_birthday.setText(birthday);
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.btn_recommend:
                getViewData();
                recommendPersenter.verifyRecommedInfo(userId,fullName,mobile,sex,hobby,address,relationship,creditScore,
                        birthday,homeplace,finishSchool,company,fatherName, motherName,marriage,
                        spouseName,spouseAge,childrenName,childrenSchool);
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_recom_province:     //设置二级联动
                options2Items.clear();
                citys = (ArrayList<CityBean>) data.get(position).getSub();
                for (int i = 0; i < citys.size(); i++) {
                         options2Items.add(citys.get(i).getName());
                }
                city_adapter = new ArrayAdapter<String>(RecommendActivity.this, android.R.layout.simple_spinner_item, options2Items);
                city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_recom_city.setAdapter(city_adapter);
                break;
            case R.id.sp_recom_city: //设置三级联动
                options3Items.clear();
                ArrayList<CountyBean> country= (ArrayList<CountyBean>) citys.get(position).getSub();
              if(country==null){
                  options3Items.add("");
              }else {
                  for (int i = 0; i < country.size(); i++) {
                      options3Items.add(country.get(i).getName());
                  }
              }
                county_adapter = new ArrayAdapter<String>(RecommendActivity.this, android.R.layout.simple_spinner_item, options3Items);
                county_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_recom_county.setAdapter(county_adapter);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
