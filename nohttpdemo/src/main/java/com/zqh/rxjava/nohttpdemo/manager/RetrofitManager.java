package com.zqh.rxjava.nohttpdemo.manager;

import android.util.Log;

import com.google.gson.Gson;
import com.zqh.rxjava.nohttpdemo.infor.JavaInfor;
import com.zqh.rxjava.nohttpdemo.infor.RequestInfor;
import com.zqh.rxjava.nohttpdemo.interfice.MyApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.zqh.rxjava.nohttpdemo.utils.Utils.getSystemTime;
import static com.zqh.rxjava.nohttpdemo.utils.Utils.getUUID;

/**
 * Created by zqh on 2017/9/14.
 */

public class RetrofitManager {
    private static RetrofitManager mRetrofitManager;
    public Retrofit mRetrofit;

    private RetrofitManager(String url) {
        initRetrofit(url);
    }

    public static synchronized RetrofitManager getInstance(String url) {
        if (mRetrofitManager == null) {
            mRetrofitManager = new RetrofitManager(url);
        }
        return mRetrofitManager;
    }

    private void initRetrofit(String url) {
        //创建builder对象
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置链接超时时间
        builder.connectTimeout(10, TimeUnit.SECONDS);
        //设置读取超时时间
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);
        //设置日志输出拦截器
        builder.addInterceptor(getHttpLoggingInterceptor());
        //设置错误重连机制
        builder.retryOnConnectionFailure(true);
        //以上全部结束才能build,构建请求对象
        OkHttpClient client = builder.build();
//        List<String> pathSegments = HttpUrl.parse(url).pathSegments();
//        for(String aa : pathSegments){
//            Log.d("zqh","aa = "+aa);
//        }
//        Log.d("zqh", "pathSegments = " + pathSegments.get(pathSegments.size() - 1));
        mRetrofit = new Retrofit.Builder()
                .baseUrl(url + "/")
                //设置json转换器
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public Call<JavaInfor> setRequestParams(String url) {
        RequestInfor infor = new RequestInfor();
        infor.setdSn("122006010639");
        infor.setvId("00100007");
        infor.setpSn("H12160011060");
        infor.setdT("2");
        infor.setmId(getUUID());
        infor.setmT("1");
        infor.setsT(getSystemTime());
        infor.setpN("1");
        infor.setpC("5");
        infor.setCatalog("1");
        return mRetrofit.create(MyApiService.class).orderRequest(infor, "index.php?s=api/app/applist&");
    }

    /**
     * 转换请求为json数据
     */
    private RequestBody getRequestBody(Object obj) {
        String route = new Gson().toJson(obj);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);
        return body;
    }


    private HttpLoggingInterceptor getHttpLoggingInterceptor() {

        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("zqh", "Retrofit--Log:" + message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }
}
