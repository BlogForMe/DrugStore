package com.hyhy.hook.xposed;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.hyhy.hook.Device.IMEI;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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


    private void hook_method(String className, ClassLoader classLoader, String methodName,
                             Object... parameterTypesAndCallback) {
        try {
            XposedHelpers.findAndHookMethod(className, classLoader, methodName, parameterTypesAndCallback);
        } catch (Exception e) {
            log(e);
        }
    }

    private void hook_methods(String className, String methodName, XC_MethodHook xmh) {
        try {
            Class<?> clazz = Class.forName(className);
            for (Method method : clazz.getDeclaredMethods())
                if (method.getName().equals(methodName)
                        && !Modifier.isAbstract(method.getModifiers())
                        && Modifier.isPublic(method.getModifiers())) {
                    XposedBridge.hookMethod(method, xmh);
                }
        } catch (Exception e) {
            log(e);
        }
    }

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpp) throws Throwable {
        initVersion(lpp);

        // IMEI
        hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getDeviceId", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Object obj = param.getResult();
                param.setResult(IMEI.data[index]);
                Log.i("jw", "obj af" + obj);
            }
        });
        //IMSI
        hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getSubscriberId", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("IMSI");
            }
        });

        hook_method("android.telephony.TelephonyManager", lpp.classLoader, "getSimSerialNumber", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("SimSerialNumber");
                Object obj = param.getResult();
            }
        });

        //修改 wifiInfo
        hook_method("android.net.wifi.WifiInfo", lpp.classLoader, "getMacAddress", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("MacAddress");
            }
        });

        //修改android id
        hook_method("android.provider.Settings.Secure", lpp.classLoader, "getString", ContentResolver.class, String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("android id");
            }
        });


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


        //定位
        hook_methods("android.location.LocationManager", "getLastKnownLocation", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.i("jw", "hook getLastKnownLocation...");
                Location l = new Location(LocationManager.PASSIVE_PROVIDER);
                double lo = -10000d; //经度
                double la = -10000d; //纬度
                l.setLatitude(la);
                l.setLongitude(lo);
                param.setResult(l);
            }
        });


        hook_methods("android.location.LocationManager", "requestLocationUpdates", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                Log.i("jw", "hook requestLocationUpdates...");

                if (param.args.length == 4 && (param.args[0] instanceof String)) {
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
                            Location l = new Location(LocationManager.PASSIVE_PROVIDER);
                            double lo = -10000d; //经度
                            double la = -10000d; //纬度
                            l.setLatitude(la);
                            l.setLongitude(lo);
                            args[0] = l;
                            m.invoke(ll, args);
                        }
                    } catch (Exception e) {
                        log(e);
                    }
                }
            }
        });

    }

    private void initVersion(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            Context context = (Context) XposedHelpers.callMethod(callStaticMethod(findClass("android.app.ActivityThread", null),
                    "currentActivityThread", new Object[0]), "getSystemContext", new Object[0]);
            String versionName = context.getPackageManager().getPackageInfo(lpparam.packageName, 0).versionName;
//            log("Found  version:" + versionName + " Context " + context);
            XposedBridge.log("Context 输出  " + context + lpparam.packageName);
            if ("com.eoe.drugstore".equals(lpparam)) {
                mContext = context;

                SharedPreferences settings = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
                XposedBridge.log("Context SharedPreferences"+settings.getString("name", ""));
            }
        } catch (PackageManager.NameNotFoundException e) {

        }


    }


}
