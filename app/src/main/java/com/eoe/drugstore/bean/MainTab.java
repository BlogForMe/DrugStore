package com.eoe.drugstore.bean;


import com.eoe.drugstore.R;
import com.eoe.drugstore.home.BeautyFragment;
import com.eoe.drugstore.fragment.MineFragment;
import com.eoe.drugstore.fragment.ShopCartFragment;
import com.eoe.drugstore.tasks.WeatherFragment;

/**
 * Tab设置
 */
public enum MainTab {
    COMMUNITY(0, R.string.main_tab_name_community, R.drawable.tab_community, BeautyFragment.class),

    NEWS(1, R.string.main_tab_name_home, R.drawable.tab_home,
            WeatherFragment.class),
    SHOP(2, R.string.main_tab_name_shop, R.drawable.tab_shop, ShopCartFragment.class),
    MINE(3, R.string.main_tab_name_mine, R.drawable.tab_mine, MineFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
