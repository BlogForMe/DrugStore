package com.eoe.drugstore.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class DpAndPx {
    private static DpAndPx dPxInstance = null;

    public DpAndPx() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static DpAndPx getInstance() {
        if (dPxInstance == null) {
            dPxInstance = new DpAndPx();
        }
        return dPxInstance;
    }

    public static int dpTopx(Context context, int in_dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        int in_px = (int) (in_dp * scale + 0.5f);
        return in_px;
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取屏幕的分辨率
     *
     * @param context
     * @return
     */
    public static int getScreenResolution(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        // 获取屏幕信息
        ((Activity) context).getWindowManager().getDefaultDisplay()
                .getMetrics(dm);
        int screenWidth = dm.widthPixels;

        return screenWidth;
    }

}
