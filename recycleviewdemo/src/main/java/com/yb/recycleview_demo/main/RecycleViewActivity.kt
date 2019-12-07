package com.yb.recycleview_demo.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.gyf.immersionbar.ImmersionBar
import com.yb.common.ARouterManager
import com.yb.common.base_mvc.BaseActivityC
import com.yb.recycleview_demo.R

/**
 * 类说明：RecycleView的多种应用组件
 * @author 裕博
 */
@Route(path = ARouterManager.RECYCLE_VIEW_DEOM)
class RecycleViewActivity : BaseActivityC() {
    override fun init() {
        ImmersionBar.with(this).init()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_recycle_view
    }
}
