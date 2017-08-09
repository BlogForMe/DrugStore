package com.eoe.drugstore.home;

import android.util.Log;

import com.eoe.drugstore.bean.BeautyRecycler;
import com.eoe.drugstore.net.GsonResponseHandler;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.net.callback.GenericsCallback;
import com.eoe.drugstore.net.callback.StringCallback;
import com.eoe.drugstore.utils.Constants;
import com.eoe.drugstore.utils.JsonGenericsSerializator;
import com.eoe.drugstore.utils.MLog;

import okhttp3.Call;


/**
 * Created by Administrator on 2017/7/21.
 */

public class BeautyPresenter implements BeautyContract.Presenter {
    private String TAG = "BeautyPresenter";
    private BeautyContract.View bTaskView;

    public BeautyPresenter(BeautyContract.View bView) {
        this.bTaskView = bView;
    }

    @Override
    public void start() {
        loadTasks();
    }

    @Override
    public void loadTasks() {
        loadTasks(true);
    }

    /**
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadTasks(boolean showLoadingUI) {
        if (showLoadingUI) {
            bTaskView.setLoadingIndicator(true);
        }


        String url = Constants.vmUrl + "/HomeRecycler";
//        String url = "http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";

//        OkHttpHelper.getInstance().get(bTaskView.getContext(),url, null, new GsonResponseHandler<BeautyRecycler>() {
//
//            @Override
//            public void onSuccess(int statusCode, BeautyRecycler response) {
//                MLog.i(TAG, "请求成功  " + statusCode);
//                if (response.isState()) {
//                    bTaskView.showRecycler(response.getHmList());
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, String error_msg) {
//
//            }
//
//            @Override
//            public void onProgress(long currentBytes, long totalBytes) {
//
//            }
//        });


        /**
         * html请求
         */
        OkHttpHelper.get()
                .url(url)
                .id(100)
                .build()
                .execute(new GenericsCallback<BeautyRecycler>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(BeautyRecycler response, int id) {
                        if (response.isState()) {
                            bTaskView.showRecycler(response.getHmList());
                        }
                    }
                });
//
//        OkHttpHelper.post()
//                .url(urll)
//                .build()
//                .execute(new GenericsCallback<BeautyRecycler>(new JsonGenericsSerializator()) {
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(BeautyRecycler response, int id) {
//
//                    }
//                });


    }

    public class MyStringCallback extends StringCallback {

        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            Log.i(TAG, response);
        }
    }
}
