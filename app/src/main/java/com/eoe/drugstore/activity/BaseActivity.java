package com.eoe.drugstore.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.eoe.drugstore.widget.Controller;


/**
 * Created by ZhangGuanghua on 2016/3/4.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected static final String TAG = "BaseActivity";

    protected Context mContext;
    /**
     * HTTP请求数据主控制类
     */
    protected Controller mController = null;
    protected final String STRING_PARAMS = "String_params";
    protected final String STRING_LPARAMS = "String_lparams";
    protected final String STRING_HPARAMS = "String_hparams";
    protected static final String STRING_INDEX = "String_index";
    protected final String STRING_MAP = "string_map";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.i(TAG, "class name = " + this.getClass().getName());
    }

    protected void init(int layoutId) {
        this.mContext = this;
//        mController = Controller.getInstance();
//        mController.setCurrentActivity(mContext);

        setContentView(layoutId);

        setupView();
        setupData();
        sendRequest();
    }

    protected abstract void sendRequest();

    protected abstract void setupData();

    protected abstract void setupView();

    protected abstract void setupRequest(int requestId, int dataType,
                                         Message msg);

    protected void jumpNextpage(Class<?> name, Boolean finshFlag) {
        Intent intent = new Intent(this, name);
        startActivity(intent);
        if (finshFlag) {
            finish();
        }
    }
}



