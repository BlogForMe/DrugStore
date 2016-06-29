package com.eoe.drugstore.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Jon on 2016/4/18.
 */
public class FirstService extends Service {
    public  static  String Tag = "FirstService";

    private MyBind mBind = new MyBind();

    @Override
    public IBinder onBind(Intent intent) {
        return mBind;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(Tag, "service is Created--");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(Tag, "service is onUnbind--");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        long endTime = System.currentTimeMillis() + 20 * 1000;
//        while (System.currentTimeMillis() < endTime)
//            synchronized (this) {
//                try {
//                    wait(endTime - System.currentTimeMillis());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        Log.i(Tag, "service is onStartCommand--");

//        return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(Tag, "service is destroy--");

        super.onDestroy();
    }

    public class MyBind extends Binder {
        public void startDownload() {
            Log.i(Tag, "startDownload() executed");
        }
    }
}
