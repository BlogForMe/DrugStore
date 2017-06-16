package com.eoe.drugstore.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/6/16.
 */

public class OkHttpHelper {
    private static OkHttpClient okHttpClient;
    /**
     * 连接超时
     */
    private static final int CONNECT_TIMEOUT = 10;
    /**
     * 读取超时
     */
    private static final int READ_TIMEOUT = 25;

    /**
     * 写入超时
     */
    private static final int WRITE_TIMEOUT = 25;

    static {
//        CustomHttpsTrust customHttpsTrust = new CustomHttpsTrust(CertificateManager.trustedCertificatesInputStream());


        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
//                .addInterceptor(new Log)
                .build();

    }

    public static OkHttpClient getClient() {
        return okHttpClient;
    }


}
