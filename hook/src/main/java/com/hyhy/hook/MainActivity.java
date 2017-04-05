package com.hyhy.hook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hyhy.hook.xposed.MainXposed;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void switchIMEI(View v) {
//        MainXposed.index++;
    }


//    DeviceInfoUtil instance = DeviceInfoUtil.getInstance(this);
////        "品牌  : " + instance.getBrand() +
//        ((TextView) v).setText("IMEI ：" +instance.getDeviceId() + " IMSI : " + instance.getImsiId()  + "\n "
//            + " MAC " +instance.getMacAddress() + "\n"
//            +  "  SimSNumber " + instance.getSimSerialNumber() + "\n"
//            + "  androidID  " + instance.getAndroidId()
//            + "品牌 " + instance.getBrand() );

}
