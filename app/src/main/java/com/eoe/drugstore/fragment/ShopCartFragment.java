package com.eoe.drugstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.eoe.drugstore.R;
import com.eoe.drugstore.adapter.ExpandListAdapter;
import com.eoe.drugstore.bean.BaseBean;
import com.eoe.drugstore.bean.ShopCartBean;
import com.eoe.drugstore.httpnet.HttpOptions;
import com.eoe.drugstore.httpnet.NetUtil;
import com.eoe.drugstore.utils.Md5Utils;
import com.google.gson.Gson;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 购物车
 * Created by Administrator on 2016/3/2.
 */
public class ShopCartFragment extends ParentFragment {
    @ViewInject(R.id.elistview)
    private ExpandableListView eListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return initView(R.layout.fragment_shop, null);
    }


    @Override
    protected void setupView(View mContainerView) {
        super.setupView(mContainerView);
        eListView.setGroupIndicator(null);
        eListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                // TODO Auto-generated method stub
                Toast.makeText(mContext, "父类", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        eListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "子类", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    @Override
    protected void setupData() {
        super.setupData();
        getcartRequest(mContext, "13917674553", "3c98265f02b13caf5744d0919936844c", 1002, httpOps);

    }


    public void getcartRequest(Context context, String uid,
                               String logincode, int requestId, final HttpOptions ops) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        map.put("logincode", logincode);
        String json = new Gson().toJson(map);
        String urlEncode = null, beforemd5 = null;
        try {
            urlEncode = URLEncoder.encode(json, "UTF-8");
            beforemd5 = json + NetUtil.enKeys;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String aftermd5 = Md5Utils.generatePassword(beforemd5);


        FormBody.Builder builder = new FormBody.Builder();

        FormBody requestBody = builder.add("a", "getcart")
                .add("t", aftermd5)
                .add("r", urlEncode)
                .add("k", NetUtil.key).build();
        Request request = new Request.Builder().url(NetUtil.baseUrl).post(requestBody).build();

        int cacheSize = 10 * 1024 * 1024;
        Cache cahce = new Cache(new File("bzh.tmp"), cacheSize);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cahce).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String st = response.body().string();
                ShopCartBean shopData = new Gson().fromJson(st, ShopCartBean.class);
                Message msg = new Message();
                msg.obj = shopData;
                handler.sendMessage(msg);
            }
        });
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BaseBean result = (BaseBean) msg.obj;
            setupRequest(1, 1, result);

        }
    };

    @Override
    protected void setupRequest(int requestId, int dataType, BaseBean result) {
        super.setupRequest(requestId, dataType, result);
        List<BaseBean.ResultBean> resultList = result.getResult();
        List<ShopCartBean.ResultdataBean> resultDataList = resultList.get(0).getResultdata();

        eListView.setAdapter(new ExpandListAdapter(mContext,
                resultDataList));
        for (int i = 0; i < resultDataList.size(); i++) {
            eListView.expandGroup(i);
        }
    }

}

