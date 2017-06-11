package com.eoe.drugstore.fragment;

import android.app.DownloadManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.DeviceInfoUtil;
import com.eoe.drugstore.utils.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 */
public class HomeFragment extends ParentFragment {
    public static final String TAG = "HomeFragment";
    ExecutorService exec = Executors.newCachedThreadPool();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView---");
        return initView(R.layout.fragment_home, container);
    }

    @Override
    protected void setupView(View v) {
        super.setupView(v);


        TextView tvOkcach = (TextView) v.findViewById(R.id.tv_okcach);
        tvOkcach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testCache();
            }
        });


    }

    protected void testCache() {
        //缓存文件
        File cacheFile = new File(mContext.getExternalCacheDir().toString(), "cache");
        int cacheSize = 10 * 1024 * 1024;
        final Cache cache = new Cache(cacheFile, cacheSize);
        exec.execute(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();

                String url = "http://192.168.1.105:8080/Demo/myServlet";
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Call call1 = client.newCall(request);
                Response response1 = null;
                try {
                    response1 = call1.execute();
                    Log.i(TAG, "testCache : response1 :" + response1.body().string());
                    Log.i(TAG, "testCache : response1 cache:" + response1.cacheResponse());
                    Log.i(TAG, "testCache : response1 network:" + response1.networkResponse());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Call call2 = client.newCall(request);
                Response response2 = null;
                try {
                    response2 = call2.execute();
                    Log.i(TAG, "testCache : response2 :" + response2.body().string());
                    Log.i(TAG, "testCache : response2 cache:" + response2.cacheResponse());
                    Log.i(TAG, "testCache : response2 network:" + response2.networkResponse());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static {
        System.loadLibrary("DrugStore");
    }

    public native String getMsgFromJni();
}
