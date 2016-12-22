package com.eoe.drugstore.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.httpnet.OkhttpClientManager;
import com.eoe.drugstore.httpnet.ResultCallback;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.PortUnreachableException;
import java.net.URL;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GetUrlActivity extends ParentActivity {
    private ImageView ivShow;
    //代表从网络上下载得到的图片

    MyHandler handler = new MyHandler(this);

    OkHttpClient client = new OkHttpClient();

    private static class MyHandler extends Handler {
        private WeakReference<Context> reference;

        public MyHandler(Context context) {
            this.reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //使用Imageview显示该图片
            GetUrlActivity activity = (GetUrlActivity) reference.get();
            Bitmap bm = (Bitmap) msg.obj;
            activity.ivShow.setImageBitmap(bm);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_get_url);

        try {

            setCertificates(getAssets().open("zhy_server.cer"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setCertificates(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e) {
                }
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init
                    (
                            null,
                            trustManagerFactory.getTrustManagers(),
                            new SecureRandom()
                    );
            SSLSocketFactory ssl = sslContext.getSocketFactory();
            client.newBuilder().sslSocketFactory(ssl);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


   /* public static SSLSocketFactory getSslSocketFactory(InputStream certificates) {
        SSLContext sslContext = null;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Certificate ca = certificateFactory.generateCertificate(certificates);

            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);

            String tmfAlgoryithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgoryithm);
            tmf.init(keyStore);

            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslContext != null ? sslContext.getSocketFactory() : null;
    }*/


    @Override
    protected void setupView() {
        super.setupView();
        ivShow = (ImageView) findViewById(R.id.iv_show);
    }


    public void ivClick(View v) {


        Executors.newCachedThreadPool().submit(new Runnable() {
            @Override
            public void run() {
//                downDirectImgByUrl("https://img42.qumi.com//files//ads//2016-12//753405b992f0b76cfa610341aa6addf7.jpg");
                String url = "https://localhost:8443/test/images.jpg";
                try {
                    String s = crRun(url);
                    System.out.println(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    String crRun(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();


        return response.body().string();
    }


    /**
     * 直接从网络上下载图片
     *
     * @param picUrl
     */

    public Bitmap downDirectImgByUrl(String picUrl) {
        FileOutputStream fos = null;
        InputStream is = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(picUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            is = new BufferedInputStream(conn.getInputStream());
//            is.mark(is.available());
//            BitmapFactory.Options opts = new BitmapFactory.Options();
//            opts.inJustDecodeBounds = true;
//
//            //获取imageview想要显示的宽和高
//            ImageSizeUtil.ImageSize imageViewSize = ImageSizeUtil.getImageViewSize(screenPopsImg);
//            opts.inSampleSize = ImageSizeUtil.caculateInSampleSize(opts, imageViewSize.width, imageViewSize.height);
//            opts.inJustDecodeBounds = false;
//            is.reset();
            bitmap = BitmapFactory.decodeStream(is);
            conn.disconnect();

            Message msg = Message.obtain();
            msg.obj = bitmap;
            handler.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
            }
        }
        return bitmap;
    }


}

