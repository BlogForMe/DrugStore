package com.eoe.drugstore.activity;

import android.os.Bundle;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.ActivityManager;

public class LeakageActivity extends ParentActivity {
    byte[] b = new byte[1024*1024];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_leakage);
        ActivityManager.instance().registActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//      ActivityManager.instance().unRegistActivity(this);
    }
}
