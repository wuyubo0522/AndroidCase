package com.yb.bottom_navigation.fragment

import android.os.Bundle
import com.yb.bottom_navigation.R
import com.yb.common.base_mvc.BaseFragmentC
import kotlinx.android.synthetic.main.fragment_test.*


/**
 * 类说明：测试的共用的Fragment,实际开发当中需要分离，或者公用Fragment后AddView给当前界面
 * @author 裕博
 * Time: 2019/11/28 12:44
 */
class TestFragment : BaseFragmentC() {

    companion object{
        val TEST_SHOW_TEXT: String? = "test"
        fun newInstance(param1: String): TestFragment {
            val fragment = TestFragment()
            val args = Bundle()
            args.putString(TEST_SHOW_TEXT, param1)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_test
    }

    override fun init() {
        // 显示参数
        mTvMessage.text = arguments?.getString(TEST_SHOW_TEXT)
    }
}