package com.eoe.drugstore.activity;

import android.os.Bundle;

import com.eoe.drugstore.R;
import com.eoe.drugstore.httpnet.NetUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WebGetActivity extends ParentActivity {
    OkHttpClient yOkHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_web_get);
    }

    @Override
    protected void sendRequest() {
        super.sendRequest();
        FormBody.Builder builder = new FormBody.Builder();

        FormBody requestBody = builder.add("action", "getBanner")
                .build();
        Request request = new Request.Builder().url(NetUtil.meinuoUrl).post(requestBody).build();
        yOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String stString = response.body().string();
                System.out.println(stString);
            }
        });

    }
}
