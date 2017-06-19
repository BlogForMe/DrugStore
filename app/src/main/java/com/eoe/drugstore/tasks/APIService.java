package com.eoe.drugstore.tasks;


import com.eoe.drugstore.bean.BaseEntity;
import com.eoe.drugstore.bean.User;
import com.eoe.drugstore.bean.WeatherModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface APIService {
    String postUrl = "http://192.168.0.126:8080/Demo/";

    @GET("adat/sk/{cityId}.html")
    Observable<WeatherModel> loadDataByRetrofitRxJava(@Path("cityId") String cityId);

    /**
     * testGet1
     *
     * @return
     */
    @GET("https://publicobject.com/helloworld.txt")
    Observable<String> testGet1();


    @GET("http://192.168.0.126:8080/Demo/DemoServlet")
    Observable<String> testGet3();

    @GET("{action}")
        //也可以不用参数
    Observable<String> getData(@Path("action") String action);

    @FormUrlEncoded
    @POST("getUser")
    Observable<BaseEntity<User>> getUser(@FieldMap Map<String, String> map);

}
