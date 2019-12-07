package com.yb.observer_java.ui;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;
import com.yb.common.ARouterManager;
import com.yb.common.base_mvc.BaseActivityC;
import com.yb.observer_java.R;
import com.yb.observer_java.listener.ObserverListener;
import com.yb.observer_java.observer.ObserverManager;

/**
 * 类说明：观察者模式Java案例主页面
 *
 * @author 裕博
 */
@Route(path = ARouterManager.OBSERVER_JAVA)
public class ObserverJavaActivity extends BaseActivityC implements ObserverListener {

    private TextView textView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_observer_java;
    }

    @Override
    public void init() {
        ImmersionBar.with(this).init();
        TextView mTitle = findViewById(R.id.mTvTitle);
        mTitle.setText("观察者模式Java版");
        textView = findViewById(R.id.tv_prompt);
        // 注册观察者
        ObserverManager.getInstance().add(this);
        // 跳转到第二个页面
        findViewById(R.id.btn).setOnClickListener(v -> jumpActivity(ObserverJavaTestActivity.class));
    }

    @Override
    public void observerUpData(String count) {
        if (count!=null) {
            textView.setText(count);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObserverManager.getInstance().remove(this);
    }
}
