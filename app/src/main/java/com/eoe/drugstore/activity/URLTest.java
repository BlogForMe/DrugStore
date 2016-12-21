package com.eoe.drugstore.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.eoe.drugstore.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 13.2.1使用URL读取网络资源
 */

public class URLTest extends ParentActivity {

    private ImageView ivUrl;
    private Bitmap bitmap; //从网络上下载得到的图片

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                //使用ImageView显示该图片
                ivUrl.setImageBitmap(bitmap);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_urltest);
    }

    @Override
    protected void setupView() {
        super.setupView();
        ivUrl = (ImageView) findViewById(R.id.iv_url);
    }



    @Override
    protected void setupData() {
        super.setupData();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    //定义一个URL对象
                    URL url = new URL("http://192.168.1.105:8080/JavaEEHelloWorld_war_exploded/hehe.jpg");
                    //打开该URL对应的资源的输入流
                    InputStream is = url.openStream();
                    //从inputstream解析出图片
                    bitmap = BitmapFactory.decodeStream(is);
                    //发送消息通知UI组件显示该图片
                    handler.sendEmptyMessage(0x123);
                    is.close();
                    //再次打开URL对应的资源的输入流
                    is = url.openStream();
                    //打开手机文件对应的输出流
                    OutputStream os = openFileOutput("crazyit.jpg", MODE_APPEND);
                    byte[] buff = new byte[1024];
                    int hasRead = 0;
                    //将URL对应的资源下载到本地
                    while ((hasRead = is.read(buff)) > 0) {
                        os.write(buff, 0, hasRead);
                    }
                    is.close();
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}
