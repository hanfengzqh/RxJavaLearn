package com.zqh.rxjava.rxjavalearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zqh.rxjava.rxjavalearn.model.GitModel;
import com.zqh.rxjava.rxjavalearn.presenter.GitHubService;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_string)
    Button bt_string;
    @BindView(R.id.bt_json)
    Button bt_json;
    @BindView(R.id.bt_responsebody_json)
    Button bt_responsebody_json;
    @BindView(R.id.bt_responsebody_string)
    Button bt_responsebody_string;
    @BindView(R.id.bt_rxjava_json)
    Button bt_rxjava_json;
    @BindView(R.id.bt_rxjava_string)
    Button bt_rxjava_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bt_string.setOnClickListener(this);
        bt_json.setOnClickListener(this);
        bt_responsebody_json.setOnClickListener(this);
        bt_responsebody_string.setOnClickListener(this);
        bt_rxjava_json.setOnClickListener(this);
        bt_rxjava_string.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_string: {
                requestString();
                break;
            }
            case R.id.bt_json: {
                requestJson();
                break;
            }
            case R.id.bt_responsebody_json: {
                getresponseBodyJson();
                break;
            }
            case R.id.bt_responsebody_string: {
                getresponseBody();
                break;
            }
            case R.id.bt_rxjava_json: {
                getRxJavaJson();
                break;
            }
            case R.id.bt_rxjava_string: {
                getRxJava();
                break;
            }
        }
    }

    private void getRxJavaJson() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(GitHubService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Observable<GitModel> observable = service.rxUser("hanfengzqh");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GitModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d("zqh","onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("zqh","onError = "+e.getMessage());
                    }

                    @Override
                    public void onNext(GitModel gitModel) {
                        Log.d("zqh","onNext = "+gitModel.toString() );
                    }
                });

    }
    private void getRxJava() {

    }
    private void getresponseBodyJson() {
        //Json形式
        Retrofit retrofit = new Retrofit.Builder().baseUrl(GitHubService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<ResponseBody> serviceResPonseBody = service.getResPonseBody("hanfengzqh");
        serviceResPonseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String string = response.body().string();
                        if (string != null)
                            Log.d("zqh", "body = " + string);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("zqh", "ResponseBody 数据请求失败");
            }
        });
    }

    private void getresponseBody() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.BASEURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<ResponseBody> call = service.getResPonseBody("hanfengzqh");
        //异步请求
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //返回数据处理
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    try {
                        Log.d("zqh", "onResponse : " + body.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("zqh", "String 数据请求失败");
            }
        });
    }

    private void requestJson() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(GitHubService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<GitModel> call = service.getUserInfor("hanfengzqh");
        call.enqueue(new Callback<GitModel>() {
            @Override
            public void onResponse(Call<GitModel> call, Response<GitModel> response) {
                if (response.isSuccessful()) {
                    GitModel body = response.body();
                    if (body != null)
                        Log.d("zqh", "body = " + body.toString());
                }
            }

            @Override
            public void onFailure(Call<GitModel> call, Throwable t) {
                Log.d("zqh", "Json 数据请求失败");
            }
        });
    }


    private void requestString() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.BASEURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<String> call = service.getData("hanfengzqh");
        //异步请求
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //返回数据处理
                if (response.isSuccessful()) {
                    Log.d("zqh", "onResponse : " + response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("zqh", "String 数据请求失败");
            }
        });
    }

}
