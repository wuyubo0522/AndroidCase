package com.yb.observer_java.observer;

import com.yb.observer_java.listener.ObserverListener;
import com.yb.observer_java.listener.SubjectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明：观察者模式管理类
 *
 * @author 裕博
 */
public class ObserverManager implements SubjectListener {

    private static ObserverManager observerManager;
    /**
     * 观察者集合
     */
    private List<ObserverListener> list = new ArrayList<>();

    /**
     * 单例
     */
    public static ObserverManager getInstance() {
        if (null == observerManager) {
            synchronized (ObserverManager.class) {
                if (null == observerManager) {
                    observerManager = new ObserverManager();
                }
            }
        }
        return observerManager;
    }

    @Override
    public void add(ObserverListener observerListener) {
        // 加入队列
        list.add(observerListener);
    }

    @Override
    public void notifyObserver(String count) {
        // 通知观察者刷新数据
        for (ObserverListener observerListener : list) {
            observerListener.observerUpData(count);
        }
    }

    @Override
    public void remove(ObserverListener observerListener) {
        // 从监听队列删除
        list.remove(observerListener);
    }
}
