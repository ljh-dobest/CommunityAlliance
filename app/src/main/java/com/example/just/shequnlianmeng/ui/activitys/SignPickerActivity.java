package com.example.just.shequnlianmeng.ui.activitys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.just.shequnlianmeng.R;
import com.example.just.shequnlianmeng.base.view.BaseActivity;
import com.example.just.shequnlianmeng.views.mydatepicker.DPCManager;
import com.example.just.shequnlianmeng.views.mydatepicker.DPDecor;
import com.example.just.shequnlianmeng.views.mydatepicker.DPMode;
import com.example.just.shequnlianmeng.views.mydatepicker.DatePicker;
import com.example.just.shequnlianmeng.views.mydatepicker.DatePicker2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignPickerActivity extends BaseActivity implements DatePicker.OnClickSignIn, View.OnClickListener {
    public static int year=2017;
    public static int month=3;
    public static int day=0;
    @BindView(R.id.my_datepicker)
    DatePicker2 picker;
    @BindView(R.id.btn_signpicker_sign)
    Button btn_signpicker_sign;
    @BindView(R.id.tv_signpicker_back)
    TextView   tv_signpicker_back;
    @BindView(R.id.tv_signpicker_date)
    TextView   tv_signpicker_date;
    @BindView(R.id.iv_signpicker_lastmonth)
    ImageView iv_signpicker_lastmonth;
    @BindView(R.id.iv_signpicker_nextmonth)
    ImageView iv_signpicker_nextmonth;
    private Context mContext;
    private DPCManager dpcManager;
    private List<String> tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_picker);
        ButterKnife.bind(this);
        mContext = this;
        Calendar cal = Calendar.getInstance();
        year=cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day=cal.get(Calendar.DATE);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init() {
        //请求服务器获得已签到日期集合，设置已签日期
        tmp = new ArrayList<>();
        tmp.add("2017-3-12");
        dpcManager=DPCManager.getInstance();
        dpcManager.setDecorBG(tmp);
        picker.setDate(year, month);
        picker.setMode(DPMode.NONE); //设置选择模式
        picker.setFestivalDisplay(false); //是否显示节日
        picker.setIsScroll(false);//设置是否允许滑动
        picker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
                paint.setColor(getResources().getColor(R.color.blue));
                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
            }
        });
        btn_signpicker_sign.setOnClickListener(this);
        tv_signpicker_back.setOnClickListener(this);
        iv_signpicker_lastmonth.setOnClickListener(this);
        iv_signpicker_nextmonth.setOnClickListener(this);
    }


    @Override
    public void signIn() {
        //动态更新的时候必须  清除cache
        dpcManager.clearnDATE_CACHE(); //清除cache
        //新的已签集合
        tmp.add(year+"-"+month+"-"+day);
        dpcManager.setDecorBG(tmp);
        picker.setDate(year, month);
//        myDatepicker.setLeftTitle("3月");
//        myDatepicker.setRightTitle(true);

        picker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
                paint.setColor(getResources().getColor(R.color.blue));
                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
            }
        });
        picker.invalidate(); //刷新
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_signpicker_sign:
                signIn();
                btn_signpicker_sign.setClickable(false);
                btn_signpicker_sign.setText("已签到");
                btn_signpicker_sign.setBackgroundColor(0x99999999);
                break;
            case R.id.tv_signpicker_back:
                    finish();
                break;
            case R.id.iv_signpicker_lastmonth:
                month=month-1;
                if (month<1){
                    month=12;
                    year--;
                }
                tv_signpicker_date.setText(year+"."+month);
                picker.setDate(year, month); //设置日期
                break;
            case R.id.iv_signpicker_nextmonth:
                month=month+1;
                if (month>12){
                    month=1;
                    year++;
                }
                tv_signpicker_date.setText(year+"."+month);
                picker.setDate(year, month); //设置日期
                break;
        }
    }
}
