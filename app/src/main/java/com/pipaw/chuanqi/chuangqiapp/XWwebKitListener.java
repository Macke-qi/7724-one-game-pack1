package com.pipaw.chuanqi.chuangqiapp;

import android.graphics.Bitmap;
import android.view.View;

import org.xwalk.core.XWalkView;

import java.util.List;

public interface XWwebKitListener {

	/**
	 * 下载
	 * 
	 * @param contentLength
	 * @param type
	 * @param url
	 * @param name
	 */
	void setDownLoadInfo(long contentLength, String type, String url,
						 String name);

	/**
	 * 进度条变化
	 * 
	 * @param webView
	 * @param newProgress
	 */
	void onProgressChanged(XWalkView webView, int newProgress);

	/**
	 * 接收webview返回的标题
	 * 
	 * @param webView
	 * @param title
	 */
	void onReceivedTitle(XWalkView webView, String title);

	/**
	 * 接收webview返回的logo
	 * 
	 * @param webView
	 * @param icon
	 */
	void onReceivedIcon(XWalkView webView, Bitmap icon);

	/**
	 * webview开始加载
	 * 
	 * @param webView
	 * @param url
	 * @param favicon
	 */
	void onPageStarted(XWalkView webView, String url, Bitmap favicon);

	/**
	 * webview加载结束
	 * 
	 * @param view
	 * @param url
	 */
	void onPageFinished(XWalkView view, String url);

	/**
	 * webview长按
	 */
	void onWebViewLongClick(String[] items, List<String> imageUrls, String url,
							String imgUrl);

	/**
	 * 注册webview长按事件
	 */
	void registerForContextMenu(View view);

	void onReceivedError(XWalkView view, int errorCode, String description,
						 String failingUrl);
}
