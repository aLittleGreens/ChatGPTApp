package com.chatgpt.ai

import android.os.Bundle
import android.view.Window
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        val webView = findViewById<WebView>(R.id.webView)
        //如果页面中使用了JavaScript，不加改代码页面不显示。
        webView.getSettings().setJavaScriptEnabled(true);
//加载页面时如果不加改代码，页面会跳转到系统自带浏览器显示。
        webView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url);
                return true;//返回值为true时在WebView中打开，为false时调用浏览器打开
            }
        };
//显示页面
        webView.loadUrl("https://chat.openai.com/chat");//网络地址http://，本地地址file:///

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        webView.getSettings().setDisplayZoomControls(true);

        val webSettings = webView.settings
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
//webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);// 默认不使用缓存！



    }
}