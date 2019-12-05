package com.yb.cases

import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ImmersionBar
import com.yb.common.ARouterManager
import com.yb.common.base_mvc.BaseActivityC
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 类说明：主App的主页界面，在这里跳转实现逻辑跳转
 *
 * @author 裕博
 */
class MainActivity : BaseActivityC() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() { // 设置沉浸式状态
        ImmersionBar.with(this).init()
        mBtn0?.setOnClickListener {
            // 在主App中跳转到获取MD5签名的页面
            ARouter.getInstance().build(ARouterManager.AUTOGRAPH).navigation()
        }
        mBtn1?.setOnClickListener {
            // 在主App中跳转到观察者模式Java案例中
            ARouter.getInstance().build(ARouterManager.OBSERVER_JAVA).navigation()
        }
        mBtn2?.setOnClickListener {
            // 在主App中跳转到观察者模式kotlin案例中
            ARouter.getInstance().build(ARouterManager.OBSERVER_KOTLIN).navigation()
        }
        mBtn3?.setOnClickListener {
            // 在主App中跳转到多种底部导航栏多种实现的方式
            ARouter.getInstance().build(ARouterManager.BOTTOM_NAVIGATION).navigation()
        }
    }
}