package com.eoe.drugstore.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eoe.drugstore.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jon on 2016/4/17.
 * 练习构建Fragment
 *
 * 用handler下载图片
 */
public class HeadlinesFragment extends BaseFragment {
    private static final String TAG = "DOWNLOADhANDLER";
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(R.layout.fragment_community, null);
    }

    @Override
    protected void setupView(View v) {
        imageView = (ImageView) v.findViewById(R.id.iv_img);

    }


    @Override
    protected void setupData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = handler.obtainMessage();
                Looper.prepare();  //初始化消息队列
                Message meage = updateMsg(msg);
                handler.sendMessage(meage);
            }
        }).start();


    }

    private Message updateMsg(Message msg) {
        String url = "http://www.hyhy.tech/he.jpg";

        Bitmap img = DownImage(url);
        Bundle data = new Bundle();
        data.putParcelable("img", img);
        msg.setData(data);
        return  msg;
    }


    private Bitmap DownImage(String url) {
        Bitmap img = null;
        try {
            URL murl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) murl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            img = BitmapFactory.decodeStream(is);
        } catch (IOException e) {

        }
        return img;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap img = msg.getData().getParcelable("img");

            imageView.setImageBitmap(img);

        }
    };

}
