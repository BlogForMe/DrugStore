package com.eoe.drugstore.home;

import android.content.Context;

import com.eoe.drugstore.bean.BeautyRecycler;
import com.eoe.drugstore.tasks.BasePresenter;
import com.eoe.drugstore.utils.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BeautyContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showRecycler(List<BeautyRecycler.HmListBean> bList);

        Context getContext();
    }

    interface Presenter extends BasePresenter {
        void loadTasks();
    }
}
