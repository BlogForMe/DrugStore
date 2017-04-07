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
import com.hyhy.hook.utils.Constants;
import com.hyhy.hook.utils.HTool;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.PrivilegedAction;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
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
                        getSh();
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
                        getSh();
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

    }

    private void getSh() {
        Log.i("packages", "IMEI修改");

        XSharedPreferences pre = new XSharedPreferences("com.hyhy.hook", "prefs");
        String packageName = pre.getString("packages", "");
        Log.i("packages ", "输出名字" + packageName);
    }

    private void hookAll() {
//        XposedHelpers.setStaticObjectField(Build.VERSION.class, "SDK", hookCallBack("apilevel"));

        XposedHelpers.findAndHookMethod(Settings.Secure.class, "getString", ContentResolver.class, String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
//                Log.i("hookAll" ,"输出数据"+param.getResult());
            }
        });
        try {
            XposedHelpers.findField(Build.class, "BRAND").set(null, "xiaomi");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

