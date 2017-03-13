package com.example.just.shequnlianmeng.ui.activitys;

import android.content.Intent;
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
import com.example.just.shequnlianmeng.bean.ClaimInfoBean;
import com.example.just.shequnlianmeng.bean.CountyBean;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.interfaces.IClaimInfoView;
import com.example.just.shequnlianmeng.presenters.ClaimInfoPresenter;
import com.example.just.shequnlianmeng.utils.LoadDialog;
import com.example.just.shequnlianmeng.utils.T;
import com.makeramen.roundedimageview.RoundedImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClaimInfoActivity extends BaseMvpActivity<IClaimInfoView,ClaimInfoPresenter> implements IClaimInfoView, RadioGroup.OnCheckedChangeListener, View.OnClickListener, AdapterView.OnItemSelectedListener {
@BindView(R.id.tv_claim_back)
    TextView tv_claim_back;
    @BindView(R.id.iv_claim_userHeader)
    RoundedImageView iv_claim_userHeader;
    @BindView(R.id.tv_claiminfo_othername)
    TextView tv_claiminfo_othername;
    @BindView(R.id.et_claiminfo_username)
    EditText et_claiminfo_username;
    @BindView(R.id.et_claiminfo_mobile)
    EditText et_claiminfo_mobile;
    @BindView(R.id.rg_claimInfo_sex)
    RadioGroup rg_claimInfo_sex;
    @BindView(R.id.rg_claimInfo_like)
    RadioGroup rg_claimInfo_like;
    @BindView(R.id.sp_claimInfo_province)
    Spinner sp_claimInfo_province;
    @BindView(R.id.sp_claimInfo_citys)
    Spinner sp_claimInfo_citys;
    @BindView(R.id.sp_claimInfo_countys)
    Spinner sp_claimInfo_countys;
    @BindView(R.id.et_claiminfo_relationship)
    EditText et_claiminfo_relationship;
    @BindView(R.id.et_claiminfo_creditScore)
    EditText et_claiminfo_creditScore;
    @BindView(R.id.et_claiminfo_birthday)
    EditText et_claiminfo_birthday;
    @BindView(R.id.sp_claimInfo_jgprovince)
    Spinner sp_claimInfo_jgprovince;
    @BindView(R.id.sp_claimInfo_jgcitys)
    Spinner sp_claimInfo_jgcitys;
    @BindView(R.id.sp_claimInfo_jgcountys)
    Spinner sp_claimInfo_jgcountys;
    @BindView(R.id.et_claiminfo_finishSchool)
    EditText et_claiminfo_finishSchool;
    @BindView(R.id.et_claiminfo_company)
    EditText et_claiminfo_company;
    @BindView(R.id.et_claiminfo_position)
    EditText et_claiminfo_position;
    @BindView(R.id.et_claiminfo_email)
    EditText et_claiminfo_email;
    @BindView(R.id.et_claiminfo_QQ)
    EditText et_claiminfo_QQ;
    @BindView(R.id.et_claiminfo_wechat)
    EditText et_claiminfo_wechat;
    @BindView(R.id.btn_verifyclaim)
    Button btn_verifyclaim;
    @BindView(R.id.ll_claiminfo_birthday)
    LinearLayout ll_claiminfo_birthday;
    private String userId;
    private String claimUserId;
    private String fullName;
    private String mobile;
    private String sex="1";
    private ArrayList<String> hobby=new ArrayList<>();
    private ArrayList<String> address=new ArrayList<>();
    private ArrayList<String> relationship=new ArrayList<>();
    private String creditScore;
    private String birthday;
    private String homeplace;
    private String finishSchool;
    private String degree;
    private String company;
    private String position;
    private String email;
    private String QQ;
    private String wechat;
    private ArrayList<String> options1Items=new ArrayList<>();
    private ArrayList<String> options2Items=new ArrayList<>();
    private ArrayList<String> options3Items=new ArrayList<>();
    private ArrayAdapter province_adapter;
    private ArrayAdapter city_adapter;
    private ArrayAdapter county_adapter;
    private ArrayList<ProvinceBean> data;
    private ArrayList<CityBean> citys;
    private ClaimInfoBean claimInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_info);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        claimUserId=intent.getStringExtra("claimUserId");
        if(claimInfo==null){
            claimUserId="112232";
        }
        presenter.getParserData(this,"data.txt");
        initView();
    }

    private void initView() {
        rg_claimInfo_sex.setOnCheckedChangeListener(this);
        et_claiminfo_birthday.setOnClickListener(this);
        btn_verifyclaim.setOnClickListener(this);
        sp_claimInfo_province.setOnItemSelectedListener(this);
        sp_claimInfo_jgprovince.setOnItemSelectedListener(this);
        sp_claimInfo_citys.setOnItemSelectedListener(this);
        sp_claimInfo_jgcitys.setOnItemSelectedListener(this);
        ll_claiminfo_birthday.setOnClickListener(this);
        tv_claim_back.setOnClickListener(this);
    }


    @Override
    public ClaimInfoPresenter initPresenter() {
        return new ClaimInfoPresenter();
    }

    @Override
    public void showTextEmpty() {
        T.showShort(this,"必填项不能为空");
    }

    @Override
    public void showSucceedClaim() {
    T.showShort(this,"认领成功");
    }

    @Override
    public void getHobbys(ViewGroup group) {
          presenter.getHobbys(group);
    }

    @Override
    public void setHobbys(ArrayList<String> hobbys) {
        hobby=hobbys;
    }

    @Override
    public void setprovinceData(ArrayList<ProvinceBean> data) {
        this.data=data;
        for (int i = 0; i < data.size(); i++) {
            options1Items.add(data.get(i).getName());
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //适配器
                province_adapter = new ArrayAdapter<String>(ClaimInfoActivity.this, android.R.layout.simple_spinner_item, options1Items);
                //设置样式
                province_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //加载适配器
                sp_claimInfo_province.setAdapter(province_adapter);
                sp_claimInfo_jgprovince.setAdapter(province_adapter);
            }
        });
    }

    @Override
    public void showLoading() {
        LoadDialog.show(this);
    }

    @Override
    public void hideLoading() {
        LoadDialog.dismiss(this);
    }

    @Override
    public void showError(String errorString) {
        T.showShort(this,errorString);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.rg_claimInfo_sex://性别选项
                if(checkedId == R.id.rg_claimInfo_sex){
                    sex="1";
                }else{
                    sex="0";
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_claiminfo_birthday:
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
                        birthday = dateFormat.format(date);
                        et_claiminfo_birthday.setText(birthday);
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.btn_verifyclaim:
                getViewData();
                presenter.postClaimPeopleInfo(claimInfo);
                break;
            case R.id.tv_claim_back:
              finish();
                break;
        }
    }

    private void getViewData() {
        address.clear();
        relationship.clear();
        userId="110";
        fullName=et_claiminfo_username.getText().toString();
        mobile=et_claiminfo_mobile.getText().toString();
        getHobbys(rg_claimInfo_like);
        address.add(sp_claimInfo_province.getSelectedItem().toString());
        address.add(sp_claimInfo_citys.getSelectedItem().toString());
        String county=(sp_claimInfo_countys.getSelectedItem().toString());
        address.add(county);
        creditScore=et_claiminfo_creditScore.getText().toString();
        relationship.add(et_claiminfo_relationship.getText().toString());
        birthday=et_claiminfo_birthday.getText().toString();
        homeplace=sp_claimInfo_jgprovince.getSelectedItem().toString()
                  +sp_claimInfo_jgcitys.getSelectedItem().toString()
                  +sp_claimInfo_jgcountys.getSelectedItem().toString();
        finishSchool=et_claiminfo_finishSchool.getText().toString();
        degree="1";
        company=et_claiminfo_company.getText().toString();
        position=et_claiminfo_position.getText().toString();
        email=et_claiminfo_email.getText().toString();
        QQ=et_claiminfo_QQ.getText().toString();
        wechat=et_claiminfo_wechat.getText().toString();
        claimInfo=new ClaimInfoBean( userId,claimUserId,fullName,mobile,sex,
                hobby, address, creditScore,relationship,birthday,homeplace,finishSchool,
                degree, company, position,email,QQ,wechat);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_claimInfo_province:     //设置二级联动
                setSecondText(sp_claimInfo_citys, position);
                break;
            case R.id.sp_claimInfo_citys: //设置三级联动
                setThirdText(sp_claimInfo_countys,position);
                break;
            case R.id.sp_claimInfo_jgprovince:     //设置二级联动
                setSecondText(sp_claimInfo_jgcitys, position);
                break;
            case R.id.sp_claimInfo_jgcitys: //设置三级联动
                setThirdText(sp_claimInfo_jgcountys,position);
                break;
        }
    }
    private void setSecondText(Spinner sp, int position) {
        options2Items.clear();
        citys = (ArrayList<CityBean>) data.get(position).getSub();
        for (int i = 0; i < citys.size(); i++) {
            options2Items.add(citys.get(i).getName());
        }
        city_adapter = new ArrayAdapter<String>(ClaimInfoActivity.this, android.R.layout.simple_spinner_item, options2Items);
        city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(city_adapter);
    }

    private void setThirdText(Spinner sp, int position) {
        options3Items.clear();
        ArrayList<CountyBean> country = (ArrayList<CountyBean>) citys.get(position).getSub();
        if (country == null) {
            options3Items.add(" ");
        } else {
            for (int i = 0; i < country.size(); i++) {
                options3Items.add(country.get(i).getName());
            }
        }
        county_adapter = new ArrayAdapter<String>(ClaimInfoActivity.this, android.R.layout.simple_spinner_item, options3Items);
        county_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(county_adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    }
