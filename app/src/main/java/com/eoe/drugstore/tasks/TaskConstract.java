package com.eoe.drugstore.tasks;

/**
 * Created by Administrator on 2017/6/14.
 * 让view和presenter建立联系
 */

public interface TaskConstract {
    interface View extends BaseView<Presenter> {
        void requestTask();
    }


    interface Presenter extends BasePresenter {
        void getTask();
    }

}
