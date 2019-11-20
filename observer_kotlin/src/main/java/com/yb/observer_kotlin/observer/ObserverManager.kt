package com.yb.observer_kotlin.observer

import com.yb.observer_kotlin.listener.ObserverListener
import com.yb.observer_kotlin.listener.SubjectListener
import java.util.ArrayList

/**
 * 类说明：观察者模式管理类
 *
 * @author 裕博
 */
class ObserverManager : SubjectListener {
    /**
     * 观察者集合
     */
    private val list = ArrayList<ObserverListener>()

    override fun add(observerListener: ObserverListener) {
        // 加入队列
        list.add(observerListener)
    }

    override fun notifyObserver(count: String) {
        // 通知观察者刷新数据
        for (observerListener in list) {
            observerListener.observerUpData(count)
        }
    }

    override fun remove(observerListener: ObserverListener) {
        // 从监听队列删除
        list.remove(observerListener)
    }

    companion object {
        val instance: ObserverManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ObserverManager()
        }
    }
}
