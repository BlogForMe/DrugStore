package com.eoe.drugstore.net.request;

import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.net.callback.ICallback;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/8/8.
 * 对OkHttpRequest的封装
 */

public class RequestCall {
    private OkHttpRequest okHttpRequest;
    private Request request;
    private Call call;
    private long readTimeOut, writeTimeOut, connTimeOut;
    private OkHttpClient client;

    public RequestCall(OkHttpRequest request) {
        this.okHttpRequest = request;
    }

    public void execute(ICallback callback) {
        buildCall(callback);
        OkHttpHelper.getInstance().execute(this, callback);
    }

    private Call buildCall(ICallback callback) {
        request = generateRequest(callback);
        if (readTimeOut > 0 || writeTimeOut > 0 || connTimeOut > 0) {
            readTimeOut = readTimeOut > 0 ? readTimeOut : OkHttpHelper.DEFAULT_MILLISECONDS;
            writeTimeOut = writeTimeOut > 0 ? writeTimeOut : OkHttpHelper.DEFAULT_MILLISECONDS;
            connTimeOut = connTimeOut > 0 ? connTimeOut : OkHttpHelper.DEFAULT_MILLISECONDS;
            client = OkHttpHelper.getInstance().getOkHttpClient().newBuilder()
                    .readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
                    .connectTimeout(connTimeOut, TimeUnit.MILLISECONDS)
                    .build();
            call = client.newCall(request);
        } else {
            call = OkHttpHelper.getInstance().getOkHttpClient().newCall(request);
        }
        return call;
    }

    private Request generateRequest(ICallback callback) {
        return okHttpRequest.generateRequest(callback);
    }

    public OkHttpRequest getOkHttpRequest() {
        return okHttpRequest;
    }

    public Call getCall() {
        return call;
    }

}
