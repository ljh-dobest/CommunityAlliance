package com.issp.association.listeners;


import com.issp.association.bean.ShareBean;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 *Created by T-BayMax on 2017/3/13.
=======
 * Created by T-BayMax on 2017/3/13.
>>>>>>> bxh
 */

public interface OnShareListener {
    void getShareInfo(ArrayList<ShareBean> data);

    void sharePraiseInfo(String data);

    void showError(String errorString);
}
