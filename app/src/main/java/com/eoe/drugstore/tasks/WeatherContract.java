package com.eoe.drugstore.tasks;

import com.eoe.drugstore.bean.HeWeather;

/**
 * Created by Administrator on 2017/6/14.
 * 让view和presenter建立联系
 */

public interface WeatherContract {
    interface View extends BaseView<Presenter> {
        void showWeather(HeWeather responseHe);
    }


    interface Presenter extends BasePresenter {
        void okHttpGet();

        void getOpenWeather();
    }

}
