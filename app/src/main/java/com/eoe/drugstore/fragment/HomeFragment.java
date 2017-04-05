package com.eoe.drugstore.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eoe.drugstore.R;
import com.eoe.drugstore.utils.DeviceInfoUtil;
import com.eoe.drugstore.utils.Logger;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;


/**
 * 首页
 * Created by Administrator on 2016/3/2.
 */
public class HomeFragment extends ParentFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView---");
        return initView(R.layout.fragment_home, container);
    }

    @Override
    protected void setupView(View v) {
        super.setupView(v);
        TextView tvJni = (TextView) v.findViewById(R.id.tv_jni);
        tvJni.setText(getMsgFromJni());

        TextView tvInfo = (TextView) v.findViewById(R.id.tv_info);
        tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceInfoUtil instance = DeviceInfoUtil.getInstance(mContext);
////        "品牌  : " + instance.getBrand() +
                ((TextView)v).setText("IMEI ：" + instance.getDeviceId() + " IMSI : " + instance.getImsiId() + "\n "
                        + " MAC " + instance.getMacAddress() + "\n"
                        + "  SimSNumber : " + instance.getSimSerialNumber() + "\n"
                        + "  androidID :  " + instance.getAndroidId()
                        + "品牌 " + instance.getBrand() + " android版本   "+ Build.VERSION.SDK_INT);

            }
        });



    }

    static {
        System.loadLibrary("DrugStore");
    }

    public native String getMsgFromJni();
}
