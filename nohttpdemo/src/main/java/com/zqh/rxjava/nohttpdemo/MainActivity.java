package com.zqh.rxjava.nohttpdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zqh.rxjava.nohttpdemo.base.BaseActivity;
import com.zqh.rxjava.nohttpdemo.infor.SuccessResult;
import com.zqh.rxjava.nohttpdemo.manager.RetrofitManager;
import com.zqh.rxjava.nohttpdemo.utils.HttpListener;

import retrofit2.Call;
import retrofit2.Callback;

import static com.zqh.rxjava.nohttpdemo.utils.Utils.getSystemTime;
import static com.zqh.rxjava.nohttpdemo.utils.Utils.getUUID;

public class MainActivity extends BaseActivity {
//    public String url = "http://mgmt.zhinengguo.com:38201/index.php?s=api/app/applist&";
    public String url = "http://mgmt.zhinengguo.com:38201";

    private Request<String> request = null;
    private TextView textView;

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        Button bt_1 = (Button) findViewById(R.id.bt_1);
        textView = (TextView) findViewById(R.id.textview);
        request = NoHttp.createStringRequest(url, RequestMethod.POST);
        addRequestParams();
        //方法一采用NoHttp方法
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                request(1, request, httpListener, true, true);
                RetrofitManager.getInstance(url).setRequestParams()
                        .enqueue(new Callback<SuccessResult>() {
                            @Override
                            public void onResponse(Call<SuccessResult> call,
                                                   retrofit2.Response<SuccessResult> response) {
//                                Log.d("zqh","请求成功"+response.toString());
                                Logger.d("请求成功"+response.body());

                            }

                            @Override
                            public void onFailure(Call<SuccessResult> call, Throwable t) {
                                Log.d("zqh","请求失败"+t.toString());
                            }
                        });
            }
        });

        //方法二采用RxJava+Retrofit
//        RetrofitManager.getInstance(url).setRequestParams()
//                .enqueue(new Callback<JavaInfor>() {
//            @Override
//            public void onResponse(Call<JavaInfor> call,
//                                   retrofit2.Response<JavaInfor> response) {
//
//
//            }
//
//            @Override
//            public void onFailure(Call<JavaInfor> call, Throwable t) {
//
//            }
//        });

    }

    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            showMessageDialog("请求成功: ", response.get());
            textView.setText("请求成功: " + response.get());
            Log.d("zqh","response.get() = "+response.get());
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            showMessageDialog("请求失败: ", response.get());
        }
    };

    /**
     * 添加请求参数
     */
    private void addRequestParams() {
        request.add("dSn", "122006010639");
        request.add("vId", "00100007");
        request.add("pSn", "H12160011060");
        request.add("dT", "2");
        request.add("mId", getUUID());
        request.add("mT", "1");
        request.add("sT", getSystemTime());
        request.add("pN", "1");
        request.add("pC", "2");
        request.add("catalog", "1");
    }
}
