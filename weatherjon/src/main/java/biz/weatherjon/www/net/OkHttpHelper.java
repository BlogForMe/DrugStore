package biz.weatherjon.www.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

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
        //添加一个log拦截器,打印所有的log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //可以设置请求过滤的水平,body,basic,headers
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
//                        builder.addHeader("token", "abc");
                        return chain.proceed(builder.build());
                    }
                })
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
