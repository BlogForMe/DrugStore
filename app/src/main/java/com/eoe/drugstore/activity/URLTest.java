package com.eoe.drugstore.activity;

import com.eoe.drugstore.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/**
 * 13.2.1使用URL读取网络资源
 */

public class URLTest extends ParentActivity {

    private Handler handler = new MyHnadler(URLTest.this);
    private ImageView ivUrl;

    static class MyHnadler extends Handler {
        private WeakReference<Context> reference;

        public MyHnadler(Context ctx) {
            reference = new WeakReference<>(ctx);
        }

        @Override
        public void handleMessage(Message msg) {
            Bitmap bm = (Bitmap) msg.obj;
            URLTest urlActivity = (URLTest) reference.get();
            if (urlActivity != null) {
                urlActivity.ivUrl.setImageBitmap(bm);
            }
        }
    }


    private SSLContext sslContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_urltest);
        ivUrl = (ImageView) findViewById(R.id.iv_url);
    }

    private void initCA() throws Exception {
        // Load CAs from an InputStream
        // could be from a resource or ByteArrayInputStream or ...)
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        InputStream caInput = new BufferedInputStream(getAssets().open("zhy_server.cer"));
        Certificate ca;
        try {
            ca = cf.generateCertificate(caInput);
            System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
        } finally {
            caInput.close();
        }
        // Create a KeyStore containing our trusted CAs
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);

        // Create a TrustManager that trusts the CAs in our KeyStore
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);

        // Create an SSLContext that uses our TrustManager
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
    }

    // Create an HostnameVerifier that hardwires the expected hostname.
// Note that is different than the URL's hostname:
// example.com versus example.org
    HostnameVerifier hostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            // Open SSLSocket directly to gmail.com
//            SocketFactory sf = SSLSocketFactory.getDefault();
//            SSLSocket socket = null;
//            try {
//                socket = (SSLSocket) sf.createSocket("192.168.0.126", 8443);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
//            SSLSession s = socket.getSession();

//             hv.verify("192.168.0.126", session);
            return true;
        }
    };

    @Override
    protected void setupData() {
        super.setupData();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    try {
                        initCA();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    String ur = "https://kyfw.12306.cn/otn/";

                    String ur = "https://192.168.0.126:8443/img/pic1.jpg";
                    URL url = new URL(ur);
                    //打开该URL对应的资源的输入流
                    HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                    urlConnection.setSSLSocketFactory(sslContext.getSocketFactory());
                    urlConnection.setHostnameVerifier(hostnameVerifier);
                    InputStream in = urlConnection.getInputStream();
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                    Bitmap bitmp = BitmapFactory.decodeStream(in);
                    Message msg = Message.obtain();
                    msg.obj = bitmp;

                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

}
