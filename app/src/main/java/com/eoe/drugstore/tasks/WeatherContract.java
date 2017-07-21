package com.eoe.drugstore.tasks;

import com.eoe.drugstore.bean.HeWeather;
import com.eoe.drugstore.bean.OpenWeather;
import com.eoe.drugstore.utils.BaseView;

/**
 * Created by Administrator on 2017/6/14.
 * 让view和presenter建立联系
 */

public interface WeatherContract {
    interface View extends BaseView<Presenter> {
        void showWeather(HeWeather responseHe);

        void showOpenWeather(OpenWeather responseOpen);
    }


    interface Presenter extends BasePresenter {
        void okHttpGet();

        void getOpenWeather();
    }

}
