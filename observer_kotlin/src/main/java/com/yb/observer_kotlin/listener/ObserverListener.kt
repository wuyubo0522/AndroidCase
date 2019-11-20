package com.yb.observer_kotlin.listener

/**
 * 类说明：观察者接口
 *
 * @author 裕博
 */
interface ObserverListener {
    /**
     * 刷新操作
     * @param count 传输的内容
     */
    fun observerUpData(count: String)
}
