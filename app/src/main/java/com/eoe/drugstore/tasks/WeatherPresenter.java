package com.eoe.drugstore.tasks;


import com.eoe.drugstore.bean.HeWeather;
import com.eoe.drugstore.bean.OpenWeather;
import com.eoe.drugstore.net.GsonResponseHandler;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.utils.Constants;
import com.eoe.drugstore.utils.MLog;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/6/14.
 */

public class WeatherPresenter implements WeatherContract.Presenter {
    public static final String TAG = "HomePresenter";
    WeatherContract.View fragmentView;

    public WeatherPresenter(WeatherContract.View fragment) {
        this.fragmentView = fragment;
//        fragment.setPresenter(this);
    }


    @Override
    public void okHttpGet() {
        Map<String, String> map = new HashMap<>();
//        map.put("un", "zh");
//        map.put("pwd", "123456");
        map.put("city", "CN101210101");
        map.put("key", "87417128802d429091782a8bc733ac5d");
        OkHttpHelper.getInstance().get(Constants.URL, map, new GsonResponseHandler<HeWeather>() {
            @Override
            public void onSuccess(int statusCode, HeWeather response) {
                fragmentView.showWeather(response);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {

            }

            @Override
            public void onProgress(long currentBytes, long totalBytes) {

            }
        });
    }

    @Override
    public void getOpenWeather() {
        Map<String, String> map = new HashMap<>();
        map.put("id", Constants.OpenCityId);
        map.put("APPID", Constants.KeyOpenWeather);
        OkHttpHelper.getInstance().get(Constants.OpenURL, map, new GsonResponseHandler<OpenWeather>() {
            @Override
            public void onSuccess(int statusCode, OpenWeather response) {
                MLog.i(TAG, "名字  得到");
                fragmentView.showOpenWeather(response);
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {

            }

            @Override
            public void onProgress(long currentBytes, long totalBytes) {

            }
        });

    }


}


