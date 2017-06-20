package com.eoe.drugstore.net;

/**
 * Created by Administrator on 2017/6/20.
 */

public interface IResponseHandler {
    void onFailure(int statusCode, String error_msg);

    void onProgress(long currentBytes, long totalBytes);
}
