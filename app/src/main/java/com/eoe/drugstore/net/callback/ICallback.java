package com.eoe.drugstore.net.callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/8.
 */

public abstract class ICallback<T> {

    /**
     * Thread Pool Thread
     */
    public abstract T parseNetworkResponse(Response response, int id) throws Exception;

    public abstract void onError(Call call, Exception e, int id);

    public abstract void onResponse(T response, int id);

    public static ICallback CALLBACK_DEFAULT = new ICallback() {

        @Override
        public Object parseNetworkResponse(Response response, int id) throws Exception {

            return null;
        }

        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(Object response, int id) {

        }
    };

}
