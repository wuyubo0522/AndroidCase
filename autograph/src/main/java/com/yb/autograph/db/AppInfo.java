package com.yb.autograph.db;

import android.graphics.drawable.Drawable;

/**
 * 类说明：
 *
 * @author: 裕博
 * Date: 2019/9/12
 * Time: 16:00
 */
public class AppInfo {
    /**
     * 应用图标
     */
    private Drawable icon;
    /**
     * 应用名称
     */
    private String name;
    /**
     * 应用包名
     */
    private String packageName;
    /**
     * 应用签名
     */
    private String sign;

    public AppInfo(Drawable icon, String name, String packageName) {
        this.icon = icon;
        this.name = name;
        this.packageName = packageName;
    }

    public AppInfo(Drawable icon, String name, String packageName, String sign) {
        this.icon = icon;
        this.name = name;
        this.packageName = packageName;
        this.sign = sign;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
