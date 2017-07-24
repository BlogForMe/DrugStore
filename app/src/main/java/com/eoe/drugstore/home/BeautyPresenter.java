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
        OkHttpHelper.getInstance().
                get(url, new GsonResponseHandler<BeautyRecycler>() {

                    @Override
                    public void onSuccess(int statusCode, BeautyRecycler response) {
                        MLog.i(TAG, "输出  " + statusCode);
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
