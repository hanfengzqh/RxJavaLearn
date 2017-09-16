package com.zqh.rxjava.nohttpdemo.manager;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zqh.rxjava.nohttpdemo.infor.RequestInfor;
import com.zqh.rxjava.nohttpdemo.infor.SuccessResult;
import com.zqh.rxjava.nohttpdemo.interfice.MyApiService;

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
        mRetrofit = new Retrofit.Builder()
                .baseUrl(url + "/")
                //设置json转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<SuccessResult> setRequestParams() {
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
        String route = new Gson().toJson(infor);
        Logger.json(route);
        Logger.d("我是debug级7别的log日志");
        Logger.i("我是infor级别的log日志");
        Logger.v("我是v级别的log日志");
        Logger.w("我是warn级别的log日志");
        Logger.e("我是error级别的log日志");

        return mRetrofit.create(MyApiService.class).orderRequest(route);
    }
}
