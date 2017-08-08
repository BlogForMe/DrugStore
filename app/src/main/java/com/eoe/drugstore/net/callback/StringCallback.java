package com.eoe.drugstore.net.callback;


import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/8.
 */

public abstract class StringCallback extends ICallback<String> {

    @Override
    public String parseNetworkResponse(Response response, int id) throws Exception {
        return response.body().string();
    }
}
