package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.GetPostUtil;

/**
 * 使用URLConnetcion提交请求
 */
public class GetPostMain extends ParentActivity {

    private Button btGet, btPost;
    private TextView tvURL;
    private String response; //代表服务器响应的字符串
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123)
                tvURL.setText(response);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_get_post_main);
    }

    @Override
    protected void setupView() {
        super.setupView();
        btGet = (Button) findViewById(R.id.bt_get);
        btPost = (Button) findViewById(R.id.bt_post);
        tvURL = (TextView) findViewById(R.id.tv_url);
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        response = GetPostUtil.sendGet("http://192.168.1.105:8080/JavaEEHelloWorld_war_exploded/a.jsp", null);

                        handler.sendEmptyMessage(0x123);
                    }
                }.start();
            }
        });

        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        response = GetPostUtil.sendPost("http://192.168.1.105:8080/JavaEEHelloWorld_war_exploded/login.jsp", "name=crazyit.org&pass=leegang");
                    }
                }.start();
                //发送消息通知UI线程更新UI组件
                handler.sendEmptyMessage(0x123);
            }
        });
    }
}
