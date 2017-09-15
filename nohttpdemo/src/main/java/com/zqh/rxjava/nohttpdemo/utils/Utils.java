package com.zqh.rxjava.nohttpdemo.utils;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * Created by zqh on 2017/9/14.
 */

public class Utils {

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
