package com.example.just.shequnlianmeng.ui.activitys;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.bean.CityBean;
import com.example.just.shequnlianmeng.bean.CountyBean;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.bean.RecommendBean;
import com.example.just.shequnlianmeng.interfaces.IRecommedView;
import com.example.just.shequnlianmeng.presenters.RecommendPresenterImpl;
import com.example.just.shequnlianmeng.utils.T;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecommendActivity extends BaseMvpActivity<IRecommedView,RecommendPresenterImpl> implements RadioGroup.OnCheckedChangeListener,IRecommedView, View.OnClickListener, AdapterView.OnItemSelectedListener {
   private final String[] creditScores= new String[]{"100", "90", "80","70","60","50","40","30","20","10"};
    private final String[] relationships=new String[]{"亲人","情侣","同事","校友","老乡"};
    @BindView(R.id.et_recom_name)
    EditText et_recom_name;
    @BindView(R.id.et_recom_mobile)
    EditText et_recom_mobile;
    @BindView(R.id.et_recom_creditScore)
    EditText et_recom_creditScore;
    @BindView(R.id.et_recom_relationship)
    EditText et_recom_relationship;
    @BindView(R.id.et_recom_birthday)
    TextView et_recom_birthday;
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
    @BindView(R.id.et_recom_childrenName)
    EditText et_recom_childrenName;
    @BindView(R.id.et_recom_childrenSchool)
    EditText et_recom_childrenSchool;

    @BindView(R.id.rg_recom_sex)
    RadioGroup rg_recom_sex;
    @BindView(R.id.rg_recom_like)
    RadioGroup rg_recom_like;
    @BindView(R.id.rg_recom_character)
    RadioGroup rg_recom_character;
    @BindView(R.id.rg_recom_marriage)
    RadioGroup rg_recom_marriage;
    @BindView(R.id.ll_recom_relationship)
    LinearLayout ll_recom_relationship;
    @BindView(R.id.btn_recommend)
    Button btn_recommend;
    @BindView(R.id.ll_recomm_marriaged)
    LinearLayout ll_recomm_marriaged;
    @BindView(R.id.ll_recom_creditScore)
    LinearLayout ll_recom_creditScore;
    @BindView(R.id.sp_recom_province)
    Spinner sp_recom_province;
    @BindView(R.id.sp_recom_city)
    Spinner sp_recom_city;
    @BindView(R.id.sp_recom_county)
    Spinner sp_recom_county;
    @BindView(R.id.sp_recom_jgprovince)
    Spinner sp_recom_jgprovince;
    @BindView(R.id.sp_recom_jgcitys)
    Spinner sp_recom_jgcitys;
    @BindView(R.id.sp_recom_jgcountys)
    Spinner sp_recom_jgcountys;
    private String userId;
    private String fullName;
    private String mobile;
private String sex="1";
    private ArrayList<String> hobby=new ArrayList<>();
    private ArrayList<String> address=new ArrayList<>();
    private ArrayList<String> relationship=new ArrayList<>();
    private ArrayList<String> character=new ArrayList<>();
    private String creditScore;
    private String birthday;
    private String homeplace;
    private String finishSchool;
    private String company;
    private String fatherName;
    private String motherName;
    private String marriage="0";
    private String spouseName;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_recommend);
        ButterKnife.bind(this);
        presenter.getParserData(this,"data.txt");
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
        rg_recom_sex.setOnCheckedChangeListener(this);
        et_recom_birthday.setOnClickListener(this);
        btn_recommend.setOnClickListener(this);
        sp_recom_province.setOnItemSelectedListener(this);
        sp_recom_city.setOnItemSelectedListener(this);
        sp_recom_jgprovince.setOnItemSelectedListener(this);
        sp_recom_jgcitys.setOnItemSelectedListener(this);
        ll_recom_relationship.setOnClickListener(this);
        ll_recom_creditScore.setOnClickListener(this);
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
        homeplace=sp_recom_jgprovince.getSelectedItem().toString()+"省"+
                 sp_recom_jgcitys.getSelectedItem().toString()+"市"+
                 sp_recom_jgcountys.getSelectedItem().toString()+"县";
        getHobbys(rg_recom_like);
        getCharacters(rg_recom_character);
        relationship.add(et_recom_relationship.getText().toString());
        creditScore=et_recom_creditScore.getText().toString().trim();
        birthday=et_recom_birthday.getText().toString().trim();
        finishSchool=et_recom_school.getText().toString().trim();
        company=et_recom_company.getText().toString().trim();
        fatherName=et_recom_dadName.getText().toString().trim();
        motherName=et_recom_momName.getText().toString().trim();
        spouseName=et_recom_spouseName.getText().toString().trim();
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
                    //适配器
                    province_adapter = new ArrayAdapter<String>(RecommendActivity.this, android.R.layout.simple_spinner_item, options1Items);
                    //设置样式
                    province_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    //加载适配器
                    sp_recom_province.setAdapter(province_adapter);
                   sp_recom_jgprovince.setAdapter(province_adapter);
                }
            });

    }

    @Override
    public void getHobbys(ViewGroup group) {
       presenter.getHobby(group);
    }

    @Override
    public void setHobbys(List<String> hobbys) {
        hobby= (ArrayList<String>) hobbys;
    }

    @Override
    public void getCharacters(ViewGroup group) {
          presenter.getCharacters(group);
    }

    @Override
    public void setCharacters(List<String> characters) {
      character= (ArrayList<String>) characters;
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
                presenter.verifyRecommedInfo(new RecommendBean(userId,fullName,mobile,sex,hobby,address,relationship,character,
                        creditScore,birthday,homeplace,finishSchool,company,fatherName, motherName,marriage,
                        spouseName,childrenName,childrenSchool));
                break;
            case R.id.ll_recom_relationship:
                //弹出关系选择框
                android.app.AlertDialog.Builder dialog_relationship = new android.app.AlertDialog.Builder(this);
                dialog_relationship.setTitle("选择关系");
                dialog_relationship.setSingleChoiceItems(relationships, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        et_recom_relationship.setText(relationships[i]);
                        dialogInterface.dismiss();
                    }
                });
                dialog_relationship.create().show();
                break;
            case R.id.ll_recom_creditScore:
                //弹出信誉分选择框
                android.app.AlertDialog.Builder dialog_creditScore = new android.app.AlertDialog.Builder(this);
                dialog_creditScore.setTitle("选择信誉分");
                dialog_creditScore.setSingleChoiceItems(creditScores, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                          et_recom_creditScore.setText(creditScores[i]);
                        dialogInterface.dismiss();
                    }
                });
                dialog_creditScore.create().show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_recom_province:     //设置二级联动
                setSecondText(sp_recom_city, position);
                break;
            case R.id.sp_recom_city: //设置三级联动
                setThirdText(sp_recom_county,position);
                break;
            case R.id.sp_recom_jgprovince:     //设置二级联动
                setSecondText(sp_recom_jgcitys, position);
                break;
            case R.id.sp_recom_jgcitys: //设置三级联动
                setThirdText(sp_recom_jgcountys,position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}



    @Override
    public RecommendPresenterImpl initPresenter() {
        return new RecommendPresenterImpl();
    }

    //二级联动
    private void setSecondText(Spinner sp, int position) {
        options2Items.clear();
        citys = (ArrayList<CityBean>) data.get(position).getSub();
        for (int i = 0; i < citys.size(); i++) {
            options2Items.add(citys.get(i).getName());
        }
        city_adapter = new ArrayAdapter<String>(RecommendActivity.this, android.R.layout.simple_spinner_item, options2Items);
        city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(city_adapter);
    }
    //三级联动
    private void setThirdText(Spinner sp, int position) {
        options3Items.clear();
        ArrayList<CountyBean> country = (ArrayList<CountyBean>) citys.get(position).getSub();
        if (country == null) {
            options3Items.add("");
        } else {
            if(country.size()==0){
                options3Items.add("");
            }
            for (int i = 0; i < country.size(); i++) {
                options3Items.add(country.get(i).getName());
            }
        }
        county_adapter = new ArrayAdapter<String>(RecommendActivity.this, android.R.layout.simple_spinner_item, options3Items);
        county_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(county_adapter);
    }

}
