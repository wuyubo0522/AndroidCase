package com.yb.bottom_navigation.ui

import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.yb.bottom_navigation.R
import com.yb.bottom_navigation.adapter.NavigationFragmentPagerAdapter
import com.yb.bottom_navigation.fragment.TestFragment
import com.yb.common.base_mvc.BaseActivityC
import kotlinx.android.synthetic.main.activity_style_second.*


/**
 * 类说明：第二种样式
 * @author 裕博
 * Time: 2019/11/23 17:51
 */
class StyleSecondActivity : BaseActivityC() {

    private var mFragments: MutableList<Fragment>? = arrayListOf()

    override fun getLayoutId(): Int {
        return R.layout.activity_style_second
    }

    override fun init() {
        // 添加Fragment
        mFragments?.add(TestFragment.newInstance("今日"))
        mFragments?.add(TestFragment.newInstance("记录"))
        mFragments?.add(TestFragment.newInstance("通讯录"))
        mFragments?.add(TestFragment.newInstance("设置"))
        // 设置适配器
        mVpContent?.adapter = NavigationFragmentPagerAdapter(supportFragmentManager, mFragments)
        mVpContent?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                // 这里做出页面改变处理
                val radioButton: RadioButton = mRgTab?.getChildAt(position) as RadioButton
                radioButton.isChecked = true
            }
        })
        mRgTab?.setOnCheckedChangeListener { group, checkedId ->
            for (i in 0 until group.childCount) {
                if (group.getChildAt(i).id === checkedId) {
                    mVpContent?.currentItem = i
                }
            }
        }
    }
}