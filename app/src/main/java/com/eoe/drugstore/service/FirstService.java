package com.eoe.drugstore.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Jon on 2016/4/18.
 */
public class FirstService extends Service {
    String Tag = "FirstService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(Tag, "service is Created--");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(Tag, "service is Start--");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(Tag, "service is destroy--");

        super.onDestroy();
    }
}
