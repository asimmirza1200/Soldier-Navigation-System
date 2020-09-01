package com.f.healthmonitoring.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ECG {

    @SerializedName("ecg")
    @Expose
    private String ecg;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("hash")
    @Expose
    private String hash;
    public String getEcg() {
        return ecg;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setEcg(String ecg) {
        this.ecg = ecg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}