package com.yb.bottom_navigation.ui

import com.yb.bottom_navigation.R
import com.yb.common.base_mvc.BaseActivityC
import kotlinx.android.synthetic.main.activity_style_first.*


/**
 * 类说明：第一种样式
 * @author 裕博
 * Time: 2019/11/23 17:50
 */
class StyleFirstActivity :BaseActivityC(){

    override fun getLayoutId(): Int {
        return R.layout.activity_style_first
    }

    override fun init() {
        mTvnNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    mTvMessage.setText(R.string.title_home)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    mTvMessage.setText(R.string.title_dashboard)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    mTvMessage.setText(R.string.title_notifications)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }
}