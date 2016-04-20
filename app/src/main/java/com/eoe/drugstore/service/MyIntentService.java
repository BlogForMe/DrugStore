package com.eoe.drugstore.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Jon on 2016/4/19.
 */
public class MyIntentService extends IntentService {
    private String TAG = "MyIntentService";


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    //IntentService 会使用单独的线程来执行该方法的代码
    @Override
    protected void onHandleIntent(Intent intent) {
        //该方法可以执行任何耗时的任务，比如下载文件等，此处知识让线程等待20秒
        long endTime = System.currentTimeMillis() + 20 * 1000;
        Log.i(TAG, "onStart");
        while (System.currentTimeMillis() < endTime)
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        Log.i(TAG, "耗时的任务执行完成");

    }
}
