package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.eoe.drugstore.R;

public class HttpIntenetActivity extends ParentActivity {

    private GridView lvInternet;
    private String[] iarray = {"使用URL读取网络资源", "URLConnection提交请求", "使用HttpURLConnection", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_http_intenet);
    }

    @Override
    protected void setupView() {
        super.setupView();
        lvInternet = (GridView) findViewById(R.id.gv_internet);
        ListAdapter adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, iarray);
        lvInternet.setAdapter(adapter);
        lvInternet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        jInstalce.JumpNextAcitivy(URLTest.class, false);
                        break;
                    case 1:
                        jInstalce.JumpNextAcitivy(GetPostMain.class, false);
                        break;
                    case 2:
                        jInstalce.JumpNextAcitivy(MultiThreadDown.class, false);
                        break;
                }
            }
        });
    }

}
