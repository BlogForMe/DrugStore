package biz.weatherjon.www.retrofit;


import biz.weatherjon.www.net.OkHttpHelper;
import biz.weatherjon.www.tasks.APIService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static biz.weatherjon.www.tasks.APIService.postUrl;


/**
 * Created by Administrator on 2017/6/16.
 */

public class RetrofitFactory {


    private static APIService retrofitService = new Retrofit.Builder()
            .baseUrl(postUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpHelper.getClient())
            .build()
            .create(APIService.class);

    public static APIService getInstance() {
        return retrofitService;
    }

}
