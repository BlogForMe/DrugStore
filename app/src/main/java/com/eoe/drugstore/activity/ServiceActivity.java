package com.eoe.drugstore.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.eoe.drugstore.R;
import com.eoe.drugstore.service.FirstService;

public class ServiceActivity extends ParentActivity {
    private FirstService.MyBind myBind;

     ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBind = (FirstService.MyBind) service;
            myBind.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_service);
        Log.i(FirstService.Tag, "MainActivity thread id is " + Thread.currentThread().getId());
        final Intent intent = new Intent(ServiceActivity.this, FirstService.class);

        findViewById(R.id.tv_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                intent.putExtra("hehe", "过来");
                ServiceActivity.this.startService(intent);
            }
        });
        findViewById(R.id.tv_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i(FirstService.Tag, "click stop Service button");

                ServiceActivity.this.stopService(intent);
            }
        });
        findViewById(R.id.tv_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.tv_unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i(FirstService.Tag, "click Unbind Service button --");
                unbindService(connection);
            }
        });

        findViewById(R.id.bt_stopservice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(FirstService.Tag, "click stopservicebutton --");

                myBind.stopService();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connection != null)
            unbindService(connection);
    }
}
