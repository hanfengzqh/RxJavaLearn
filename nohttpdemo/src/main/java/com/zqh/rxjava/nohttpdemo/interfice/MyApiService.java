package com.zqh.rxjava.nohttpdemo.interfice;

import com.zqh.rxjava.nohttpdemo.infor.SuccessResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zqh on 2017/9/14.
 */

public interface MyApiService {
    @FormUrlEncoded
    @POST("index.php?s=api/app/applist&")
    Call<SuccessResult> orderRequest(@Field("") String route);
}
