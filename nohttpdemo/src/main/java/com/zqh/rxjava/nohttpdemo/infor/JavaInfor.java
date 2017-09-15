package com.zqh.rxjava.nohttpdemo.infor;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class JavaInfor implements Serializable {

    private int id;
    public String softwareId;
    public String softwareVendorId;
    public String sPN;
    public String sV;
    public String sN;
    public String sDC;
    public String sP;
    public String sI;
    public String sIP;
    public String sS;
    public String sCom;
    public String softwarescore;
    public String commentcount;
    public String likecount;
    public String recommend;
    public String totalscore;
    public String installTime;
    public List<String> imgs;
    public long progressBar;
    public int state;
    public long tvDownLoadSize;
    public String sTy;
    public String fileSavePath;
    private boolean autoResume;
    private boolean autoRename;
    public String sC;

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsC() {
        return sC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(String softwareId) {
        this.softwareId = softwareId;
    }

    public String getSoftwareVendorId() {
        return softwareVendorId;
    }

    public void setSoftwareVendorId(String softwareVendorId) {
        this.softwareVendorId = softwareVendorId;
    }

    public String getsPN() {
        return sPN;
    }

    public void setsPN(String sPN) {
        this.sPN = sPN;
    }

    public String getsV() {
        return sV;
    }

    public void setsV(String sV) {
        this.sV = sV;
    }

    public String getsN() {
        return sN;
    }

    public void setsN(String sN) {
        this.sN = sN;
    }

    public String getsDC() {
        return sDC;
    }

    public void setsDC(String sDC) {
        this.sDC = sDC;
    }

    public String getsP() {
        return sP;
    }

    public void setsP(String sP) {
        this.sP = sP;
    }

    public String getsI() {
        return sI;
    }

    public void setsI(String sI) {
        this.sI = sI;
    }

    public String getsIP() {
        return sIP;
    }

    public void setsIP(String sIP) {
        this.sIP = sIP;
    }

    public String getsS() {
        return sS;
    }

    public void setsS(String sS) {
        this.sS = sS;
    }

    public String getsCom() {
        return sCom;
    }

    public void setsCom(String sCom) {
        this.sCom = sCom;
    }

    public String getSoftwarescore() {
        return softwarescore;
    }

    public void setSoftwarescore(String softwarescore) {
        this.softwarescore = softwarescore;
    }

    public String getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(String commentcount) {
        this.commentcount = commentcount;
    }

    public String getLikecount() {
        return likecount;
    }

    public void setLikecount(String likecount) {
        this.likecount = likecount;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(String totalscore) {
        this.totalscore = totalscore;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public long getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(long progressBar) {
        this.progressBar = progressBar;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getTvDownLoadSize() {
        return tvDownLoadSize;
    }

    public void setTvDownLoadSize(long tvDownLoadSize) {
        this.tvDownLoadSize = tvDownLoadSize;
    }

    public String getsTy() {
        return sTy;
    }

    public void setsTy(String sTy) {
        this.sTy = sTy;
    }


    public String getFileSavePath() {
        return fileSavePath;
    }

    public void setFileSavePath(String fileSavePath) {
        this.fileSavePath = fileSavePath;
    }

    public boolean isAutoResume() {
        return autoResume;
    }

    public void setAutoResume(boolean autoResume) {
        this.autoResume = autoResume;
    }

    public boolean isAutoRename() {
        return autoRename;
    }

    public void setAutoRename(boolean autoRename) {
        this.autoRename = autoRename;
    }

    @Override
    public String toString() {
        return "SSLlist [id=" + id + ", softwareId=" + softwareId
                + ", softwareVendorId=" + softwareVendorId + ", sPN=" + sPN
                + ", sV=" + sV + ", sN=" + sN + ", sDC=" + sDC + ", sP=" + sP
                + ", sI=" + sI + ", sIP=" + sIP + ", sS=" + sS + ", sCom="
                + sCom + ", softwarescore=" + softwarescore + ", commentcount="
                + commentcount + ", likecount=" + likecount + ", recommend="
                + recommend + ", totalscore=" + totalscore + ", installTime="
                + installTime + ", imgs=" + imgs + ", progressBar="
                + progressBar + ", state=" + state + ", tvDownLoadSize="
                + tvDownLoadSize + ", sTy=" + sTy
                + ", fileSavePath=" + fileSavePath + ", autoResume="
                + autoResume + ", autoRename=" + autoRename + "]";
    }

}