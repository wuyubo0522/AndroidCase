package com.yb.observer_kotlin.ui

import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.gyf.immersionbar.ImmersionBar
import com.yb.common.ARouterManager
import com.yb.common.base_mvc.BaseActivityC
import com.yb.observer_kotlin.R
import com.yb.observer_kotlin.listener.ObserverListener
import com.yb.observer_kotlin.observer.ObserverManager
import kotlinx.android.synthetic.main.activity_observer_kotlin.*

/**
 * 类说明：观察者模式Kotlin版本
 * @author 裕博
 */
@Route(path = ARouterManager.OBSERVER_KOTLIN)
class ObserverKotlinActivity :BaseActivityC(),ObserverListener{

    override fun getLayoutId(): Int {
        return R.layout.activity_observer_kotlin
    }

    override fun init() {
        ImmersionBar.with(this).init()
        findViewById<TextView>(R.id.mTvTitle).text = "观察者模式kotlin版本"
        // 注册观察者
        ObserverManager.instance.add(this)
        // 跳转到第二个页面
        mBtn.setOnClickListener {
            jumpActivity(ObserverKotlinTestActivity::class.java)
        }
    }

    override fun observerUpData(count: String) {
        mTvPrompt.text = count
    }

    override fun onDestroy() {
        super.onDestroy()
        ObserverManager.instance.remove(this)
    }
}