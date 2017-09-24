package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eoe.drugstore.R;


/**
 * 我
 * Created by Administrator on 2016/3/2.
 */
public class MineFragment extends BaseFragment {

    private String ivUrl = "http://107.173.10.164:8080/VideoServer/img/fd2.jpg";
    private ImageView iv;
    private TextView tvClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mine, null);
        initView(v);

        return v;
    }

    private void initView(View v) {
        tvClick = (TextView) v.findViewById(R.id.tv_click);
        iv = (ImageView) v.findViewById(R.id.iv_bg);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(getActivity()).load(ivUrl).into(iv);
            }
        });
    }
}
