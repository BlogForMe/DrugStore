package com.eoe.drugstore.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.Logger;


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
        TextView tvClickme = (TextView) v.findViewById(R.id.clickme);
        tvClickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction("dian.wo.ba");
                getActivity().startActivity(intent);
            }
        });
    }


}
