package com.yb.observer_kotlin.listener

/**
 * 类说明：被观察者接口
 *
 * @author 裕博
 */
interface SubjectListener {
    /**
     * 添加
     */
    fun add(observerListener: ObserverListener)

    /**
     * 通知的内容
     */
    fun notifyObserver(count: String)

    /**
     * 删除
     */
    fun remove(observerListener: ObserverListener)
}
