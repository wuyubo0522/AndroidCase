package com.yb.bottom_navigation.ui

import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.gyf.immersionbar.ImmersionBar
import com.yb.bottom_navigation.R
import com.yb.common.ARouterManager
import com.yb.common.base_mvc.BaseActivityC
import kotlinx.android.synthetic.main.activity_navigation.*

/**
 * 类说明：多种底部导航栏实现方式
 * @author 裕博
 * Data: 2019/11/23
 */
@Route(path = ARouterManager.BOTTOM_NAVIGATION)
class NavigationActivity : BaseActivityC() {

    override fun getLayoutId(): Int {
        return R.layout.activity_navigation
    }

    override fun init() {
        ImmersionBar.with(this).init()
        findViewById<TextView>(R.id.mTvTitle).text = "底部导航栏多种实现组件"
        mBtnFirst.setOnClickListener {
            jumpActivity(StyleFirstActivity::class.java)
        }
        mBtnSecond.setOnClickListener {
            jumpActivity(StyleSecondActivity::class.java)
        }
        mBtnThird.setOnClickListener {
            jumpActivity(StyleThirdActivity::class.java)
        }
    }

}
