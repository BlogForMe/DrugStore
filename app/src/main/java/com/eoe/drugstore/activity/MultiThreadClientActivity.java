package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.socket.ClientThread;

public class MultiThreadClientActivity extends ParentActivity {

    private EditText input;
    private Button btSend;
    private TextView tvShow;
    private ClientThread clientThread;//定义与服务器通信的子线程

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_multi_thread_client);
    }

    @Override
    protected void setupView() {
        super.setupView();
        input = (EditText) findViewById(R.id.et_input);
        btSend = (Button) findViewById(R.id.bt_send);
        tvShow = (TextView) findViewById(R.id.tv_show);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Message msg = new Message();
                msg.what = 0x345;
                msg.obj = input.getText().toString();
                clientThread.revHandler.sendMessage(msg);
                input.setText("");
            }
        });
    }


    @Override
    protected void setupData() {
        super.setupData();
        clientThread = new ClientThread(handler);
        //客户端启动ClientThread 线程创建网络连接、读取来自服务器的数据
        new Thread(clientThread).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //如果消息来自于子线程
            if (msg.what == 0x123) {
                //将读取的内容追加显示在文本框内
                tvShow.append("\n" + msg.obj.toString());
            }
        }
    };


}
