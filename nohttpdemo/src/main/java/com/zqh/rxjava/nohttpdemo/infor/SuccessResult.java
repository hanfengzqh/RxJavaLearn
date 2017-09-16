package com.zqh.rxjava.nohttpdemo.infor;

import java.io.Serializable;

public class SuccessResult implements Serializable{

    Result result;
    String status;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;

    }

    public void setStatus(String status) {
        this.status = status;
    }


    public SuccessResult() {
        super();
    }

    public SuccessResult(String status, Result result) {
        super();
        this.status = status;
        this.result = result;
    }

    @Override
    public String toString() {
        return "SuccessResult{" +
                "result='" + result + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
