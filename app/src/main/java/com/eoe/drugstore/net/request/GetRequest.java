package com.eoe.drugstore.net.request;


import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/8/8.
 */

public class GetRequest extends OkHttpRequest {
    public GetRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers, int id) {
        super(url, tag, params, headers, id);
    }

    @Override
    protected Request buildRequest(RequestBody wrappedRequestBody) {
        return null;
    }

    @Override
    protected RequestBody buildRequestBody() {
        return null;
    }
}
