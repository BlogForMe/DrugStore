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
