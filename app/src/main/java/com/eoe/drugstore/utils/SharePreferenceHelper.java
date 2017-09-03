package com.eoe.drugstore.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jon on 17-9-3.
 */

public class SharePreferenceHelper {
    private static SharedPreferences preferences;
    private final SharedPreferences.Editor editor;
    public final static String SPFILE = "tokenFile";
    public final static String SP_KEY_TOKEN = "TOKEN";

    public SharePreferenceHelper(Context context, String fileName) {
        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }


    /**
     * 存入数据
     *
     * @param key
     * @param value 数据
     * @param <T>   类型
     */
    public <T> void put(String key, T value) {
        if (value instanceof String) {
            editor.putString(key, String.valueOf(value));
            editor.commit();
        }
    }

    /**
     * 获取数据
     *
     * @param key
     * @param type
     * @param <T>
     * @return
     */
    public <T> T get(String key, T type) {
        if (type instanceof String) {
            return (T) preferences.getString(key, "");
        }
        return null;
    }
}
