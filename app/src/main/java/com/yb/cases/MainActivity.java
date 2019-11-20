package com.yb.cases;

import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;
import com.yb.common.ARouterManager;
import com.yb.common.base_mvc.BaseActivityC;

import butterknife.OnClick;

/**
 * 类说明：主App的主页界面，在这里跳转实现逻辑跳转
 *
 * @author 裕博
 */
public class MainActivity extends BaseActivityC {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        // 设置沉浸式状态
        ImmersionBar.with(this).init();
    }

    @OnClick({R.id.bt_0, R.id.bt_1,R.id.bt_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_0:
                // 在主App中跳转到获取MD5签名的页面
                ARouter.getInstance().build(ARouterManager.AUTOGRAPH).navigation();
                break;
            case R.id.bt_1:
                // 在主App中跳转到观察者模式Java案例中
                ARouter.getInstance().build(ARouterManager.OBSERVER_JAVA).navigation();
                break;
            case R.id.bt_2:
                // 在主App中跳转到观察者模式kotlin案例中
                ARouter.getInstance().build(ARouterManager.OBSERVER_KOTLIN).navigation();
                break;
            default:
                break;
        }
    }
}
