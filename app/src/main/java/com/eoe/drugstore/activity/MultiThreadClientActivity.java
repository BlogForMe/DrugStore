package com.eoe.drugstore.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.eoe.drugstore.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MultiThreadClientActivity extends ParentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_multi_thread_client);
    }

    @Override
    protected void setupView() {
        super.setupView();
        findViewById(R.id.tv_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String apkPath = MultiThreadClientActivity.this.getExternalCacheDir() + msgBean.getApp_name();
//                if (isRoot() && !TextUtils.isEmpty(apkPath)) {
//                    isInstalled = install(apkPath);
//                }
            }
        });
    }


    private Boolean install(String apkPath) {
        boolean result = false;
        DataOutputStream dataOutputStream = null;
        BufferedReader errorStream = null;
        try {
            //申请su权限
            Process process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());
            //执行pm install命令
            String command = "pm install -r " + apkPath + "\n";
            dataOutputStream.write(command.getBytes(Charset.forName("utf-8")));
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
            errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String msg = "";
            String line;
            //读取命令执行的结果
            while ((line = errorStream.readLine()) != null) {
                msg += line;
            }

            Log.d("TAG", "intall msg  is" + msg);
            //如果执行结果中包含Failure字样就认为是安装失败，否则安装成功
            if (!msg.contains("Failure") && !msg.contains("expired"))
                result = true;

            Log.i("Qdap", msg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException i) {
            i.printStackTrace();
        } finally {
            try {
                if (dataOutputStream != null)
                    dataOutputStream.close();
                if (errorStream != null)
                    errorStream.close();
            } catch (IOException e) {
                Log.e("TAG", e.getMessage(), e);
            }
        }
        return result;
    }


    @Override
    protected void setupData() {
        super.setupData();
    }


}
