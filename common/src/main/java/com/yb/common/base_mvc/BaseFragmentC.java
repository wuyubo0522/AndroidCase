package com.yb.common.base_mvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类说明：MVC架构模式的BaseFragment，Fragment的基类
 *
 * @author: 裕博
 * Date: 2019/9/12
 * Time: 11:04
 */
public abstract class BaseFragmentC extends Fragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    /**
     * 页面初始化方法
     */
    public abstract void init();

    /**
     * 获取xml布局
     *
     * @return xml的资源ID
     */
    public abstract int getLayoutId();


    /**
     * 跳转其他界面
     *
     * @param c Activity
     */
    public void jumpActivity(Class c) {
        startActivity(new Intent(getActivity(), c));
    }

    /**
     * 带参数跳转页面
     *
     * @param c      跳转的页面
     * @param bundle 参数的传递类，可以封装多个参数
     */
    protected void jumpActivityBundle(Class c, Bundle bundle) {
        Intent intent = new Intent(getActivity(), c);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 小刀注解解绑
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
