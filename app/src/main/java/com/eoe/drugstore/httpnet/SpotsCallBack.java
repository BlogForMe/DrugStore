package com.eoe.drugstore.httpnet;

import android.content.Context;

import okhttp3.Request;


/**
 * Created by Jon on 2016/3/8.
 */
public class SpotsCallBack<T> extends ResultCallback<T> {
    private Context mContext;

    public SpotsCallBack(Context context) {
        mContext = context;
    }


    @Override
    public void onError(Request request, Exception e) {

    }

    @Override
    public void onResponse(T response) {

    }
}
