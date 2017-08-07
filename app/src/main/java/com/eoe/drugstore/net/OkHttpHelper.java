package com.eoe.drugstore.net;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.Tag;
import android.os.Handler;

import com.eoe.drugstore.utils.MLog;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/6/20.
 * OKHTTP封装
 * http://www.jianshu.com/p/ddbf69d1c9d1
 */

public class OkHttpHelper {
    private String TAG = "OkHttpHelper";
    private OkHttpClient client;
    private static OkHttpHelper instance;
    private Context ctx;
    public OkHttpHelper(Context context) {
        this.ctx = context;
        //缓存文件夹
        File cacheFile = new File(ctx.getExternalCacheDir().toString(), "cache");
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(cacheFile, cacheSize);
        client = new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    public static OkHttpHelper getInstance(Context ctx) {
        if (instance == null)
            instance = new OkHttpHelper(ctx);
        return instance;
    }


    public void get(String url, IResponseHandler responseHandler) {
        get(url, null, responseHandler);
    }

    /**
     * get请求
     *
     * @param url             请求地址
     * @param params          请求参数
     * @param responseHandler
     */
    public void get(String url, Map<String, String> params, IResponseHandler responseHandler) {
        StringBuilder paramUrl = new StringBuilder(url);
        if (params != null && params.size() > 0) {
            int i = 0;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (i++ == 0)
                    paramUrl.append("?").append(entry.getKey()).append("=").append(entry.getValue());
                else
                    paramUrl.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        //发起request
        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(60, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(paramUrl.toString())
                .cacheControl(cacheControl)
                .tag(ctx).build();
        MLog.i(TAG, "请求url  " + url);
        client.newCall(request)
                .enqueue(new MyCallback(new Handler(), responseHandler));
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
                MLog.i(TAG, "cacheResponse " + response.cacheResponse() + " \n  networkResponse " + response.networkResponse());
                if (mIResponseHandler instanceof GsonResponseHandler) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Gson gson = new Gson();
                                ((GsonResponseHandler) mIResponseHandler)
                                        .onSuccess(response.code(), gson.fromJson(response_body, ((GsonResponseHandler) mIResponseHandler).getmType()));
                            } catch (Exception e) {
                                e.printStackTrace();
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

    /**
     * to use to check for network connectivity.
     *
     * @return
     */
    private boolean isOnLine() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }





}
