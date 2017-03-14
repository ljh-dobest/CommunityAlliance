package com.issp.association;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.app.ActionBar.LayoutParams;
import android.view.Gravity;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * 干货分享
 */
public class MainActivity extends Activity {

    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initPopupWindow() {
        if (null == mPopupWindow || !mPopupWindow.isShowing()) {
            LayoutInflater mLayoutInflater = (LayoutInflater) this
                    .getSystemService(LAYOUT_INFLATER_SERVICE);
            View popwindow_more = mLayoutInflater.inflate(
                    R.layout.popwindow_more, null);
            mPopupWindow = new PopupWindow(popwindow_more, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            mPopupWindow.showAtLocation(findViewById(R.id.lt_main_title_right), Gravity.RIGHT | Gravity.TOP, 0, 0);
            TextView tv_information = (TextView) popwindow_more.findViewById(R.id.tv_information);
        }
    }
}
