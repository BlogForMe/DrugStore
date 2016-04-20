package com.eoe.drugstore.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    @Override
    protected void setupView(View v) {
        super.setupView(v);
        /**
         * 广播
         */
        TextView tvBroadCast = (TextView) v.findViewById(R.id.tv_broadcast);
        tvBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.eoe.drugstore.fragment.communityFragment");
                intent.putExtra("msg", "简单的消息");
                mContext.sendBroadcast(intent);
            }
        });

        /**
         * 发送一条有序广播
         */
        v.findViewById(R.id.tv_order_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.eoe.drugstore.fragment.communityFragment");
                intent.putExtra("msg", "简单的消息");
                getActivity().sendOrderedBroadcast(intent, null);
            }
        });
    }
}
