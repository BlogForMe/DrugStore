package com.eoe.drugstore.utils;

/**
 * Created by Jon on 2016/4/20.
 */
public class SocketSingleton {
    private static SocketSingleton ourInstance = new SocketSingleton();

    public static SocketSingleton getInstance() {
        return ourInstance;
    }

    private SocketSingleton() {
    }


}
