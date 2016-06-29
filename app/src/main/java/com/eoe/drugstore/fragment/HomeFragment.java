package com.eoe.drugstore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.activity.AActivity;
import com.eoe.drugstore.activity.HttpIntenetActivity;
import com.eoe.drugstore.activity.LeakageActivity;
import com.eoe.drugstore.activity.ServiceActivity;
import com.eoe.drugstore.utils.JumpSingleton;
import com.eoe.drugstore.utils.Logger;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 */
public class HomeFragment extends ParentFragment {


    private JumpSingleton instance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView---");
        return initView(R.layout.fragment_home, container);
    }

    @Override
    protected void setupView(View v) {
        super.setupView(v);
        instance = JumpSingleton.getInstance(mContext);
        String[] arrays = {"HTTP网络请求", "android启动模式", "内存泄漏", "Service"};
        ListView hListview = (ListView) v.findViewById(R.id.hListview);
        hListview.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arrays));
        hListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        instance.JumpNextAcitivy(HttpIntenetActivity.class, false);
                        break;
                    case 1:
                        instance.JumpNextAcitivy(AActivity.class, false);
                        break;
                    case 2:
                        instance.JumpNextAcitivy(LeakageActivity.class, false);
                        break;
                    case 3:
                        instance.JumpNextAcitivy(ServiceActivity.class, false);
                        break;
                }
            }
        });
    }


}
