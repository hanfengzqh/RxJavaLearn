package com.zqh.rxjava.nohttpdemo.interfice;

import com.zqh.rxjava.nohttpdemo.infor.JavaInfor;
import com.zqh.rxjava.nohttpdemo.infor.RequestInfor;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zqh on 2017/9/14.
 */

public interface MyApiService {

    @POST("{url}")
    Call<JavaInfor> orderRequest(@Body RequestInfor route, @Path("url") String url);
}
