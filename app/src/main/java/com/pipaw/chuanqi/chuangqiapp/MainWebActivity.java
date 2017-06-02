package com.pipaw.chuanqi.chuangqiapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2016/11/4.
 */

public class MainWebActivity extends Activity {
    private ProgressBarView mProgressBar;
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web);
        prepareView();


         /* 联盟与部落
        百度贴吧买量1：http://open777.open.7724.com/lmybl/game?flag=open777
        百度贴吧买量2：http://open778.open.7724.com/lmybl/game?flag=open778
        百度贴吧买量3：http://open779.open.7724.com/lmybl/game?flag=open779
        百度贴吧买量4：http://open780.open.7724.com/lmybl/game?flag=open780
        百度贴吧买量5：http://open781.open.7724.com/lmybl/game?flag=open781*/


        //决战沙城
        mWebView.loadUrl("http://open777.open.7724.com/lmybl/game?flag=open777");
    }

    private void prepareView() {
        mProgressBar = (ProgressBarView) findViewById(R.id.home_progress);
        mWebView =(WebView) findViewById(R.id.webview);
        mWebView.requestFocus();
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBarChange(newProgress);
            }
        });
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        WebSettings webSetting = mWebView.getSettings();
//        webSetting.setJavaScriptEnabled(true);

        webSetting.setAllowFileAccess(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
//        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    private void progressBarChange(int newProgress) {
        if (!mProgressBar.isShown()) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
        mProgressBar.setProgress(newProgress);
        if (100 == newProgress) {
            mProgressBar.setVisibility(View.GONE);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                mWebView.onResume();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.pauseTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                mWebView.onPause();
            }
        }
    }
}
