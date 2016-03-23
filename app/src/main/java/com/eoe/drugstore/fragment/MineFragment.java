package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;


/**
 * 我的818
 * Created by Administrator on 2016/3/2.
 */
public class MineFragment extends ParentFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_community, container);
    }


}
