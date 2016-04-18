package com.eoe.drugstore.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Jon on 2016/4/19.
 * 绑定本地SERVICE并与之进行通信
 */
public class BindService extends Service {
    private String Tag = "BindService";
    private int count;
    private boolean quit;
    private MyBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        int getCount() {
            //获取service运行状态

            return count;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(Tag, "Service is Binded");
        //返回IBinder对象
        return binder;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(Tag, "service is Created--");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        count++;
                    }
                }
            }
        }).start();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.i(Tag, "service is Unbind--");

        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit =true;
        Log.i(Tag, "service is onDestroy--");
    }
}
