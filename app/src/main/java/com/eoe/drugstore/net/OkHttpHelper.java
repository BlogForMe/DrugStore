package com.eoe.drugstore.net;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import com.eoe.drugstore.net.builder.GetBuilder;
import com.eoe.drugstore.net.builder.PostFormBuilder;
import com.eoe.drugstore.net.callback.ICallback;
import com.eoe.drugstore.net.request.RequestCall;
import com.eoe.drugstore.utils.MLog;
import com.eoe.drugstore.utils.Platform;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
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
    static String TAG = "OkHttpHelper";
    private static OkHttpHelper instance;
    public static final long DEFAULT_MILLISECONDS = 10_1000L;

    private Platform mPlatform;


    public static OkHttpHelper getInstance() {
        return initClient(null);
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    private OkHttpClient mOkHttpClient;

    public OkHttpHelper(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        } else {
            mOkHttpClient = okHttpClient;
        }
        mPlatform = Platform.get();
    }

    public static OkHttpHelper initClient(OkHttpClient okHttpClient) {
        if (instance == null) {
            synchronized (OkHttpHelper.class) {
                if (instance == null)
                    instance = new OkHttpHelper(okHttpClient);
            }
        }
        return instance;
    }


    public Executor getDelivery() {
        return mPlatform.defaultCallbackExecutor();
    }


    public static GetBuilder get() {
        return new GetBuilder();
    }

    public static PostFormBuilder post() {
        return new PostFormBuilder();
    }

    public void execute(final RequestCall requestCall, ICallback iCallback) {
        if (iCallback == null)
            iCallback = ICallback.CALLBACK_DEFAULT;
        final ICallback finalCallback = iCallback;
        final int id = requestCall.getOkHttpRequest().getId();
        requestCall.getCall().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    Object o = finalCallback.parseNetworkResponse(response, id);
                    sendSuccessResultCallback(o, finalCallback, id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void sendSuccessResultCallback(final Object o, final ICallback callback, final int id) {
        if (callback == null) return;
        mPlatform.execute(new Runnable() {
            @Override
            public void run() {
                callback.onResponse(o, id);
//                callback.onA
            }
        });

    }


    /**
     * //     * get请求
     * //     *
     * //     * @param url             请求地址
     * //     * @param params          请求参数
     * //     * @param responseHandler
     * //
     */
//    public void get(Context ctx, String url, Map<String, String> params, IResponseHandler responseHandler) {
//        StringBuilder paramUrl = new StringBuilder(url);
//        if (params != null && params.size() > 0) {
//            int i = 0;
//            for (Map.Entry<String, String> entry : params.entrySet()) {
//                if (i++ == 0)
//                    paramUrl.append("?").append(entry.getKey()).append("=").append(entry.getValue());
//                else
//                    paramUrl.append("&").append(entry.getKey()).append("=").append(entry.getValue());
//            }
//        }

//        OkHttpClient okHttpClient = new OkHttpClient()
//                .newBuilder()
//                .cache(cache)                                   //在Myapplication可以看到
//                .addNetworkInterceptor(new NewCacheInterceptor())
//                .build();
//
//        Request request = new Request.Builder()
////                .cacheControl(CacheControl.FORCE_CACHE)
//                .url(paramUrl.toString())
//                .build();
//        okHttpClient.newCall(request)
//                .enqueue(new MyCallback(new Handler(), responseHandler));
//    }


    private static class MyCallback implements Callback {
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
    private boolean isOnLine(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
