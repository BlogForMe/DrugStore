package com.eoe.drugstore.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.activity.PictureProgressActivity;
import com.eoe.drugstore.utils.JumpSingleton;


/**
 * 健康社区
 * Created by Administrator on 2016/3/2.
 */
public class CommunityFragment extends ParentFragment implements AdapterView.OnItemClickListener {
    private String[] arrays = {"图形绘制", "Image方法"};
    private ListView listView;
    private Intent intent;
    private JumpSingleton jInstance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_community, null);
    }

    @Override
    protected void setupView(View v) {
        super.setupView(v);
        jInstance = JumpSingleton.getInstance(mContext);
        listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arrays));
        listView.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 4:
                //图片处理
                jInstance.JumpNextAcitivy(PictureProgressActivity.class, false);
                break;
        }
    }
}
