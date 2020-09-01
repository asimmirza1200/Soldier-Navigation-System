package com.f.healthmonitoring.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BPM {

    @SerializedName("BPM")
    @Expose
    private String bPM;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("hash")
    @Expose
    private String hash;
    public String getBPM() {
        return bPM;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setBPM(String bPM) {
        this.bPM = bPM;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}