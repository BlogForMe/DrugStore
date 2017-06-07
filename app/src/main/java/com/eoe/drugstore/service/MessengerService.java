package com.eoe.drugstore.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.support.annotation.BoolRes;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.widget.Toast;

/**
 * 使用 Messenger  进行 进程间的通信
 */
public class MessengerService extends Service {
    final String TAG = getClass().getName();
    final String uriParam = "content://com.hyhy.googleplay.utils.DeviceProvider/Device";
    private Messenger clientMessenger;
    static int i;

    public MessengerService() {
    }

    public static final int MSG_SAY_HELLO = 1;

    /**
     * Handler of incoming messages from clients.
     */
    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Bundle data = msg.getData();
                    if (data != null) {
                        String txt = data.getString("msg");
                        SharedPreferences setting = getSharedPreferences("package", 0);
                        setting.edit().putString("txt", "你好").commit();
                        String txtt = setting.getString("txt", "");
                        Cursor cursor = getContentResolver().query(Uri.parse(uriParam)
                                , new String[]{"imei", "imsi", "mac", "simserial"}, null, null, null);
                        while (cursor.moveToNext()) {
                            Log.i("query", cursor.getString(cursor.getColumnIndex("imei")) + " " + cursor.getString(cursor.getColumnIndex("imsi")));
                        }

//                        Toast.makeText(getApplicationContext(), "客户端说 :" +  cursor.getString(cursor.getColumnIndex("imei")) + " " + cursor.getString(cursor.getColumnIndex("imsi")), Toast.LENGTH_SHORT).show();



                    }
                    Log.i(TAG, "有没有回应 " + i);
                    //添加如下
                    clientMessenger = msg.replyTo;  //这个message是在客户端中创建的
                    if (clientMessenger != null) {
                        Log.i(TAG, "有没有回应 + 2  " + i);
                        Message replyMessage = Message.obtain();
                        replyMessage.what = MSG_SAY_HELLO;
                        Bundle bundle = new Bundle();
                        bundle.putString("reply", "客户你好 我是服务端   " + ++i);
                        replyMessage.setData(bundle);
                        try {
                            clientMessenger.send(replyMessage);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    final Messenger serverMessenger = new Messenger(new IncomingHandler());


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        return serverMessenger.getBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clientMessenger = null;
    }
}
