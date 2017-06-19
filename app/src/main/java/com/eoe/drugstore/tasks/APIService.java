package com.eoe.drugstore.tasks;


import com.eoe.drugstore.bean.BaseEntity;
import com.eoe.drugstore.bean.HeWeather;
import com.eoe.drugstore.bean.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/6/15.
 */

public interface APIService {
    String postUrl = "http://192.168.1.105:8080/Demo/";
    String HeUrl = "https://free-api.heweather.com/v5/";


    /**
     * testGet1
     *
     * @return
     */
    @GET("https://publicobject.com/helloworld.txt")
    Observable<String> testGet1();


    @GET("http://192.168.1.105:8080/Demo/DemoServlet")
    Call<ResponseBody> testGet3();

    @GET("{action}")
        //也可以不用参数
    Observable<String> getData(@Path("action") String action);



    @FormUrlEncoded
    @POST("getUser")
    Observable<BaseEntity<List<User>>> getUser(@FieldMap Map<String, String> map);


    /**
     * 少量参数请求
     *
     * @param id
     * @param name
     * @return
     */
    @GET("getUser")
    Observable<BaseEntity<List<User>>> getFieldUser(@Query("id") String id, @Query("name") String name);


    @GET("https://free-api.heweather.com/v5/weather?city=CN101210101&key=87417128802d429091782a8bc733ac5d")
    Observable<HeWeather> getHeWeather();

}
