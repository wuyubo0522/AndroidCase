package com.yb.observer_java.listener;

/**
 * 类说明：被观察者接口
 *
 * @author 裕博
 */
public interface SubjectListener {
    /**
     * 添加
     */
    void add(ObserverListener observerListener);

    /**
     * 通知的内容
     */
    void notifyObserver(String count);

    /**
     * 删除
     */
    void remove(ObserverListener observerListener);
}
