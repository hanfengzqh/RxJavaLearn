package com.zqh.rxjava.nohttpdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zqh.rxjava.nohttpdemo.utils.HttpListener;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class MainActivity extends BaseActivity {
    public String url = "http://ileshua.yeahka.com/lesk/login.html?hf=info";
    private Request<String> request = null;
    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        Button bt_1 = (Button)findViewById(R.id.bt_1);

        request = NoHttp.createStringRequest(url, RequestMethod.POST);
        request.add("dSn", "122006010639");
        request.add("vId", "00100007");
        request.add("pSn", "H12160011060");
        request.add("dT", "2");
        request.add("dT", getUUID());
        request.add("mT", "1");
        request.add("sT", getSystemTime());
        request.add("pN", "1");
        request.add("pC", "10");
        request.add("catalog", "1");

        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request(1, request, httpListener, true, true);
            }
        });
    }

    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            showMessageDialog("请求成功: ",response.get());
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            showMessageDialog("请求失败: ",response.get());
        }
    };

    public static String getUUID() {
        String[] str = UUID.randomUUID().toString().split("-");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static String getSystemTime() {
        SimpleDateFormat systemDateFormat = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        String systemDate = systemDateFormat.format(new java.util.Date());
        return systemDate;
    }
}
