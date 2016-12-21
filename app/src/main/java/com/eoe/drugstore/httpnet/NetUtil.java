package com.eoe.drugstore.httpnet;

import android.content.Context;
import android.os.Message;

import com.eoe.drugstore.bean.ShopCartBean;
import com.eoe.drugstore.bean.TestBean;
import com.eoe.drugstore.utils.Md5Utils;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by Jon on 2016/3/4.
 * 网络请求工具
 */

public class NetUtil {
        public static String baseUrl = "http://appservicetest.818.com/m.aspx";
//    public static String baseUrl = "http://192.168.132.106/m.aspx";
//    public static String baseUrl = "http://appservice.999yaogou.com/m.aspx";
    public static String meinuoUrl = "http://localhost:8080/web_war_exploded/JsonServlet/";

    public static String key = "818Android20150326@$%&*";
    public static String enKeys = "818*j03DB#lqaXst";


    // 6. 获取购物车商品信息
    public static void getcartRequest(Context context, String uid,
                                      String logincode, int requestId, final HttpOptions ops) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        map.put("logincode", logincode);
        String json = new Gson().toJson(map);
        String urlEncode = null, beforemd5 = null;
        try {
            urlEncode = URLEncoder.encode(json, "UTF-8");
            beforemd5 = json + enKeys;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String aftermd5 = Md5Utils.generatePassword(beforemd5);


        FormBody.Builder builder = new FormBody.Builder();

        FormBody requestBody = builder.add("a", "getcart")
                .add("t", aftermd5)
                .add("r", urlEncode)
                .add("k", key).build();

        OkhttpClientManager.postAsyn(baseUrl, context, new SpotsCallBack<ShopCartBean>(context) {
                    @Override
                    public void onResponse(ShopCartBean response) {
                        super.onResponse(response);
                        Message message = Message.obtain(ops.getUiHandler(), 1, 1003, 0, response);
                        message.sendToTarget();
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                    }
                }, new OkhttpClientManager.Param("a", "getcart"),
                new OkhttpClientManager.Param("t", aftermd5),
                new OkhttpClientManager.Param("r", urlEncode),
                new OkhttpClientManager.Param("k", key));
    }


    public static void testPage(Context context, final HttpOptions ops) {
        HashMap map = new HashMap<String, Object>();
        map.put("pageNumber", "1");
        map.put("channelId", "1");
        map.put("pageSize", "1000");
        map.put("car4sId", "3101003");
        String json = new Gson().toJson(map);
        OkhttpClientManager.postAsyn(baseUrl, context, new SpotsCallBack<List<TestBean>>(context) {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(List<TestBean> response) {
                        Message message = Message.obtain(ops.getUiHandler(), 1, 1003, 0, response);
                        message.sendToTarget();
                    }
                }, new OkhttpClientManager.Param("TXNCODE", "012"),
                new OkhttpClientManager.Param("reqStr", json));


    }
}