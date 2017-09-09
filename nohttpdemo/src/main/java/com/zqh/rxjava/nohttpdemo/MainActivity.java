package com.zqh.rxjava.nohttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yanzhenjie.nohttp.InitializationConfig;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.cache.DBCacheStore;
import com.yanzhenjie.nohttp.cookie.DBCookieStore;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.StringRequest;
import com.yanzhenjie.nohttp.rest.SyncRequestExecutor;
import com.yanzhenjie.nohttp.ssl.CompatSSLSocketFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //NoHttp网络请求框架学习
        //普通初始化
        NoHttp.initialize(this);
        //高级初始化
        InitializationConfig builder = InitializationConfig.newBuilder(this)
                //全局连接服务器超时时间，单位毫秒，默认10s
                .connectionTimeout(30 * 1000)
                //全局等待服务器响应超时时间，单位毫秒，默认10s
                .readTimeout(30 * 1000)
                //配置缓存，默认保存数据库DBCacheStore,若要保存到SD卡则使用DiskCacheStore
                .cacheStore(
                        //若是不使用缓存，则将setEnable(false)即可
                        new DBCacheStore(this).setEnable(true))
                // 配置Cookie，默认保存数据库DBCookieStore，开发者可以自己实现CookieStore接口。
                .cookieStore(
                        // 如果不维护cookie，setEnable(false)禁用。
                        new DBCookieStore(this).setEnable(true))
                //配置网络层，默认URLConnectionNetworkExecutor，如果想用OkHttp：OkHttpNetworkExecutor。
                .networkExecutor(new OkHttpNetworkExecutor())
                // 全局通用Header，add是添加，多次调用add不会覆盖上次add
                .addHeader("", "")
                // 全局通用Param，add是添加，多次调用add不会覆盖上次add。
                .addParam("", "")
                .sslSocketFactory(new CompatSSLSocketFactory())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return false;
                    }
                })
                // 全局重试次数，配置后每个请求失败都会重试x次
                .retry(10)
                .build();

        //// 开启NoHttp的调试模式, 配置后可看到请求过程、日志和错误信息。
        Logger.setDebug(true);
        Logger.setTag("zqh");//设置打印log的tag

        //同步请求--只能在主线程中使用
        StringRequest url = new StringRequest("url", RequestMethod.GET);
        Response<String> execute = SyncRequestExecutor.INSTANCE.execute(url);
        if (execute.isSucceed()) {

            //请求成功
        } else {
            //请求失败，拿到错误
            Exception exception = execute.getException();

        }
        StringRequest url2 = new StringRequest("url");
        //异步请求
//        SyncRequestExecutor.INSTANCE.execute(new)
    }
}
