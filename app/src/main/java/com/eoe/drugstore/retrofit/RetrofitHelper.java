package com.eoe.drugstore.retrofit;

import com.eoe.drugstore.net.OkHttpHelper;
import com.eoe.drugstore.tasks.APIService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/6/16.
 */

public class RetrofitHelper {

    private static Retrofit retrofit;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(APIService.API_SERVER_URL)
                .client(OkHttpHelper.getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .validateEagerly(true)
                .build();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }


}
