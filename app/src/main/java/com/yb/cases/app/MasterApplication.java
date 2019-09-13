package com.yb.cases.app;

import android.util.Log;

import com.yb.common.base.BaseApplication;

/**
 * 类说明：App宿主的主程序入口
 *
 * @author 裕博
 * Date: 2019/9/13
 * Time: 14:46
 */
public class MasterApplication extends BaseApplication {

    @Override
    public void onCreate() {
        Log.e("TAG","============================进入主程序入口");
        super.onCreate();
    }
}
