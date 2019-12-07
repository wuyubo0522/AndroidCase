package com.yb.recycleview_demo.main

import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.gyf.immersionbar.ImmersionBar
import com.yb.common.ARouterManager
import com.yb.common.base_mvc.BaseActivityC
import com.yb.recycleview_demo.R
import com.yb.recycleview_demo.ui.*
import kotlinx.android.synthetic.main.activity_recycle_view.*

/**
 * 类说明：RecycleView的多种应用组件
 * @author 裕博
 */
@Route(path = ARouterManager.RECYCLE_VIEW_DEOM)
class RecycleViewActivity : BaseActivityC() {

    override fun getLayoutId(): Int {
        return R.layout.activity_recycle_view
    }

    override fun init() {
        ImmersionBar.with(this).init()
        findViewById<TextView>(R.id.mTvTitle).text = "RecycleView多种应用组件"
        // 每个按钮的点击事件设置
        mBtn0?.setOnClickListener {
            jumpActivity(SingleRowActivity::class.java)
        }
        mBtn1?.setOnClickListener {
            jumpActivity(MultipleRowsActivity::class.java)
        }
        mBtn2?.setOnClickListener {
            jumpActivity(TransverseActivity::class.java)
        }
        mBtn3?.setOnClickListener {
            jumpActivity(WaterfallActivity::class.java)
        }
        mBtn4?.setOnClickListener {
            jumpActivity(LabelActivity::class.java)
        }
        mBtn5?.setOnClickListener {
            jumpActivity(FlopActivity::class.java)
        }
    }
}
