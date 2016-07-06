package com.eoe.drugstore.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.eoe.drugstore.R;

import java.util.List;
import java.util.Objects;

public class SeeProcessActivity extends ParentActivity {


    private List<ActivityManager.RunningAppProcessInfo> appProcessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_see_process);
    }

    @Override
    protected void setupView() {
        super.setupView();
        ListView lvProcee = (ListView) findViewById(R.id.lv_process);
        ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        appProcessList = mActivityManager.getRunningAppProcesses();
        lvProcee.setAdapter(new ProcessAdapter());
    }

    class ProcessAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return appProcessList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflate.inflate(R.layout.adapter_simple, null);
            TextView tvPrcoss = (TextView) view.findViewById(R.id.tv_process);
            tvPrcoss.setText(appProcessList.get(position).processName);
            return view;
        }
    }

}
