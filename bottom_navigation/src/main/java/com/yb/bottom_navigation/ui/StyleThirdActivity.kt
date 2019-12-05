package com.yb.bottom_navigation.ui

import android.util.SparseArray
import androidx.fragment.app.Fragment
import com.yb.bottom_navigation.R
import com.yb.bottom_navigation.fragment.TestFragment
import com.yb.common.base_mvc.BaseActivityC
import kotlinx.android.synthetic.main.activity_style_third.*


/**
 * 类说明：第三种样式
 * @author 裕博
 * Time: 2019/11/23 17:52
 */
class StyleThirdActivity : BaseActivityC(){

    private var mFragmentSparseArray: SparseArray<Fragment>? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_style_third
    }

    override fun init() {
        mFragmentSparseArray = SparseArray()
        mFragmentSparseArray?.append(R.id.today_tab, TestFragment.newInstance("今日"))
        mFragmentSparseArray?.append(R.id.record_tab, TestFragment.newInstance("记录"))
        mFragmentSparseArray?.append(R.id.contact_tab, TestFragment.newInstance("通讯录"))
        mFragmentSparseArray?.append(R.id.settings_tab, TestFragment.newInstance("设置"))
        mRgTabs?.setOnCheckedChangeListener { _, checkedId ->
            // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
            supportFragmentManager.beginTransaction().replace(R.id.mFlContainer,
                    mFragmentSparseArray?.get(checkedId)!!).commit()
        }
        // 默认显示第一个
        supportFragmentManager.beginTransaction().add(R.id.mFlContainer,
                mFragmentSparseArray?.get(R.id.today_tab)!!).commit()
        mIvSign?.setOnClickListener {
            jumpActivity(SignActivity::class.java)
        }
    }
}