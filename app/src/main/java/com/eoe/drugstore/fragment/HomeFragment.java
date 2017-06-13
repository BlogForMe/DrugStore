package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;
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
public class HomeFragment extends BaseFragment {
    public static final String TAG = "HomeFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView---");
        return inflater.inflate(R.layout.fragment_home, null);
    }


}
