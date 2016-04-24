package com.eoe.drugstore.utils;

import android.content.Context;

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

    public JumpSingleton() {
    }
}
