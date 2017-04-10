package com.eoe.drugstore.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.support.annotation.BoolRes;
import android.support.design.widget.CoordinatorLayout;
import android.widget.Toast;

/**
 * 使用 Messenger  进行 进程间的通信
 */
public class MessengerService extends Service {
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
                    String txt = msg.getData().getString("msg");
                    Toast.makeText(getApplicationContext(), "客户端说 :"+txt, Toast.LENGTH_SHORT).show();

                    //添加如下
                    Messenger client = msg.replyTo;
                    Message replyMessage = Message.obtain(null, MSG_SAY_HELLO);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply", "客户你好 我是服务端");
                    replyMessage.setData(bundle);
                    try {
                        client.send(replyMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
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
}
