package com.eoe.drugstore.home;

import android.content.Context;

import com.eoe.drugstore.bean.BeautyRecycler;
import com.eoe.drugstore.bean.GankBean;
import com.eoe.drugstore.bean.NetEaseTop;
import com.eoe.drugstore.tasks.BasePresenter;
import com.eoe.drugstore.utils.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BeautyContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void hideLoadingIndicator();
        void showRecycler(List<GankBean.ResultsBean> bList);

        Context getContext();
    }

    interface Presenter extends BasePresenter {
        void loadTasks();
    }
}
