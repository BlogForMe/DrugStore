package com.hyhy.hook;

import com.saurik.substrate.MS;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/31.
 */

public class Main {
    static void initialize() {
        MS.hookClassLoad("com.eoe.drugstore.activity.LoginActivity", new MS.ClassLoadHook() {
            public void classLoaded(Class<?> resources) {
                Method checkLogin;
                try {
//                    checkLogin = resources.getMethod("checkLogin",String.class,String.class);
                    checkLogin = resources.getMethod("isCorrect", String.class);
                } catch (NoSuchMethodException e) {
                    checkLogin = null;
                }

                if (checkLogin != null) {
                    final MS.MethodPointer old = new MS.MethodPointer();

                    MS.hookMethod(resources, checkLogin, new MS.MethodHook() {
                        public Object invoked(Object resources, Object... args)
                                throws Throwable {
                            return true;
                        }
                    }, old);
                }
            }
        });

    }
}
