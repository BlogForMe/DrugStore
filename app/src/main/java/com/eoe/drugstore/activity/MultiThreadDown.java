package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eoe.drugstore.R;

public class MultiThreadDown extends ParentActivity {

    private Button btDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_multi_thread_down);
    }

    @Override
    protected void setupView() {
        super.setupView();
        btDownload = (Button) findViewById(R.id.bt_download);
        btDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //初始化DownUtil对象（最后一侧参数指定线程数）
//                downUtil= new DW
            }
        });
    }

}
