package com.yb.recycleview_demo

import com.alibaba.android.arouter.facade.annotation.Route
import com.yb.common.ARouterManager
import com.yb.common.base_mvc.BaseActivityC

/**
 * 类说明：RecycleView的多种组件
 * @author 裕博
 */
@Route(path = ARouterManager.RECYCLE_VIEW_DEOM)
class RecycleViewActivity : BaseActivityC() {
    override fun init() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_recycle_view
    }
}
