package com.hyhy.hook.Device;


import android.content.ContentResolver;
import android.util.Log;

import com.saurik.substrate.MS;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/22.
 */

public class Main {
    static final String key = "sys.rw.Deviceindex";
    static int index = 0;

    static int addIndex() {
        return index++;
    }

    static int getIndex() {
        return index;
    }

    static int getRandomIndex() {
        Random random = new Random();
        int number = random.nextInt(20);
        return number;
    }


    static int readIndex() {
        String index = read(key);
        int in;
        try {
            in = Integer.parseInt(index);
        } catch (NumberFormatException e) {
            return 0;
        }
        return in;
    }

    private static String read(String key) {
        Class SystemProperties;
        try {
            SystemProperties = Class.forName("android.os.SystemProperties");
            Class[] paramTypes = new Class[1];
            paramTypes[0] = String.class;
            Method get = SystemProperties.getMethod("get", paramTypes);
            Object[] params = new Object[1];
            params[0] = new String(key);
            return (String) get.invoke(SystemProperties, params);
        } catch (ClassNotFoundException e) {

        } catch (NoSuchMethodException n) {

        } catch (Exception e) {

        }
        return "null";
    }


    static void initialize() {
        MS.hookClassLoad("android.os.SystemProperties", new MS.ClassLoadHook() {
            @Override
            public void classLoaded(Class<?> aClass) {
                Method methodGetBM;
                try {
                    methodGetBM = aClass.getMethod("get", String.class, String.class);
                } catch (NoSuchMethodException e) {
                    methodGetBM = null;
                    e.printStackTrace();
                }
                if (methodGetBM != null) {
                    final MS.MethodPointer old = new MS.MethodPointer();
                    MS.hookMethod(aClass, methodGetBM, new MS.MethodHook() {

                        @Override
                        public Object invoked(Object o, Object... args) throws Throwable {
                            Log.i("Main", "参数" + String.valueOf(args[0]));
                            if ("ro.product.brand".equals(String.valueOf(args[0]))) {
                                int index = readIndex();
                                return brands[index];
                            }
//                            if ("ro.product.model".equals(String.valueOf(args[0]))) {
//                                int index = readIndex();
//                                return models[index];
//                            }
                            return old.invoke(o, args);
                        }
                    }, old);

                }
            }
        });


        /**
         * 修改 IMEI 、IMSI 、SimSerialNumber
         */
        MS.hookClassLoad("android.telephony.TelephonyManager", new MS.ClassLoadHook() {
            @Override
            public void classLoaded(Class<?> aClass) {
                // hook getSubscriberId
                Method methodGetIMEI, methodGetIMSI, methodGetSimSN;
                try {
                    //methodGetIMEI
                    methodGetIMEI = aClass.getMethod("getDeviceId", new Class<?>[0]);
                    methodGetIMSI = aClass.getMethod("getSubscriberId", new Class<?>[0]);
                    methodGetSimSN = aClass.getMethod("getSimSerialNumber", new Class<?>[0]);
                } catch (NoSuchMethodException e) {
                    methodGetIMEI = null;
                    methodGetIMSI = null;
                    methodGetSimSN = null;
                }
                if (methodGetIMEI != null) {
                    final MS.MethodPointer old = new MS.MethodPointer();
                    MS.hookMethod(aClass, methodGetIMEI, new MS.MethodHook() {
                        @Override
                        public Object invoked(Object o, Object... args) throws Throwable {
                            int index = readIndex();
                            return deviceIds[addIndex()];
                        }
                    }, old);
                }

                if (methodGetIMSI != null) {
                    final MS.MethodPointer old = new MS.MethodPointer();
                    MS.hookMethod(aClass, methodGetIMSI, new MS.MethodHook() {
                        @Override
                        public Object invoked(Object o, Object... args) throws Throwable {
                            int index = readIndex();
                            return imsis[getIndex()];
                        }
                    }, old);
                }

                if (methodGetSimSN != null) {
                    final MS.MethodPointer old = new MS.MethodPointer();
                    MS.hookMethod(aClass, methodGetSimSN, new MS.MethodHook() {

                        @Override
                        public Object invoked(Object o, Object... objects) throws Throwable {
                            return simseris[getIndex()];
                        }
                    }, old);
                }


            }
        });

        /**
         * 修改mac地址
         */
        MS.hookClassLoad("android.net.wifi.WifiInfo", new MS.ClassLoadHook() {
            @Override
            public void classLoaded(Class<?> aClass) {

                Method methodGetMAC;
                try {
                    methodGetMAC = aClass.getMethod("getMacAddress", new Class<?>[0]);
                } catch (NoSuchMethodException e) {
                    methodGetMAC = null;
                }
                if (methodGetMAC != null) {
                    final MS.MethodPointer old = new MS.MethodPointer();
                    MS.hookMethod(aClass, methodGetMAC, new MS.MethodHook() {
                        @Override
                        public Object invoked(Object o, Object... objects) throws Throwable {

                            return macs[getIndex()];
                        }
                    }, old);
                }

            }
        });


        /**
         * 修改androidID
         */
        MS.hookClassLoad("android.provider.Settings$Secure", new MS.ClassLoadHook() {
            @Override
            public void classLoaded(Class<?> aClass) {
                Method methodGetAndroidId;
                try {
                    methodGetAndroidId = aClass.getMethod("getString", ContentResolver.class, String.class);
                } catch (NoSuchMethodException e) {
                    methodGetAndroidId = null;
                }
                if (methodGetAndroidId != null) {
                    final MS.MethodPointer old = new MS.MethodPointer();
                    MS.hookMethod(aClass, methodGetAndroidId, new MS.MethodHook() {
                        @Override
                        public Object invoked(Object o, Object... args) throws Throwable {
//                            if ("android_id".equals(String.valueOf(args[1]))) {
//                            Log.i("android_id", "输出id   " + andIds[getIndex()]);
                            int index = readIndex();
                            return andIds[getIndex()];
//                            }
//                            return old.invoke(o, args);
                        }
                    }, old);
                }

            }
        });





    }


    static final String[] deviceIds = IMEI.data;
    static final String[] imsis = IMSI.data;
    static final String[] macs = MAC.data;
    static final String[] simseris = SER.data;
    static final String[] andIds = AndId.data;
    static final String[] brands = Brand.data;
    static final String[] models = Model.data;


}
