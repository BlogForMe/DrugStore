package com.eoe.drugstore.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;


/**
 * 我
 * Created by Administrator on 2016/3/2.
 */
public class MineFragment extends ParentFragment {


    private Intent intent;
    private SharedPreferences settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_mine, container);
    }

    @Override
    protected void setupData() {
        super.setupData();
    }


    @Override
    protected void setupView(View v) {
    }


}
