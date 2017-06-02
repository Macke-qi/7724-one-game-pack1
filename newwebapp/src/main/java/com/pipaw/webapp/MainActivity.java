package com.pipaw.webapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private ProgressBarView mProgressBar;
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareView();
/*联盟与部落
        买量6：http://open782.open.7724.com/lmybl/game?flag=open782
        买量7：http://open783.open.7724.com/lmybl/game?flag=open783
        买量8：http://open784.open.7724.com/lmybl/game?flag=open784
        买量9：http://open785.open.7724.com/lmybl/game?flag=open785
        买量10：http://open786.open.7724.com/lmybl/game?flag=open786
        买量11：http://open814.open.7724.com/lmybl/game?flag=open814
        买量12：http://open815.open.7724.com/lmybl/game?flag=open815
        买量13：http://open816.open.7724.com/lmybl/game?flag=open816
        买量14：http://open817.open.7724.com/lmybl/game?flag=open817
        买量15：http://open818.open.7724.com/lmybl/game?flag=open818
*/


//        mWebView.loadUrl("http://open782.open.7724.com/lmybl/game?flag=open782");
//        mWebView.loadUrl("http://open783.open.7724.com/lmybl/game?flag=open783");
//        mWebView.loadUrl("http://open784.open.7724.com/lmybl/game?flag=open784");
//        mWebView.loadUrl("http://open785.open.7724.com/lmybl/game?flag=open785");
//        mWebView.loadUrl("http://open786.open.7724.com/lmybl/game?flag=open786");
//        mWebView.loadUrl("http://open814.open.7724.com/lmybl/game?flag=open814");
//        mWebView.loadUrl("http://open815.open.7724.com/lmybl/game?flag=open815");
//        mWebView.loadUrl("http://open816.open.7724.com/lmybl/game?flag=open816");
//        mWebView.loadUrl("http://open817.open.7724.com/lmybl/game?flag=open817");
//        mWebView.loadUrl("http://open818.open.7724.com/lmybl/game?flag=open818");


       /*决战沙城
        1   http://open799.open.7724.com/jzsc/game?flag=open799
        2   http://open800.open.7724.com/jzsc/game?flag=open800
        3   http://open801.open.7724.com/jzsc/game?flag=open801
        4   http://open802.open.7724.com/jzsc/game?flag=open802
        5   http://open803.open.7724.com/jzsc/game?flag=open803
        6   http://open804.open.7724.com/jzsc/game?flag=open804
        7   http://open805.open.7724.com/jzsc/game?flag=open805
        8   http://open806.open.7724.com/jzsc/game?flag=open806
        9   http://open808.open.7724.com/jzsc/game?flag=open808
        10  http://open809.open.7724.com/jzsc/game?flag=open809*/
//        mWebView.loadUrl("http://open799.open.7724.com/jzsc/game?flag=open799");
//        mWebView.loadUrl("http://open800.open.7724.com/jzsc/game?flag=open800");
//        mWebView.loadUrl("http://open801.open.7724.com/jzsc/game?flag=open801");
//        mWebView.loadUrl("http://open802.open.7724.com/jzsc/game?flag=open802");
//        mWebView.loadUrl("http://open803.open.7724.com/jzsc/game?flag=open803");
//        mWebView.loadUrl("http://open804.open.7724.com/jzsc/game?flag=open804");
//        mWebView.loadUrl("http://open805.open.7724.com/jzsc/game?flag=open805");
//        mWebView.loadUrl("http://open806.open.7724.com/jzsc/game?flag=open806");
//        mWebView.loadUrl("http://open808.open.7724.com/jzsc/game?flag=open808");
//        mWebView.loadUrl("http://open809.open.7724.com/jzsc/game?flag=open809");
//        mWebView.loadUrl(AppConfig.URL_baid);
        mWebView.loadUrl(BuildConfig.URL);
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
        webSetting.setJavaScriptEnabled(true);

        webSetting.setAllowFileAccess(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setUserAgentString(webSetting.getUserAgentString() + "<libao-nolimit>");
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
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
        MobclickAgent.onResume(this);
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
        MobclickAgent.onPause(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();      //调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (!isExit) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            MobclickAgent.onKillProcess(this);
            finish();
            System.exit(0);
        }
    }
}
