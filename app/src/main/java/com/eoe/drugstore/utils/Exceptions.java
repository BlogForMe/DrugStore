package com.eoe.drugstore.utils;

/**
 * Created by Administrator on 2017/8/8.
 */

public class Exceptions {
    public static void illegalArgument(String msg, Object... params) {
        throw new IllegalArgumentException(String.format(msg, params));
    }
}
