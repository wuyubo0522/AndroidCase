package com.yb.common.web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * 类说明：集成腾讯X5内核创建WebView
 *
 * @author 裕博
 * Date: 2019/9/12
 * Time: 10:33
 */
public class X5WebView extends WebView {
    /**
     * 防止应用加载网页的时候调起系统浏览器
     */
    private WebViewClient client = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String url) {
            webView.loadUrl(url);
            return true;
        }
    };

    public X5WebView(Context context) {
        super(context);
        // 设置背景颜色
        setBackgroundColor(85621);
    }

    public X5WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setWebViewClient(client);
        this.getView().setClickable(true);
        initWebViewSettings();
    }

    /**
     * 初始化WebView设置
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void initWebViewSettings() {
        WebSettings webSettings = this.getSettings();
        // 允许加载JS
        webSettings.setJavaScriptEnabled(true);
        // 支持通过JS打开新窗口,H5打开新界面
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 设置可以访问文件，比如说图片以及文档类型
        webSettings.setAllowFileAccess(true);
        // 设置加载页面自适应功能
        webSettings.setUseWideViewPort(true);
        // 支持缩放，默认为true。
        webSettings.setSupportZoom(true);
        // 设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setBuiltInZoomControls(true);
        // 支持多页面
        webSettings.setSupportMultipleWindows(true);
        // cache缓存
        webSettings.setAppCacheEnabled(true);
        // DOM缓存
        webSettings.setDomStorageEnabled(true);
        // 让定位API能在webView中用
        webSettings.setGeolocationEnabled(true);
        // 设置应用缓存内容的最大值。
        webSettings.setAppCacheMaxSize(Long.MAX_VALUE);
        // 重写使用缓存的方式，默认值LOAD_DEFAULT
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // 自适应屏幕，超出宽度的时候，会缩小适应屏幕
        webSettings.setLoadWithOverviewMode(true);
        // 数据库储存API
        webSettings.setDatabaseEnabled(true);
        // 保存表单数据 默认true
        webSettings.setSaveFormData(false);
    }
}
