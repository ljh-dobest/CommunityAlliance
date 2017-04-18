package com.issp.inspiration.interfaces;



import com.issp.inspiration.base.view.BaseView;
import com.issp.inspiration.bean.DealBuyBean;

import java.util.List;

/**
 * Created by T-BayMax on 2017/3/13.
 */

public interface IMinDealBuyListView extends BaseView {
    void setMinDealBuyListData(List<DealBuyBean> data);

    void sharePraise(String data);
}
