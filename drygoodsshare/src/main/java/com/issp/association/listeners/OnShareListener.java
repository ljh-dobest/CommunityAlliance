package com.issp.association.listeners;


import com.issp.association.bean.ShareBean;

import java.util.ArrayList;

/**
 * Created by Min on 2017/3/9.
 */

public interface OnShareListener {
    void getShareInfo(ArrayList<ShareBean> data);
    void showError(String errorString);
}
