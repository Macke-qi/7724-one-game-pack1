package com.pipaw.chuanqi.chuangqiapp;

import android.util.Log;

import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkView;


public class XWalkResourceClientListener extends XWalkResourceClient {

    private XWwebKitListener mWebKitListener;

    public XWalkResourceClientListener(XWalkView arg0, XWwebKitListener mWebKitListener) {
        super(arg0);
        // TODO Auto-generated constructor stub
        this.mWebKitListener = mWebKitListener;
    }


    @Override
    public void onLoadFinished(XWalkView view, String url) {
        // TODO Auto-generated method stub
        mWebKitListener.onPageFinished(view, url);
        super.onLoadFinished(view, url);
    }

    @Override
    public void onLoadStarted(XWalkView view, String url) {
        // TODO Auto-generated method stub
        mWebKitListener.onPageStarted(view, url, null);
        super.onLoadStarted(view, url);
    }

    @Override
    public void onProgressChanged(XWalkView view, int progressInPercent) {
        // TODO Auto-generated method stub
        mWebKitListener.onProgressChanged(view, progressInPercent);
        super.onProgressChanged(view, progressInPercent);
    }

    @Override
    public void onReceivedLoadError(XWalkView view, int errorCode,
                                    String description, String failingUrl) {
        // TODO Auto-generated method stub
        mWebKitListener.onReceivedError(view, errorCode, description, failingUrl);
//		super.onReceivedLoadError(view, errorCode, description, failingUrl);
    }

//	@Override
//	public void onReceivedSslError(XWalkView view,
//			ValueCallback<Boolean> callback, SslError error) {
//		// TODO Auto-generated method stub
//		super.onReceivedSslError(view, callback, error);
//	}


    @Override
    public boolean shouldOverrideUrlLoading(XWalkView view, final String url) {
        // TODO Auto-generated method stub
        Log.d("", "shouldOverrideUrlLoading->" + url);
      /*  if (url.indexOf("http://m.7724.com/") >= 0) {
            return false;
        }*/
        return super.shouldOverrideUrlLoading(view, url);
    }

};
