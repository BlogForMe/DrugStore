package com.eoe.drugstore.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon on 2016/6/14.
 * 内存泄漏场景
 */
public class ActivityManager {
    private List<Activity> mActivities = new ArrayList<>();
    private static ActivityManager sInstance;

    public ActivityManager() {
    }

    public static ActivityManager instance() {
        if (sInstance == null) {
            sInstance = new ActivityManager();
        }
        return sInstance;
    }
    public  void registActivity(Activity activity){
        mActivities.add(activity);
    }

    public  void unRegistActivity(Activity activity){
        mActivities.remove(activity);
    }
}
