package com.eoe.drugstore.retrofit;

import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.tasks.APIService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.eoe.drugstore.tasks.APIService.HeUrl;
import static com.eoe.drugstore.tasks.APIService.postUrl;

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
