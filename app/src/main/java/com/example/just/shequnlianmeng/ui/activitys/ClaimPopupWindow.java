package com.example.just.shequnlianmeng.ui.activitys;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.just.shequnlianmeng.R;


/**
 * Created by Min on 2016/11/24.
 *  认领中心下拉
 */

public class ClaimPopupWindow extends PopupWindow implements View.OnClickListener {
    private Context context;
    private LinearLayout ll_claimPop_message,ll_claimPop_mineClaim;

    public ClaimPopupWindow(Context context) {
        this.context = context;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.popupwindow_claim,null);
        //设置SelectPicPopupWindow的view
        this.setContentView(view);
        //
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setOutsideTouchable(true);  //点击外面去取消
        this.update(); //刷新

     //   ll_pop_addgroup= (LinearLayout) view.findViewById(R.id.ll_pop_addgroups);
        ll_claimPop_message= (LinearLayout) view.findViewById(R.id.ll_claimPop_message);
        ll_claimPop_mineClaim= (LinearLayout) view.findViewById(R.id.ll_claimPop_mineClaim);
//        ll_pop_chat.setOnClickListener(this);
        ll_claimPop_message.setOnClickListener(this);
        ll_claimPop_mineClaim.setOnClickListener(this);
    //    ll_pop_addgroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /*case R.id.ll_pop_chat:
                context.startActivity(new Intent(context, MainActivity.class));
                ChatPopupWindow.this.dismiss();
                break;*/
            case R.id.ll_claimPop_message:    //查看认领消息
//                Intent intent=new Intent(context,SelectFriendsActivity.class);
//                intent.putExtra("createGroup",true);
//                context.startActivity(intent);
                break;
            case R.id.ll_claimPop_mineClaim:   //添加好友
//                context.startActivity(new Intent(context,SearchFriendActivity.class));
//                ChatPopupWindow.this.dismiss();
                break;
//            case R.id.ll_pop_addgroups:   //申请入群
//                context.startActivity(new Intent(context,SearchFriendActivity.class));
//                ChatPopupWindow.this.dismiss();
//                break;
            default:
                break;
        }
    }
    public void showPopupWindow(View view){
        if(!this.isShowing()){
            //以下拉的方式显示
            this.showAsDropDown(view,0,0);
        }else {
            this.dismiss();
        }
    }
}
