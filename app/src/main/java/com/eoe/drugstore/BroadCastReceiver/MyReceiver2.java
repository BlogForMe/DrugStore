package com.eoe.drugstore.BroadCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Jon on 2016/4/19.
 */
public class MyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(true);
        String first = bundle.getString("first");
        Toast.makeText(context, "第一个broadcast存入的消息为" + first,Toast.LENGTH_SHORT).show();
    }
}
