package com.yb.observer_kotlin.ui

import android.widget.TextView
import com.gyf.immersionbar.ImmersionBar
import com.yb.common.base_mvc.BaseActivityC
import com.yb.observer_kotlin.R
import com.yb.observer_kotlin.observer.ObserverManager
import kotlinx.android.synthetic.main.activity_kotlin_test.*


/**
 * 类说明：观察者测试页面
 *
 * @author 裕博
 */
class ObserverKotlinTestActivity : BaseActivityC() {
    override fun getLayoutId(): Int {
        return R.layout.activity_kotlin_test
    }

    override fun init() {
        ImmersionBar.with(this).init()
        findViewById<TextView>(R.id.mTvTitle).text = "观察者模式kotlin版本测试界面"
        mBtnSend.setOnClickListener {
            // 将这个数据传输到第一个页面
            ObserverManager.instance.notifyObserver("Kotlin第一个页面更新数据啦！！！")
            finish()
        }
    }
}
