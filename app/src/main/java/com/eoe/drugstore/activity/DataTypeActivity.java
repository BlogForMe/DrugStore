package com.eoe.drugstore.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.eoe.drugstore.R;

public class DataTypeActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_type);
    }


    public void overrideType(View source) {
        Intent intent = new Intent();
        //先设置Type属性
//        intent.setType("abc/xyz");
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        showMsg(intent.toString());
    }

    public void overrideData(View source) {
        Intent intent = new Intent();
        //先设置Type属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
        intent.setType("abc/xyz");
        showMsg(intent.toString());
    }

    public void dataAndType(View source) {
        Intent intent = new Intent();
        //先设置Type属性
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/test"), "abc/xyz");
        showMsg(intent.toString());
    }


    public void scheme(View source) {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.crazyit.org:1234/test"));
        startActivity(intent);
    }

}
