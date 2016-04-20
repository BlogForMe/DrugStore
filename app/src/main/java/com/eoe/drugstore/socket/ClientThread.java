package com.eoe.drugstore.socket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Jon on 2016/4/21.
 */
public class ClientThread implements Runnable {
    private Socket s;

    private Handler handler; //定义向UI线程发送消息的Hnadler对象
    private BufferedReader br;
    private OutputStream os;
    public Handler revHandler;//定义接收UI线程的消息的Hnadler对象

    public ClientThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            s = new Socket("192.168.1.102", 30000);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            os = s.getOutputStream();

            //启动一条子线程来读取服务器响应的数据
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    String content = null;
                    //不断读取Socket输入流中的内容
                    try {
                        while ((content = br.readLine()) != null) {
                            //每当读到来自服务器的额数据后，发送消息通知城市界面显示数据
                            Message msg = new Message();
                            msg.what = 0x123;
                            msg.obj = content;
                            handler.sendMessage(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
            //为当前线程初始化Looper
            Looper.prepare();
            //创建revHandler对象
            revHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    //接收到UI线程中用户输入的数据
                    if (msg.what == 0x345)
                        try {
                            os.write((msg.obj.toString() + "\r\n").getBytes("utf-8"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            };
            //启动Looper
            Looper.loop();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("ClientThread", "网络连接超时");
        }
    }
}
