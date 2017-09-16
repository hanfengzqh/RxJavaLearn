package com.zqh.rxjava.nohttpdemo.infor;

import java.io.Serializable;

/**
 * Created by zqh on 2017/9/14.
 */

public class RequestInfor implements Serializable{

    private String dSn;
    private String vId;
    private String pSn;
    private String dT;
    private String mId;
    private String mT;
    private String sT;
    private String pN;
    private String pC;

    @Override
    public String toString() {
        return "RequestInfor{" +
                "dSn='" + dSn + '\'' +
                ", vId='" + vId + '\'' +
                ", pSn='" + pSn + '\'' +
                ", dT='" + dT + '\'' +
                ", mId='" + mId + '\'' +
                ", mT='" + mT + '\'' +
                ", sT='" + sT + '\'' +
                ", pN='" + pN + '\'' +
                ", pC='" + pC + '\'' +
                ", catalog='" + catalog + '\'' +
                '}';
    }

    private String catalog;

    public String getdSn() {
        return dSn;
    }

    public void setdSn(String dSn) {
        this.dSn = dSn;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getpSn() {
        return pSn;
    }

    public void setpSn(String pSn) {
        this.pSn = pSn;
    }

    public String getdT() {
        return dT;
    }

    public void setdT(String dT) {
        this.dT = dT;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmT() {
        return mT;
    }

    public void setmT(String mT) {
        this.mT = mT;
    }

    public String getsT() {
        return sT;
    }

    public void setsT(String sT) {
        this.sT = sT;
    }

    public String getpN() {
        return pN;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public String getpC() {
        return pC;
    }

    public void setpC(String pC) {
        this.pC = pC;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
