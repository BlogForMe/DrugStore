package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.Logger;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 */
public class HomeFragment extends ParentFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView---");
        return initView(R.layout.fragment_home, container);
    }

    @Override
    protected void setupView(View v) {
        super.setupView(v);
        TextView tvJni = (TextView) v.findViewById(R.id.tv_jni);
        tvJni.setText(getMsgFromJni());
    }

    static {
        System.loadLibrary("DrugStore");
    }

    public native String getMsgFromJni();
}
