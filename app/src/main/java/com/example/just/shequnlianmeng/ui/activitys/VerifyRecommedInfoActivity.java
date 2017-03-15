package com.example.just.shequnlianmeng.ui.activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.bigkoo.pickerview.TimePickerView;
import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseMvpActivity;
import com.example.just.shequnlianmeng.bean.CityBean;
import com.example.just.shequnlianmeng.bean.CountyBean;
import com.example.just.shequnlianmeng.bean.ProvinceBean;
import com.example.just.shequnlianmeng.bean.VerifyRecommedInfoBean;
import com.example.just.shequnlianmeng.interfaces.IVerifyRecommedInfoView;
import com.example.just.shequnlianmeng.presenters.VerifyRecommedInfoPresenter;
import com.example.just.shequnlianmeng.utils.T;
import com.suke.widget.SwitchButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerifyRecommedInfoActivity extends BaseMvpActivity<IVerifyRecommedInfoView,VerifyRecommedInfoPresenter>implements IVerifyRecommedInfoView, RadioGroup.OnCheckedChangeListener, View.OnClickListener, AdapterView.OnItemSelectedListener {
private final String[] degrees={"初中","高中","中技","中专","大专","本科","硕士","博士","MBA","EMBA","其他"};
    @BindView(R.id.et_verifyInfo_username)
    EditText et_verifyInfo_username;
    @BindView(R.id.et_verifyInfo_mobile)
    EditText et_verifyInfo_mobile;
    @BindView(R.id.rg_verifyInfo_sex)
    RadioGroup rg_verifyInfo_sex;
    @BindView(R.id.rg_verifyInfo_like)
    RadioGroup rg_verifyInfo_like;
    @BindView(R.id.sp_verifyInfo_province)
    Spinner sp_verifyInfo_province;
    @BindView(R.id.sp_verifyInfo_citys)
    Spinner sp_verifyInfo_citys;
    @BindView(R.id.sp_verifyInfo_countys)
    Spinner sp_verifyInfo_countys;
    @BindView(R.id.et_verifyInfo_birthday)
    EditText et_verifyInfo_birthday;
    @BindView(R.id.sp_verifyInfo_jgprovince)
    Spinner sp_verifyInfo_jgprovince;
    @BindView(R.id.sp_verifyInfo_jgcitys)
    Spinner sp_verifyInfo_jgcitys;
    @BindView(R.id.sp_verifyInfo_jgcountys)
    Spinner sp_verifyInfo_jgcountys;
    @BindView(R.id.et_verifyInfo_finishSchool)
    EditText et_verifyInfo_finishSchool;
    @BindView(R.id.et_verifyInfo_degree)
    EditText et_verifyInfo_degree;
    @BindView(R.id.et_verifyInfo_company)
    EditText et_verifyInfo_company;
    @BindView(R.id.et_verifyInfo_position)
    EditText et_verifyInfo_position;
    @BindView(R.id.et_verifyInfo_email)
    EditText et_verifyInfo_email;
    @BindView(R.id.et_verifyInfo_QQ)
    EditText et_verifyInfo_QQ;
    @BindView(R.id.et_verifyInfo_wechat)
    EditText et_verifyInfo_wechat;
    @BindView(R.id.btn_verifyRecommedInfo)
    Button btn_verifyRecommedInfo;
    @BindView(R.id.ll_verifyInfo_birthday)
    LinearLayout ll_verifyInfo_birthday;
    @BindView(R.id.sw_verifyInfo_showname)
    SwitchButton sw_verifyInfo_showname;
    private String userId;
    private String fullName;
    private String mobile;
    private String SfullName="0";
    private String sex="1";
    private ArrayList<String> hobby=new ArrayList<>();
    private ArrayList<String> address=new ArrayList<>();
    private String birthday;
    private String homeplace;
    private String finishSchool;
    private String company;
    private String position;
    private String email;
    private String QQ;
    private String wechat;
    private ArrayList<String> provinceList=new ArrayList<>();
    private ArrayList<String>  cityList=new ArrayList<>();
    private ArrayList<String> countyList=new ArrayList<>();
    private ArrayList<String> jgcityList=new ArrayList<>();
    private ArrayList<String> jgcountyList=new ArrayList<>();
    private ArrayAdapter province_adapter;
    private ArrayAdapter city_adapter;
    private ArrayAdapter county_adapter;
    private ArrayList<ProvinceBean> data;
    private ArrayList<CityBean> citys;
    private VerifyRecommedInfoBean verifyRecommedInfo;
    private String curDegreeCode="0";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_recommed_info);
        ButterKnife.bind(this);
        presenter.parserData(this,"data.txt");
        initView();
    }

    private void initView() {
        rg_verifyInfo_sex.setOnCheckedChangeListener(this);
        et_verifyInfo_birthday.setOnClickListener(this);
        btn_verifyRecommedInfo.setOnClickListener(this);
        sp_verifyInfo_province.setOnItemSelectedListener(this);
        sp_verifyInfo_jgprovince.setOnItemSelectedListener(this);
        sp_verifyInfo_citys.setOnItemSelectedListener(this);
        sp_verifyInfo_jgcitys.setOnItemSelectedListener(this);
        ll_verifyInfo_birthday.setOnClickListener(this);
        et_verifyInfo_degree.setOnClickListener(this);
        sw_verifyInfo_showname.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if(isChecked){
                    SfullName="1";
                }else{
                    SfullName="0";
                }
            }
        });
    }


    @Override
    public VerifyRecommedInfoPresenter initPresenter() {
        return new VerifyRecommedInfoPresenter();
    }

    @Override
    public void showTextEmpty() {
       T.showShort(this,"必填项不能空");
    }

    @Override
    public void showVerifyInfoError(String string) {
        T.showShort(this,string);
    }

    @Override
    public void succeedVerifyInfo() {
        T.showShort(this,"信息确认完成");
    }

    @Override
    public void showComfirmDialog() {
        final AlertDialog ComfirmDialog = new AlertDialog.Builder(this).create();
        ComfirmDialog.show();
        Window window = ComfirmDialog.getWindow();
        window.setContentView(R.layout.comfirm_dialog_layout);
        Button btn_comfirm_dialog_comfirm = (Button) window.findViewById(R.id.btn_comfirm_dialog_comfirm);
        ImageView iv_comfirm_dialog_cancel= (ImageView) window.findViewById(R.id.iv_comfirm_dialog_cancel);
       btn_comfirm_dialog_comfirm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getViewData();
               presenter.postVerifyRecommedInfo(verifyRecommedInfo);
               ComfirmDialog.dismiss();
           }
       });
        iv_comfirm_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComfirmDialog.dismiss();
            }
        });
    }

    @Override
    public void setHobby(ArrayList<String> hobbys) {
        this.hobby=hobbys;
    }

    @Override
    public void setProvinceData(ArrayList<ProvinceBean> provinceData) {
        this.data=provinceData;
        for (int i = 0; i < data.size(); i++) {
            provinceList.add(data.get(i).getName());
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //适配器
                province_adapter = new ArrayAdapter<String>(VerifyRecommedInfoActivity.this, android.R.layout.simple_spinner_item, provinceList);
                //设置样式
                province_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //加载适配器
                sp_verifyInfo_province.setAdapter(province_adapter);
                sp_verifyInfo_jgprovince.setAdapter(province_adapter);
            }
        });
    }

    @Override
    public void getHobby(ViewGroup group) {
        presenter.getHobby(group);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.rg_verifyInfo_sex://性别选项
                if(checkedId ==R.id.rb_verifyInfo_man){
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
            case R.id.ll_verifyInfo_birthday:
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
                        birthday = dateFormat.format(date);
                        et_verifyInfo_birthday.setText(birthday);
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.btn_verifyRecommedInfo:
                    showComfirmDialog();
                break;
            case R.id.et_verifyInfo_degree:
                //选择学历
                android.app.AlertDialog.Builder dialog_creditScore = new android.app.AlertDialog.Builder(this);
                dialog_creditScore.setTitle("选择学历");
                dialog_creditScore.setSingleChoiceItems(degrees, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        curDegreeCode=i+"";
                        et_verifyInfo_degree.setText(degrees[i]);
                        dialogInterface.dismiss();
                    }
                });
                dialog_creditScore.create().show();

                break;
        }
    }

    private void getViewData() {
        address.clear();
        userId="110";
        fullName=et_verifyInfo_username.getText().toString();
        mobile=et_verifyInfo_mobile.getText().toString();
        getHobby(rg_verifyInfo_like);
        address.add(sp_verifyInfo_province.getSelectedItem().toString());
        address.add(sp_verifyInfo_citys.getSelectedItem().toString());
        String county=(sp_verifyInfo_countys.getSelectedItem().toString());
        address.add(county);
        birthday=et_verifyInfo_birthday.getText().toString();
        homeplace=sp_verifyInfo_jgprovince.getSelectedItem().toString()
                +sp_verifyInfo_jgcitys.getSelectedItem().toString()
                +sp_verifyInfo_jgcountys.getSelectedItem().toString();
        finishSchool=et_verifyInfo_finishSchool.getText().toString();
        company=et_verifyInfo_company.getText().toString();
        position=et_verifyInfo_position.getText().toString();
        email=et_verifyInfo_email.getText().toString();
        QQ=et_verifyInfo_QQ.getText().toString();
        wechat=et_verifyInfo_wechat.getText().toString();
        verifyRecommedInfo=new VerifyRecommedInfoBean(userId,fullName,mobile,SfullName,sex,
                hobby, address,birthday,homeplace,finishSchool,
                curDegreeCode, company, position,email,QQ,wechat);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sp_verifyInfo_province:     //设置地址二级联动
                cityList.clear();
                citys = (ArrayList<CityBean>) data.get(position).getSub();
                for (int i = 0; i < citys.size(); i++) {
                    cityList.add(citys.get(i).getName());
                }
                city_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cityList);
                city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_verifyInfo_citys.setAdapter(city_adapter);
                break;
            case R.id.sp_verifyInfo_citys: //设置县区三级联动
                countyList.clear();
                ArrayList<CountyBean> country = (ArrayList<CountyBean>) citys.get(position).getSub();
                if (country == null) {
                    countyList.add(" ");
                } else {
                    for (int i = 0; i < country.size(); i++) {
                        countyList.add(country.get(i).getName());
                    }
                }
                county_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countyList);
                county_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_verifyInfo_countys.setAdapter(county_adapter);
                break;
            case R.id.sp_verifyInfo_jgprovince:     //设置二级联动
                jgcityList.clear();
                citys = (ArrayList<CityBean>) data.get(position).getSub();
                for (int i = 0; i < citys.size(); i++) {
                    jgcityList.add(citys.get(i).getName());
                }
                city_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jgcityList);
                city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_verifyInfo_jgcitys.setAdapter(city_adapter);
                break;
            case R.id.sp_verifyInfo_jgcitys: //设置三级联动
                jgcountyList.clear();
                ArrayList<CountyBean> countrys= (ArrayList<CountyBean>) citys.get(position).getSub();
                if (countrys == null) {
                    jgcountyList.add(" ");
                } else {
                    for (int i = 0; i < countrys.size(); i++) {
                        jgcountyList.add(countrys.get(i).getName());
                    }
                }
                county_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jgcountyList);
                county_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_verifyInfo_jgcountys.setAdapter(county_adapter);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
