package com.eoe.drugstore.net.request;

import com.eoe.drugstore.net.callback.ICallback;
import com.eoe.drugstore.utils.Exceptions;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by Administrator on 2017/8/8.
 * 请求参数封装
 */

public abstract class OkHttpRequest {
    protected String url;
    protected Object tag;
    protected Map<String, String> params;
    protected Map<String, String> headers;
    protected int id;

    protected Request.Builder builder = new Request.Builder();

    public OkHttpRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers, int id) {
        this.url = url;
        this.tag = tag;
        this.params = params;
        this.headers = headers;
        this.id = id;
        if (url == null) {
            Exceptions.illegalArgument("url can not be null");
        }
        initBuilder();
    }

    /**
     * 初始化一些基本参数 url , tag , headers
     */
    private void initBuilder() {
        builder.url(url).tag(tag);
        appendHeaders();
    }

    public RequestCall build() {
        return new RequestCall(this);
    }


    private void appendHeaders() {
//        Headers
    }


    public Request generateRequest(ICallback callback) {
        RequestBody requestBody = buildRequestBody();
        RequestBody wrappedRequestBody = wrapRequestBody(requestBody, callback);
        Request request = buildRequest(wrappedRequestBody);
        return request;
    }

    protected abstract Request buildRequest(RequestBody wrappedRequestBody);


    private RequestBody wrapRequestBody(RequestBody requestBody, ICallback callback) {
        return requestBody;
    }

    protected abstract RequestBody buildRequestBody();

    public int getId() {
        return id;
    }
}
