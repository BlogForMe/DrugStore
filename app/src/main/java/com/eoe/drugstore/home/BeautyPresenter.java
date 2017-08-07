package com.eoe.drugstore.home;

import com.eoe.drugstore.bean.BeautyRecycler;
import com.eoe.drugstore.net.GsonResponseHandler;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.utils.Constants;
import com.eoe.drugstore.utils.MLog;

import java.util.IllegalFormatCodePointException;

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
//        String url = "https://www.qumi.com/api/vendor/android/transfer?app=%2060b16a926906a09e&ad=18775&imei=866818029419767&clientip=39.176.2.133&callback=http%3a%2f%2fwww.tuiaso.com%2fApp%2f100028.aspx%3fadname%3d%E5%88%A9%E5%BE%97%E5%AE%89%E5%8D%93%26imei%3d866818029419767%26source%3d%E8%B6%A3%E7%B1%B3";
        OkHttpHelper.getInstance(bTaskView.getContext()).
                get(url, new GsonResponseHandler<BeautyRecycler>() {

                    @Override
                    public void onSuccess(int statusCode, BeautyRecycler response) {
                        MLog.i(TAG, "请求成功  " + statusCode);
                        if (response.isState()) {
                            bTaskView.showRecycler(response.getHmList());
                        }
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
