package com.yb.cases;

import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;
import com.yb.common.ARouterManager;
import com.yb.common.base_mvc.BaseActivityC;

import butterknife.BindView;

/**
 * 类说明：主App的主页界面，在这里跳转实现逻辑跳转
 *
 * @author 裕博
 */
public class MainActivity extends BaseActivityC {

    @BindView(R.id.bt_0)
    Button bt0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        // 设置沉浸式状态
        ImmersionBar.with(this).init();
        bt0.setOnClickListener(view -> {
            // 在主App中跳转到获取MD5签名的页面
            ARouter.getInstance().build(ARouterManager.AUTOGRAPH).navigation();
        });
    }
}
