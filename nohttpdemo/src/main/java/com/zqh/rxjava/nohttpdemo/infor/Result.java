package com.zqh.rxjava.nohttpdemo.infor;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by zqh on 2017/9/16.
 */

public class Result implements Serializable {

    private int pN;
    private int pC;
    private int tP;
    private LinkedList<JavaInfor> sSL;

    public int getpN() {
        return pN;
    }

    public void setpN(int pN) {
        this.pN = pN;
    }

    public int getpC() {
        return pC;
    }

    public void setpC(int pC) {
        this.pC = pC;
    }

    public int gettP() {
        return tP;
    }

    public void settP(int tP) {
        this.tP = tP;
    }

    public LinkedList<JavaInfor> getsSL() {
        return sSL;
    }

    public void setsSL(LinkedList<JavaInfor> sSL) {
        this.sSL = sSL;
    }

    @Override
    public String toString() {
        return "Result{" +
                "pN='" + pN + '\'' +
                ", pC='" + pC + '\'' +
                ", tP='" + tP + '\'' +
                ", sSL=" + sSL +
                '}';
    }
}
