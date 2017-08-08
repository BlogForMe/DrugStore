package com.eoe.drugstore.net.builder;

import com.eoe.drugstore.net.request.RequestCall;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/7.
 * 给参数赋值
 */

public abstract class OkHttpRequestBuilder<T> {
    protected String url;
    protected int id;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;

    public T id(int id) {
        this.id = id;
        return (T) this;
    }

    public T url(String url) {
        this.url = url;
        return (T) this;
    }

    public T tag(Object tag) {
        this.tag = tag;
        return (T) this;
    }

    public T addHeader(String key, String val) {
        if (this.headers == null) {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, val);
        return (T) this;
    }


    public abstract RequestCall build();
}
