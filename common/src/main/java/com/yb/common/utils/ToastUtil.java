package com.yb.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * 类说明：Toast工具类
 *
 * @author 裕博
 * Date: 2019/9/12
 * Time: 10:57
 */
public class ToastUtil {

    private static Toast toast;

    /**
     * 短时间Toast
     *
     * @param context 上下文
     * @param msg     文本内容
     */
    @SuppressLint("ShowToast")
    public static void showToastShort(Context context, String msg) {
        try {
            if (toast == null) {
                toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
                toast.setDuration(Toast.LENGTH_SHORT);
            }
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 长时间Toast
     * @param context 上下文
     * @param msg 文本内容
     */
    @SuppressLint("ShowToast")
    public static void showToastLong(Context context, String msg) {
        try {
            if (toast == null) {
                toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
            } else {
                toast.setText(msg);
                toast.setDuration(Toast.LENGTH_LONG);
            }
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
