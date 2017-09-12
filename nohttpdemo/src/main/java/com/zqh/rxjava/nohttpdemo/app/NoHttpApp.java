package com.zqh.rxjava.nohttpdemo.app;

import android.app.Application;
import android.content.Context;

import com.yanzhenjie.nohttp.InitializationConfig;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.URLConnectionNetworkExecutor;

/**
 * Created by zqh on 2017/9/9.
 */

public class NoHttpApp extends Application {

    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //初始化
        NoHttp.initialize(InitializationConfig.newBuilder(this)
        .connectionTimeout(30*1000)
        .readTimeout(30*1000)
        .networkExecutor(new URLConnectionNetworkExecutor())
        .build());
    }
}