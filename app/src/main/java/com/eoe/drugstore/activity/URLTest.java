package com.eoe.drugstore.activity;

import com.eoe.drugstore.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.Executors;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

/**
 * 13.2.1使用URL读取网络资源
 */

public class URLTest extends AppCompatActivity {

    private Handler handler = new MyHnadler(URLTest.this);
    private ImageView ivUrl;
    private TextView tvScr;
    private String qumi_CAs = "-----BEGIN CERTIFICATE-----\n" +
            "MIIE3TCCA8WgAwIBAgIQIj7nya9qVgXbjY+MmJr0dTANBgkqhkiG9w0BAQsFADBT\n" +
            "MQswCQYDVQQGEwJDTjEaMBgGA1UEChMRV29TaWduIENBIExpbWl0ZWQxKDAmBgNV\n" +
            "BAMMH0NBIOayg+mAmiBJViDmnI3liqHlmajor4HkuaYgRzIwHhcNMTUxMjAzMDAz\n" +
            "NzM4WhcNMTcxMjAzMDAzNzM4WjBeMQswCQYDVQQGEwJDTjESMBAGA1UECAwJ5Zub\n" +
            "5bed55yBMRIwEAYDVQQHDAnljZfpg6jljr8xEjAQBgNVBAoMCeeGiuWeoOmSsTET\n" +
            "MBEGA1UEAwwKKi5xdW1pLmNvbTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoC\n" +
            "ggEBAOOzGnpVEQLZp7tdrlTJsqdSHj/3E/x7L2xgUMDScRxYThN6fDL9CpFuVGaB\n" +
            "FY1hTp0a4hi/uaiy87TkO0drhQ3xKwbHdbzvopNTWKAstW/+WmoDL+kZ13CloTZO\n" +
            "bRV6bjgGA8en4LweYhEoA2S2e13A8zFy08ZV0/DcWxgWGNS1cKnARbzvAPHj7+am\n" +
            "wO6MCJds8c1VxItV10LQt4Y0dn76PjdUYoy7y1sZZfGkXKE2Ot4kTUF/+7YKsLkT\n" +
            "G4Yr+X9P8jos01FjImCtyKa+afIpV2YfFCknvgF1tgfbrtZCq8QdW67z3d9Cy6z5\n" +
            "9Sjmhcg08PcQP1deHvHqF5eLcXkCAwEAAaOCAaAwggGcMAsGA1UdDwQEAwIFoDAd\n" +
            "BgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwEwCQYDVR0TBAIwADAdBgNVHQ4E\n" +
            "FgQUnsvWjbvPNpe/IVlZ47PKUPw1v+gwHwYDVR0jBBgwFoAUMTCotd+qvnHMz9Pb\n" +
            "hXeXz47c8gwwdQYIKwYBBQUHAQEEaTBnMDAGCCsGAQUFBzABhiRodHRwOi8vb2Nz\n" +
            "cDIud29zaWduLmNuL2NhMmcyL3NlcnZlcjIwMwYIKwYBBQUHMAKGJ2h0dHA6Ly9h\n" +
            "aWEyLndvc2lnbi5jbi9jYTJnMi5zZXJ2ZXIyLmNlcjA5BgNVHR8EMjAwMC6gLKAq\n" +
            "hihodHRwOi8vY3JsczIud29zaWduLmNuL2NhMmcyLXNlcnZlcjIuY3JsMB8GA1Ud\n" +
            "EQQYMBaCCioucXVtaS5jb22CCHF1bWkuY29tMFAGA1UdIARJMEcwCAYGZ4EMAQID\n" +
            "MDsGDCsGAQQBgptRAwICBjArMCkGCCsGAQUFBwIBFh1odHRwOi8vd3d3Lndvc2ln\n" +
            "bi5jb20vcG9saWN5LzANBgkqhkiG9w0BAQsFAAOCAQEADPMi5pj/suItGdmgJ2SY\n" +
            "LrHY+JL7Rt/FL45wtpXmHgVL2bYbD+swsm5BeJ6GWs5mmfbLwNQSimUZKU6hIlvm\n" +
            "FZirvelhnC5hpoMncONZDFA6lbYrcNQM7drIPBu2xJzHuasNl8pvXvVcW7f/wHsz\n" +
            "CSf98BxSD8xnlrKrmGl3o5Bi+Cy0wMPD/F+9Rs8Ma06+fqE6IiFUAsi8vF0SGTsK\n" +
            "WUxCQJ8L6tTaBaLKDZOUbGe76NaVHLneAzR9vWiCQ3PGJbV8kdZgxhB/ZJFaNj7b\n" +
            "0RJggWfS5/jyKh2MPMH/zn7t312VyPXlQbRVi3DrFh6IvCQt+Z7IhIHEk0VjfQnH\n" +
            "zw==\n" +
            "-----END CERTIFICATE-----\n" +
            "\n" +
            "-----BEGIN CERTIFICATE-----\n" +
            "MIIFkjCCA3qgAwIBAgIQByZfj8m4+InqmY/xI12/pTANBgkqhkiG9w0BAQsFADBG\n" +
            "MQswCQYDVQQGEwJDTjEaMBgGA1UEChMRV29TaWduIENBIExpbWl0ZWQxGzAZBgNV\n" +
            "BAMMEkNBIOayg+mAmuagueivgeS5pjAeFw0xNDExMDgwMDU4NThaFw0yOTExMDgw\n" +
            "MDU4NThaMFMxCzAJBgNVBAYTAkNOMRowGAYDVQQKExFXb1NpZ24gQ0EgTGltaXRl\n" +
            "ZDEoMCYGA1UEAwwfQ0Eg5rKD6YCaIElWIOacjeWKoeWZqOivgeS5piBHMjCCASIw\n" +
            "DQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBALAUbKiXsykuUXvhDIxuQGXUJ1EO\n" +
            "aznM/48FxUOcusW8wjudlDjv5OmktVOBKTAYuCDA1CJNFRJoKtkMpQdDU5p5XNJw\n" +
            "RL4fLK4ksO/QNzZqxXjEAaNxol+GmYGAxVa4nc+mL8S6kPseMNCqsfnTTjTL4Wcu\n" +
            "rN3TAJoJ92DGfsIGxyblrDQGR7N3dcId/7/L9wa74Er7ShRj0wcOd3zrPYh697vv\n" +
            "FsoWgvmPEDvL2+WzQx12HUgIYia07SP2q17Lv5lPl6K88nLarGtZzRfdr6jOBTLA\n" +
            "h5Ajx84AjPlBV6u9h2EPlSLwP68XAq2yaPLB/AQSMdPG+2DSWM49iZpwj6ECAwEA\n" +
            "AaOCAW0wggFpMA4GA1UdDwEB/wQEAwIBBjAdBgNVHSUEFjAUBggrBgEFBQcDAgYI\n" +
            "KwYBBQUHAwEwEgYDVR0TAQH/BAgwBgEB/wIBADAvBgNVHR8EKDAmMCSgIqAghh5o\n" +
            "dHRwOi8vY3JsczIud29zaWduLmNuL2NhMi5jcmwwawYIKwYBBQUHAQEEXzBdMCYG\n" +
            "CCsGAQUFBzABhhpodHRwOi8vb2NzcDIud29zaWduLmNuL2NhMjAzBggrBgEFBQcw\n" +
            "AoYnaHR0cDovL2FpYTIud29zaWduLmNuL2NhMmcyLXNlcnZlcjIuY2VyMB0GA1Ud\n" +
            "DgQWBBQxMKi136q+cczP09uFd5fPjtzyDDAfBgNVHSMEGDAWgBTgTb/cm0FdE+hk\n" +
            "8KfpFaThgcG6MTBGBgNVHSAEPzA9MDsGDCsGAQQBgptRAwICBjArMCkGCCsGAQUF\n" +
            "BwIBFh1odHRwOi8vd3d3Lndvc2lnbi5jb20vcG9saWN5LzANBgkqhkiG9w0BAQsF\n" +
            "AAOCAgEAsS3pk/uoE1iBF6CD/g615awZGrpYgHN+LmdNo37KyM8602joKClLhqqR\n" +
            "6xcwixHq613dfQ8zG2Vk/bI0hzeGH2GDhg9MgIC5owFhlOvKufifAM2JPAIzj8Ar\n" +
            "Z3T35LnAaDHD2U58QZP2b5L63mZ4Qrm6m+nwwIEf45s0RbO5h2fevB2rwSfyFYW4\n" +
            "zZvOmTknqTLKIFI1mINsHM0ciAc3rRRK0xM9pNwEGfrFPsub9t5aCS8DJVLqLiJu\n" +
            "jMjPopTwSnwRBypdA5HYjjnSgZVBPVSl13kpOIpTaYyVhl5a11hDH9zwOcCs9OMr\n" +
            "IgsgNsnLfLZUCt6qyU9ARzhJOyxBZ9CRjwDXBneMecz6uP5yioN6kqBLbjTwetEt\n" +
            "O62g5OAI9ZdsvY12SBn4N8wveGjPN9lVFtZO49CoBIcp3NS+OisRiDWJMQzWsdzl\n" +
            "MqphcgbUE2RlpcqiFeU3DyNoIbVUhu7Q6TJGjbeIomLsNK044ykyTiF/RbfvO75v\n" +
            "JF0r6BdKjljX6hnShB7I7MeJShjD/AgyAgmBEIkoq7L1k8xPVYaW8TTaf0TW2y9l\n" +
            "Faz1/RlFb8ED3Cv/67IsyyoD7BYSHlyAB341382JBAkCe4/Y/BIRYf8qwMnDdhUX\n" +
            "2NtmugBolCUGJmBXVpe8ygFQQ4QBDRIsov5vlbwtXer6ZRp0Qpc=\n" +
            "-----END CERTIFICATE-----\n" +
            "\n" +
            "-----BEGIN CERTIFICATE-----\n" +
            "MIIGTTCCBDWgAwIBAgIHH86n9ql/6TANBgkqhkiG9w0BAQsFADB9MQswCQYDVQQG\n" +
            "EwJJTDEWMBQGA1UEChMNU3RhcnRDb20gTHRkLjErMCkGA1UECxMiU2VjdXJlIERp\n" +
            "Z2l0YWwgQ2VydGlmaWNhdGUgU2lnbmluZzEpMCcGA1UEAxMgU3RhcnRDb20gQ2Vy\n" +
            "dGlmaWNhdGlvbiBBdXRob3JpdHkwHhcNMDYwOTE3MjI0NjM2WhcNMTkxMjMxMjM1\n" +
            "OTU5WjBGMQswCQYDVQQGEwJDTjEaMBgGA1UEChMRV29TaWduIENBIExpbWl0ZWQx\n" +
            "GzAZBgNVBAMMEkNBIOayg+mAmuagueivgeS5pjCCAiIwDQYJKoZIhvcNAQEBBQAD\n" +
            "ggIPADCCAgoCggIBANBJIR4l/IfBKsKs23aGBk7n0HQ03O1lNfxQ1og/pPB/6w9f\n" +
            "eS+Jsf28Y1g3k5s4+LdbqfrYcce0vICXjWxL8VDVKimqqBl6luaVjnTtlwpXdfQF\n" +
            "220LObkBf6r21tps5gXgpE1S/NvQdLcRjHuNT/+Hg67/BQMTV1A3/oyWUhBMX7+U\n" +
            "cWnZlj4MQ0++MMCfOXRPBkVdo9ZWOWgHzIdPUHeTcdlECLGKNOmJrNubTuHZ5FJF\n" +
            "jC4UH5FrGR1oKSxWxOIeE1dk8GHjuRHfsOFXoBut11/Rr9srLT/QaI4P6p8PizVY\n" +
            "GxMc9N41oQpd1urfEm/A+2kHRnLcgfYEIxfgTXXhcm+wKOub4eGDoZ9KXa/Mm/oC\n" +
            "ILYYYneRO6PVZa3cfJB3HERBpEqL65Vy6fYJZNyoLZ90eOjBogljnO+g20+dlasg\n" +
            "T7ew94dcpqDkNzjHXOM1Dyyto4Ci7C5dwM/tiwXC5nNu9onV9dJGjuptYxseisl9\n" +
            "pvic6+XVY4VNc2ZpEf7IDvTBx2ZJU37kGWvx6XpZo21+xRfmJ8bvG9tv/A1NBgG0\n" +
            "DlwwRlVgrzhlOspHuqwszEYfskaWP/PtJgXud6Fqa34tbVhcStSOZ7jx2tVGiif5\n" +
            "EfLJQv5O3t8fXMSkhocWM6GnFxilDeQF5SvCKwuilZC5/WA8Tok+55zuH7sBAgMB\n" +
            "AAGjggEHMIIBAzASBgNVHRMBAf8ECDAGAQH/AgECMA4GA1UdDwEB/wQEAwIBBjAd\n" +
            "BgNVHQ4EFgQU4E2/3JtBXRPoZPCn6RWk4YHBujEwHwYDVR0jBBgwFoAUTgvvGqRA\n" +
            "W6UXaYcwyjRoQ9BBrvIwaQYIKwYBBQUHAQEEXTBbMCcGCCsGAQUFBzABhhtodHRw\n" +
            "Oi8vb2NzcC5zdGFydHNzbC5jb20vY2EwMAYIKwYBBQUHMAKGJGh0dHA6Ly9haWEu\n" +
            "c3RhcnRzc2wuY29tL2NlcnRzL2NhLmNydDAyBgNVHR8EKzApMCegJaAjhiFodHRw\n" +
            "Oi8vY3JsLnN0YXJ0c3NsLmNvbS9zZnNjYS5jcmwwDQYJKoZIhvcNAQELBQADggIB\n" +
            "AI274T7wqbpK6IUpiNBGwjQCnLQYCkkOse9rVge7hwFTdK2gpoA1bNcBmrmEubOP\n" +
            "jRBVHNhW+bXyJIc+UBs8RdjcgJMmGHSVhMPs2zvncMwx5b2FHvr4ajWwXcL3INlF\n" +
            "vwJYifZgzi9FSe+Xg9KLqfQMSZNCpIop57BJ8F/hhnWcmjNvCtPod9jaV91SMy/R\n" +
            "xN6FfVNV8V/TJNYlJYNjLF9xSHxgpLYu5WHPFzHzyFdPlDdtWZbgoTyXJ0zKwsMV\n" +
            "w1zS6WDAGRWHgWlRRXPbmBSBPhXk5JfSBLX8M/uHJGl1t6frghUdSqw7EiOJn7T8\n" +
            "JE7dIsi3zx462waTg7jKDLpzC34/PEvPYcF7X5pybb/TQVjjGzWZg61sQERjfN7B\n" +
            "ePHm6SGg74pOkX4XVVuX8SnaH/Y+dTmaZfGJKDs50PU7PpF5qA2x1FaeIFuzklqt\n" +
            "H4DHm6uaOsO5HOIWstKhtlH9xnb2l9vxF581/Tlxea6OUtHfk4J7GvGcowyADI8g\n" +
            "7OOYkS8e9GQ2DBVqacq0VrnIFA0uAXGTL27Oh6VYFmZ61MjVEhXF5y4yHQ8KFpQK\n" +
            "vFCV0S6lX0VqalP0cPBCUftf1L8qBqy5FMQDhlET6Lwh0FT1iTvz03xlQMRZBzyS\n" +
            "EkE9+JcNYJ8zFJKmjFvuStRRmMJTdkorYuwFw2tQZLFs\n" +
            "-----END CERTIFICATE-----\n";
    String scry = "-----BEGIN CERTIFICATE-----\n" +
            "MIICmjCCAgOgAwIBAgIIbyZr5/jKH6QwDQYJKoZIhvcNAQEFBQAwRzELMAkGA1UE\n" +
            "BhMCQ04xKTAnBgNVBAoTIFNpbm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5\n" +
            "MQ0wCwYDVQQDEwRTUkNBMB4XDTA5MDUyNTA2NTYwMFoXDTI5MDUyMDA2NTYwMFow\n" +
            "RzELMAkGA1UEBhMCQ04xKTAnBgNVBAoTIFNpbm9yYWlsIENlcnRpZmljYXRpb24g\n" +
            "QXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCB\n" +
            "iQKBgQDMpbNeb34p0GvLkZ6t72/OOba4mX2K/eZRWFfnuk8e5jKDH+9BgCb29bSo\n" +
            "tqPqTbxXWPxIOz8EjyUO3bfR5pQ8ovNTOlks2rS5BdMhoi4sUjCKi5ELiqtyww/X\n" +
            "gY5iFqv6D4Pw9QvOUcdRVSbPWo1DwMmH75It6pk/rARIFHEjWwIDAQABo4GOMIGL\n" +
            "MB8GA1UdIwQYMBaAFHletne34lKDQ+3HUYhMY4UsAENYMAwGA1UdEwQFMAMBAf8w\n" +
            "LgYDVR0fBCcwJTAjoCGgH4YdaHR0cDovLzE5Mi4xNjguOS4xNDkvY3JsMS5jcmww\n" +
            "CwYDVR0PBAQDAgH+MB0GA1UdDgQWBBR5XrZ3t+JSg0Ptx1GITGOFLABDWDANBgkq\n" +
            "hkiG9w0BAQUFAAOBgQDGrAm2U/of1LbOnG2bnnQtgcVaBXiVJF8LKPaV23XQ96HU\n" +
            "8xfgSZMJS6U00WHAI7zp0q208RSUft9wDq9ee///VOhzR6Tebg9QfyPSohkBrhXQ\n" +
            "envQog555S+C3eJAAVeNCTeMS3N/M5hzBRJAoffn3qoYdAO1Q8bTguOi+2849A==\n" +
            "-----END CERTIFICATE-----";

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
//                urlActivity.tvScr.setText(msg.obj.toString());
            }
        }
    }

    private SSLContext sslContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urltest);
        ivUrl = (ImageView) findViewById(R.id.iv_url);
//        tvScr = (TextView) findViewById(R.id.tv_scr);
        setData();
    }


    /**
     * 下载CA
     *
     * @throws Exception
     */
    private void initCA() throws Exception {
        // Load CAs from an InputStream
        // could be from a resource or ByteArrayInputStream or ...)
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//        InputStream caInput = new BufferedInputStream(getAssets().open("srca.cer"));
        //
        ByteArrayInputStream caInput = new ByteArrayInputStream(qumi_CAs.getBytes());
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

        /**
         * 双向认证
         */
//        KeyStore clientKeyStore = KeyStore.getInstance(keyStoreType);
//        clientKeyStore.load(mContext.getAssets().open("client.bks"), "123456".toCharArray());
//        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        keyManagerFactory.init(clientKeyStore, "123456".toCharArray());
//        sslContext.init(keyManagerFactory.getKeyManagers(), tmf.getTrustManagers(), null);
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

    protected void setData() {
        Executors.newCachedThreadPool().submit(new Runnable() {
            @Override
            public void run() {
                try {
                    initCA();
//                    String ur = "https://kyfw.12306.cn/otn/";
//                    String ur = "https://img42.qumi.com//files//ads//2016-10//4d59068a80a583c63c1da16b91671f82.jpg";
                    String ur = "http://www.hyhy.tech/lamp.gif";

//                    String ur = "https://192.168.0.126:8443/img/pic1.jpg";
                    URL url = new URL(ur);
                    //打开该URL对应的资源的输入流
                    HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                    urlConnection.setSSLSocketFactory(sslContext.getSocketFactory()); //前面initCA()方法就是为这里铺垫
//                    urlConnection.setHostnameVerifier(hostnameVerifier);
                    InputStream in = urlConnection.getInputStream();
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));

//                    StringBuilder sb = new StringBuilder();
//                    String s;
//                    while ((s = bf.readLine()) != null) {
//                        sb.append(s + "\n");
//                    }
                    Bitmap bitmp = BitmapFactory.decodeStream(in);
                    Message msg = Message.obtain();
                    msg.obj = bitmp;
                    handler.sendMessage(msg);
                    bf.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
