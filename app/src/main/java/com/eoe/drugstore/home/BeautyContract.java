package com.eoe.drugstore.home;

import com.eoe.drugstore.bean.BeautyRecycler;
import com.eoe.drugstore.tasks.BasePresenter;
import com.eoe.drugstore.utils.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BeautyContract {
    interface View extends BaseView<Presenter> {
        void showRecycler(List<BeautyRecycler.HmListBean> bList);
    }

    interface Presenter extends BasePresenter {
        void getHvData();
    }
}
