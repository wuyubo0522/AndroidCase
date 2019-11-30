package com.yb.bottom_navigation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * 类说明：第二种样式底部导航栏Fragment适配器
 * @author 裕博
 * Time: 2019/11/30 16:58
 */
internal class NavigationFragmentPagerAdapter(fm: FragmentManager?, list: List<Fragment>?)
    : FragmentPagerAdapter(fm!!,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mList: List<Fragment>? = list
    override fun getItem(position: Int): Fragment {
        return mList?.get(position)!!
    }

    override fun getCount(): Int {
        return mList?.size ?: 0
    }

}