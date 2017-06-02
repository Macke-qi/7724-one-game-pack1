package com.pipaw.chuanqi.chuangqiapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private XWalkView mXWalkView;
    private ProgressBarView mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBarView) findViewById(R.id.home_progress);
        mXWalkView = (XWalkView) findViewById(R.id.xwalkview);
        // MobclickAgent.openActivityDurationTrack(false);


        mXWalkView.setResourceClient(new XWalkResourceClientListener(mXWalkView, new XWwebKitListener() {
            @Override
            public void setDownLoadInfo(long contentLength, String type, String url, String name) {

            }

            @Override
            public void onProgressChanged(XWalkView webView, int newProgress) {
                progressBarChange(newProgress);
            }

            @Override
            public void onReceivedTitle(XWalkView webView, String title) {

            }

            @Override
            public void onReceivedIcon(XWalkView webView, Bitmap icon) {

            }

            @Override
            public void onPageStarted(XWalkView webView, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(XWalkView view, String url) {

            }

            @Override
            public void onWebViewLongClick(String[] items, List<String> imageUrls, String url, String imgUrl) {

            }

            @Override
            public void registerForContextMenu(View view) {

            }

            @Override
            public void onReceivedError(XWalkView view, int errorCode, String description, String failingUrl) {

            }
        }));
        XWalkSettings set = mXWalkView.getSettings();
        set.setUserAgentString(set.getUserAgentString() + "<libao-nolimit>");
        mXWalkView.load(BuildConfig.URL,null);
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
    public void onResume() {
        super.onResume();
        if (mXWalkView != null) {
            mXWalkView.resumeTimers();
            mXWalkView.onShow();
        }
        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mXWalkView != null) {
            mXWalkView.pauseTimers();
            mXWalkView.onHide();
        }
        MobclickAgent.onPause(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mXWalkView != null) {
            mXWalkView.onDestroy();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mXWalkView.getNavigationHistory().canGoBack()) {
            mXWalkView.getNavigationHistory().navigate(
                    XWalkNavigationHistory.Direction.BACKWARD, 1);
            ; //goBack()表示返回WebView的上一页面
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
