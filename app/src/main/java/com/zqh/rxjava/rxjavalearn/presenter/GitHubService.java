package com.zqh.rxjava.rxjavalearn.presenter;

import com.zqh.rxjava.rxjavalearn.model.GitModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zqh on 2017/12/12.
 */

public interface GitHubService {
    String BASEURL = "https://api.github.com";

    @GET("users/{user}")
    Call<String> getData(@Path("user") String user);

    @GET("users/{user}")
    Call<GitModel> getUserInfor(@Path("user") String user);

    @GET("users/{user}")
    Call<ResponseBody> getResPonseBody(@Path("user") String user);

    @GET("users/{user}")
    Observable<GitModel> rxUser(@Path("user") String user);
}
