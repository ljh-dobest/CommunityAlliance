package com.issp.association.listeners;


import com.issp.association.bean.ShareBean;

import java.util.ArrayList;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface OnReadShareListener {
    void getReadShareInfo(ShareBean data);

    void sharePraiseInfo(String data);

    void showError(String errorString);
}
