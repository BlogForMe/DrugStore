package com.eoe.drugstore.net;


import android.content.Context;
import android.nfc.Tag;
import android.os.Handler;

import com.eoe.drugstore.utils.MLog;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/6/20.
 * OKHTTP封装
 * http://www.jianshu.com/p/ddbf69d1c9d1
 */

public class OkHttpHelper {

    private OkHttpClient client;
    private static OkHttpHelper instance;
    private Context ctx;

    public OkHttpHelper() {
        client = new OkHttpClient();
    }

    public static OkHttpHelper getInstance() {
        if (instance == null)
            instance = new OkHttpHelper();
        return instance;
    }

    public void setContext(Context context) {
        this.ctx = context;
    }

    public void get(String url, IResponseHandler responseHandler) {
        get(url, null, responseHandler);
    }


    public void get(final String url, final Map<String, String> params, IResponseHandler responseHandler) {
        get(null, url, params, responseHandler);
    }

    /**
     * get请求
     *
     * @param context
     * @param url             请求地址
     * @param params          请求参数
     * @param responseHandler
     */
    public void get(Context context, String url, Map<String, String> params, IResponseHandler responseHandler) {
        StringBuilder sbUrl = null;
        if (params != null && params.size() > 0) {
            sbUrl = new StringBuilder(url);
            int i = 0;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (i++ == 0)
                    sbUrl.append("?").append(entry.getKey()).append("=").append(entry.getValue());
                else
                    sbUrl.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        Request request;
        //发起request
        if (context == null) {
            if (sbUrl != null) {
                request = new Request.Builder()
                        .url(sbUrl.toString()).build();
            } else {
                request = new Request.Builder()
                        .url(url).build();
            }
        } else {
            request = new Request.Builder()
                    .url(url)
                    .tag(context).build();
        }
        client.newCall(request).enqueue(new MyCallback(new Handler(), responseHandler));
    }

    private class MyCallback implements Callback {
        private Handler mHandler;
        private IResponseHandler mIResponseHandler;

        public MyCallback(Handler mHandler, IResponseHandler mIResponseHandler) {
            this.mHandler = mHandler;
            this.mIResponseHandler = mIResponseHandler;
        }

        @Override
        public void onFailure(Call call, final IOException e) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mIResponseHandler.onFailure(0, e.toString());
                }
            });
        }

        @Override
        public void onResponse(Call call, final Response response) throws IOException {
            if (response.isSuccessful()) {
                final String response_body = response.body().string();
                if (mIResponseHandler instanceof GsonResponseHandler) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Gson gson = new Gson();
                                ((GsonResponseHandler) mIResponseHandler)
                                        .onSuccess(response.code(), gson.fromJson(response_body, ((GsonResponseHandler) mIResponseHandler).getmType()));
                            } catch (Exception e) {
                                MLog.e("OkHttpHelper ", response_body.toString());
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mIResponseHandler.onFailure(response.code(), "fail parse jsonobject, body=" + response_body);
                                    }
                                });
                            }
                        }
                    });
                }


            }
        }
    }


}
