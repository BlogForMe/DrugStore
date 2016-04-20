package com.eoe.drugstore.BroadCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Jon on 2016/4/19.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "接收到的Intent的Action为" + intent.getAction() + intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
        Bundle bundle  = new Bundle();
        bundle.putString("first","第一个BroadcastReceiver存入的消息");
        setResultExtras(bundle);

        //取消继续传播
//        abortBroadcast();
    }
}
