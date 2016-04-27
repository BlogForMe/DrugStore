package com.eoe.drugstore.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/4/22.
 */
public class JumpSingleton {
    private static Context context;
    private static JumpSingleton jumpSingleton = new JumpSingleton();

    public static JumpSingleton getInstance(Context con) {
        context = con;
        return jumpSingleton;
    }

    public void JumpNextAcitivy(Class<?> name, boolean finishFlag) {
        Intent intent = new Intent(context, name);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        ((Activity) context).startActivity(intent);
        if (finishFlag) {
            ((Activity) context).finish();
        }
    }
}
