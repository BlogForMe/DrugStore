package com.eoe.drugstore.tasks;


import com.eoe.drugstore.bean.LoginB;
import com.eoe.drugstore.net.GsonResponseHandler;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.utils.MLog;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/6/14.
 */

public class HomePresenter implements TaskConstract.Presenter {
    public static final String TAG = "HomePresenter";
    String url = "http://192.168.0.126:8080/Demo/LoginServlet";
    TaskConstract.View fragmentView;

    public HomePresenter(TaskConstract.View fragment) {
        this.fragmentView = fragment;
        fragment.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void getTask() {
        fragmentView.requestTask();
    }

    @Override
    public void okhttpGet() {
        Map<String, String> map = new HashMap<>();
        map.put("un", "zh");
        map.put("pwd", "123456");
        OkHttpHelper.getIntance().get(url, map, new GsonResponseHandler<LoginB>() {
            @Override
            public void onSuccess(int statusCode, LoginB response) {
                MLog.i(TAG,response.getData().get(0).getName()+"名字  得到");
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


