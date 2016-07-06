package com.eoe.drugstore.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.eoe.drugstore.aidl.ICat;

/**
 * Created by Jon on 2016/4/19.
 * 绑定本地SERVICE并与之进行通信
 */
public class BindService extends Service {
    private String Tag = "BindService";
    private int count;
    private boolean quit;
    private CatBinder catBinder;

    public class CatBinder extends ICat.Stub {

        @Override
        public String getColor() throws RemoteException {
            return "get fron remote service";
        }

        @Override
        public double getWeight() throws RemoteException {
            return 999.9;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(Tag, "Service is Binded");
        //返回IBinder对象
        return catBinder;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(Tag, "service is Created--");
        catBinder = new CatBinder();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(Tag, "service is onStartCommand--");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.i(Tag, "service is Unbind--");

        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(Tag, "service is onRebind--");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "service is onDestroy--");
    }
}
