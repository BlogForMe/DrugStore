package com.eoe.drugstore.activity;

import android.os.Bundle;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.PostExample;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Okhttp缓存
 */

public class OkhttpCacheActivity extends ParentActivity {

    OkHttpClient yOkHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_okhttp_cache);


        new Thread(new Runnable() {
            @Override
            public void run() {
                String response = null;
                PostExample example = new PostExample();
                String json = example.bowlingJson("Jesse", "Jake");
                try {
                    response = example.post("http://www.roundsapp.com/post", json);
                    System.out.println(response);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    testCacheResponse();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
    }

    public void testCacheResponse() throws IOException {

        int cacheSize = 10 * 1024 * 1024;

        Cache cache = new Cache(new File("bzh.tmp"), cacheSize);

        yOkHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt").build();

        Response response1 = yOkHttpClient.newCall(request).execute();
        if (!response1.isSuccessful()) throw new IOException("Unexpected code " + response1);

        String response1Body = response1.body().string();
        System.out.println("Response 1 response:          " + response1);
        System.out.println("Response 1 cache response:    " + response1.cacheResponse());
        System.out.println("Response 1 network response:  " + response1.networkResponse());

        Response response2 = yOkHttpClient.newCall(request).execute();
        if (!response1.isSuccessful()) throw new IOException("Unexpected code " + response1);

        String response2Body = response2.body().string();
        System.out.println("Response 2 response:           " + response2);
        System.out.println("Response 2 cache response:     " + response2.cacheResponse());
        System.out.println("Response 2 network response:   " + response2.networkResponse());

        System.out.println("Response 2 equals Response 1 ? " + response1Body.equals(response2Body));
    }
}
