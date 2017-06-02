package com.pipaw.chuanqi.chuangqiapp;

import android.content.Context;

import org.xwalk.core.JavascriptInterface;

/**
 * Created by Administrator on 2016/8/3.
 */
public class LogoutJavaScriptInterface {
    private Context context;

    //    PayReq req;
    public LogoutJavaScriptInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void clickLogout() {
//        CommonUtils.showToast(context, "登出");

    }

    @JavascriptInterface
    public void clickLogin(String username, String password) {
//        CommonUtils.showToast(context, "登录:==user:" + username + ",psw:" + password);

    }

    @JavascriptInterface
    public void weixinpay(String body, String out_trade_no, String total_fee, String suc_url) {
//        new PayUtil(context,body, out_trade_no, total_fee);

    }
}
