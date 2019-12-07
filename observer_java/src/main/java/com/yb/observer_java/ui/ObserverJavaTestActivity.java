package com.yb.observer_java.ui;

import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.yb.common.base_mvc.BaseActivityC;
import com.yb.observer_java.R;
import com.yb.observer_java.observer.ObserverManager;

/**
 * 类说明：
 *
 * @author Time: 2019/11/20 10:04
 */
public class ObserverJavaTestActivity extends BaseActivityC {
    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void init() {
        ImmersionBar.with(this).init();
        TextView mTitle = findViewById(R.id.mTvTitle);
        mTitle.setText("观察者模式Java版测试界面");
        findViewById(R.id.btn).setOnClickListener(v -> {
            // 将这个数据传输到第一个页面
            ObserverManager.getInstance().notifyObserver("第一个页面更新数据啦！！！");
            finish();
        });
    }
}
