package com.eoe.drugstore.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.eoe.drugstore.R;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;


public class GetUrlActivity extends ParentActivity {
    private ImageView ivShow;
    //代表从网络上下载得到的图片
    private Bitmap bitmap;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                //使用Imageview显示该图片
                ivShow.setImageBitmap(bitmap);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_get_url);
    }

    @Override
    protected void setupView() {
        super.setupView();
        ivShow = (ImageView) findViewById(R.id.iv_show);
    }

    @Override
    protected void setupData() {
        super.setupData();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    URL url = new URL("http://www.hyhy.tech/he.jpg");
                    InputStream is = url.openStream();
                    //从inputstream中解析出图片
                    bitmap = BitmapFactory.decodeStream(is);
                    //发送消息、通知UI组件显示该图片
                    handler.sendEmptyMessage(0x123);
                    is.close();

                    //再次打开URL对应的资源的输入流
                    is = url.openStream();
                    //打开手机文件对应的输出流
                    FileOutputStream os = openFileOutput("hehe.jpg", TRIM_MEMORY_MODERATE);
                    byte[] buff = new byte[1024];
                    int hasRead = 0;
                    //将URL对应的资源下载到本地
                    while ((hasRead = is.read(buff)) > 0)
                        os.write(buff, 0, hasRead);
                    is.close();
                    os.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}

