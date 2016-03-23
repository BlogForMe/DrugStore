package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoe.drugstore.R;


/**
 * 健康社区
 * Created by Administrator on 2016/3/2.
 */
public class CommunityFragment extends ParentFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_community, null);
    }
}
