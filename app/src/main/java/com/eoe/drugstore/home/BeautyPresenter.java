package com.eoe.drugstore.home;

import com.eoe.drugstore.bean.BeautyRecycler;
import com.eoe.drugstore.net.GsonResponseHandler;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.utils.Constants;
import com.eoe.drugstore.utils.MLog;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BeautyPresenter implements BeautyContract.Presenter {
    private String Tag = "HvPresenter";
    private BeautyContract.View bView;

    public BeautyPresenter(BeautyContract.View bView) {
        this.bView = bView;
    }

    @Override
    public void getHvData() {
        String url = Constants.vmUrl + "HomeRecycler";
        OkHttpHelper.getInstance().
                get(url, new GsonResponseHandler<BeautyRecycler>() {

                    @Override
                    public void onSuccess(int statusCode, BeautyRecycler response) {
                        MLog.i(Tag, "输出  " + statusCode);
                        if (response.isState()){
                            bView.showRecycler(response.getHmList());
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
