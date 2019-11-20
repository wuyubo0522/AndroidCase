package com.yb.observer_java.listener;

/**
 * 类说明：观察者接口
 *
 * @author 裕博
 */
public interface ObserverListener {
    /**
     * 刷新操作
     * @param count 传输的内容
     */
    void observerUpData(String count);
}
