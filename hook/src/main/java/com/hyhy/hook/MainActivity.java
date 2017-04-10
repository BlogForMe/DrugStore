package com.hyhy.hook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hyhy.hook.activity.BindingActivity;
import com.hyhy.hook.utils.Constants;
import com.hyhy.hook.utils.DbUtil;
import com.hyhy.hook.xposed.MainXposed;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sp = getSharedPreferences("prefs", Context.MODE_WORLD_READABLE);
        sp.edit().putString("packages", "jon").commit();
    }


    public void switchIMEI(View v) {
        DbUtil.getDbInstance(this);
        Toast.makeText(this, "弹出", Toast.LENGTH_SHORT).show();
//        MainXposed.index++;
    }

    public void bt_message(View v) {
        Intent intent = new Intent(this, BindingActivity.class);
        startActivity(intent);
    }


//    DeviceInfoUtil instance = DeviceInfoUtil.getInstance(this);
////        "品牌  : " + instance.getBrand() +
//        ((TextView) v).setText("IMEI ：" +instance.getDeviceId() + " IMSI : " + instance.getImsiId()  + "\n "
//            + " MAC " +instance.getMacAddress() + "\n"
//            +  "  SimSNumber " + instance.getSimSerialNumber() + "\n"
//            + "  androidID  " + instance.getAndroidId()
//            + "品牌 " + instance.getBrand() );

}
