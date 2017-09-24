package com.eoe.drugstore.home;

import com.eoe.drugstore.bean.GankBean;
import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.net.callback.GenericsCallback;
import com.eoe.drugstore.utils.Constants;
import com.eoe.drugstore.utils.JsonGenericsSerializator;
import com.eoe.drugstore.utils.SharePreferenceHelper;

import okhttp3.Call;


/**
 * Created by Administrator on 2017/7/21.
 */

public class BeautyPresenter implements BeautyContract.Presenter {
    String TAG = "BeautyPresenter";
    private BeautyContract.View bTaskView;
    SharePreferenceHelper sp = null;
    private static int PAGE_INDEX = 0;

    protected static String url = Constants.vmUrl + "/HomeRecycler";


    public BeautyPresenter(BeautyContract.View bView) {
        this.bTaskView = bView;
        sp = new SharePreferenceHelper(bView.getContext(), SharePreferenceHelper.SPFILE);
    }

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

//        String token = String.valueOf(sp.<String>get(SharePreferenceHelper.SP_KEY_TOKEN, ""));
//        String newsUrl = "https://www.oschina.net/action/openapi/tweet_list?access_token=" + token;

        /**
         * html请求
         */
        OkHttpHelper.get()
                .url(Constants.news_gank+PAGE_INDEX)
                .id(100)
                .build()
                .execute(new GenericsCallback<GankBean>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        bTaskView.hideLoadingIndicator();
                    }

                    @Override
                    public void onResponse(GankBean response, int id) {
                        bTaskView.hideLoadingIndicator();
                        bTaskView.showRecycler(response.getResults());
                    }
                });

    }


    @Override
    public void start(boolean isRefresh) {

    }
}
