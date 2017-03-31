package com.eoe.drugstore.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/3/20.
 * 获取设备信息
 */

public class DeviceInfoUtil {

    static DeviceInfoUtil deviceInfoUtil = null;
    static Context context;

    public DeviceInfoUtil(Context context) {
        this.context = context.getApplicationContext();
    }

    public static DeviceInfoUtil getInstance(Context context) {
        synchronized (DeviceInfoUtil.class) {
            if (deviceInfoUtil == null) {
                deviceInfoUtil = new DeviceInfoUtil(context);
            }
        }
        return deviceInfoUtil;
    }

    /**
     * 获取手机品牌
     */
    public String getBrand() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return Build.BRAND;
    }


    //手机号码
    public String getLine1Number() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getLine1Number();
    }

    //deviceId
    public String getDeviceId() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getDeviceId();
    }

    //运营商名称
    public String getNetworkOperatorName() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getNetworkOperatorName();
    }

    //sim卡序列号
    public String getSimSerialNumber() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getSimSerialNumber();
    }

    //IMSI
    public String getImsiId() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getSubscriberId();
    }

    //sim卡所在国家
    public String getNetworkCountryIso() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getNetworkCountryIso();
    }

    //运营商编号。
    public String getNetworkOperator() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return tm.getNetworkOperator();
    }

    //android 获取当前手机型号
    public String getPhoneModel() {
        Build bd = new Build();
        return bd.MODEL;
    }

    //android 获取当前手机品牌
    public String getPhoneProduct() {
        Build bd = new Build();
        return bd.PRODUCT;
    }

    //android 获取屏幕分辩率
    public String getMetrics() {
        DisplayMetrics dm = new DisplayMetrics();
        int h = dm.heightPixels;
        int w = dm.widthPixels;
        return h + "*" + w;
    }

    //android获取当前时区
    public String getTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        String s = tz.getID();
        System.out.println(s);
        return s;
    }

    //android获取当前日期时间
    public String getDateAndTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    //获取手机系统语言 0中文简体 1其它
    public String getLanguage() {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        if (language.endsWith("zh"))
            return "0";
        else
            return "1";
    }

    /**
     * 获取android id
     *
     * @return
     */
    public String getAndroidId() {

        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


    /**
     * 获取mac地址
     *
     * @return
     */
    public String getMacAddress() {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return wifiInfo.getMacAddress();
    }


}
