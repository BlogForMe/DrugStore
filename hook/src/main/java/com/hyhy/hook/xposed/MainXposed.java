package com.hyhy.hook.xposed;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import com.hyhy.hook.Device.IMEI;
import com.hyhy.hook.utils.HTool;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.PrivilegedAction;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedBridge.getXposedVersion;
import static de.robv.android.xposed.XposedBridge.log;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

/**
 * Created by jon on 17-4-4.
 */

public class MainXposed implements IXposedHookLoadPackage {
    public static int index = 0;

    private Context mContext;

    static int addIndex() {
        return index++;
    }

    static int getIndex() {
        return index;
    }

    XC_MethodHook hookCallBack(final String methodGet) {

        return new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                switch (methodGet) {
                    case "IMEI":
                        Object obj = param.getResult();
                        param.setResult(IMEI.data[index]);
                        Log.i("jw", "obj af" + obj);
                        break;
                    case "IMSI":
                        param.setResult("imsi");
                        break;
                    case "SimSerialNumber":
                        param.setResult("SimSerialNumber");
                        break;
                    case "MacAddress":
                        param.setResult("MacAddress");
                        break;
                    case "ANDROIDID":
                        param.setResult("ANDROIDID");
                        break;
                    case "model":
                        param.setResult("sunsing");
                        break;
                    case "brand":
                        XposedBridge.log("ANDROIDID +品牌");
                        param.setResult("BRAND");
                        break;
                    case "apilevel":
                        param.setResult(10);
                        break;
                }

            }
        };
    }

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpp) throws Throwable {
//        initVersion(lpp);

        // IMEI
        HTool.hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getDeviceId", hookCallBack("IMEI"));
        HTool.hook_method("com.android.internal.telephony.PhoneSubInfo", lpp.classLoader, "getDeviceId", hookCallBack("IMEI"));


        //IMSI
        HTool.hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getSubscriberId", hookCallBack("IMSI"));

        HTool.hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getSimSerialNumber", hookCallBack("SimSerialNumber"));

        //修改 wifiInfo
        HTool.hook_method("android.net.wifi.WifiInfo", lpp.classLoader, "getMacAddress", hookCallBack("MacAddress"));

        //修改android id
        HTool.hook_method("android.provider.Settings.Secure", lpp.classLoader, "getString", ContentResolver.class, String.class, hookCallBack("ANDROIDID"));


        //hook登录
//        hook_method("com.eoe.drugstore.activity.LoginActivity", lpp.classLoader, "isCorrect", String.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//                param.args[0] = "jon";
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//            }
//        });


        /**
         * 修改手机品牌
         */


//        XposedHelpers.setStaticObjectField(Build.class, "BRAND", hookCallBack("brand"));
//
//        XposedHelpers.setStaticObjectField(Build.class, "MODEL", hookCallBack("model"));

        hookAll();


        /**
         * 位置hook
         */
        HTool.hook_method("android.net.wifi.WifiManager", lpp.classLoader, "getScanResults", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                /**
                 * Android提供了基于网络的定位服务和基于卫星的定位服务两种
                 * android.net.wifi.WifiManager的getScanResults方法
                 * Return the results of the latest access point scan.
                 * @return the list of access points found in the most recent scan.
                 */
                param.setResult(null);
            }
        });
        HTool.hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getCellLocation", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(null);
            }
        });

        HTool.hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getNeighboringCellInfo", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(null);
            }
        });
        HTool.hook_methods("android.location.LocationManager", "requestLocationUpdates", new XC_MethodHook() {
            /**
             * android.location.LocationManager类的requestLocationUpdates方法
             * 其参数有4个：
             * String provider, long minTime, float minDistance,LocationListener listener
             * Register for location updates using the named provider, and a pending intent
             */
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args.length == 4 && (param.args[0] instanceof String)) {
                    //位置监听器,当位置改变时会触发onLocationChanged方法
                    LocationListener ll = (LocationListener) param.args[3];
                    Class<?> clazz = LocationListener.class;
                    Method m = null;
                    for (Method method : clazz.getDeclaredMethods()) {
                        if (method.getName().equals("onLocationChanged")) {
                            m = method;
                            break;
                        }
                    }
                    try {
                        if (m != null) {
                            Object[] args = new Object[1];
                            Location l = new Location(LocationManager.GPS_PROVIDER);
                            //台北经纬度:121.53407,25.077796
                            double la = 121.53407;
                            double lo = 25.077796;
                            l.setLatitude(la);
                            l.setLongitude(lo);
                            args[0] = l;
                            m.invoke(ll, args);
                            XposedBridge.log("fake location: " + la + ", " + lo);
                        }

                    } catch (Exception e) {

                    }
                }
            }
        });

        HTool.hook_methods("android.location.LocationManager", "getGpsStatus", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                GpsStatus gss = (GpsStatus) param.getResult();
                if (gss == null)
                    return;

                Class<?> clazz = GpsStatus.class;
                Method m = null;
                for (Method method : clazz.getDeclaredMethods()) {
                    if (method.getName().equals("setStatus")) {
                        if (method.getParameterTypes().length > 1) {
                            m = method;
                            break;
                        }
                    }
                }
                m.setAccessible(true);
                //make the apps belive GPS works fine now
                int svCount = 5;
                int[] prns = {1, 2, 3, 4, 5};
                float[] snrs = {0, 0, 0, 0, 0};
                float[] elevations = {0, 0, 0, 0, 0};
                float[] azimuths = {0, 0, 0, 0, 0};
                int ephemerisMask = 0x1f;
                int almanacMask = 0x1f;
                //5 satellites are fixed
                int usedInFixMask = 0x1f;
                try {
                    if (m != null) {
                        m.invoke(gss, svCount, prns, snrs, elevations, azimuths, ephemerisMask, almanacMask, usedInFixMask);
                        param.setResult(gss);
                    }
                } catch (Exception e) {
                    XposedBridge.log(e);
                }
            }
        });


    }

    private void hookAll() {
//        XposedHelpers.setStaticObjectField(Build.VERSION.class, "SDK", hookCallBack("apilevel"));

        XposedHelpers.findAndHookMethod(Settings.Secure.class, "getString", ContentResolver.class, String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                XposedBridge.log("hookAll" + param.getResult());
            }
        });

        try {
            XposedHelpers.findField(Build.class, "BRAND").set(null, "xiaomi");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
