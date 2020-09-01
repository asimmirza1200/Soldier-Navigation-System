package com.f.healthmonitoring.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DHT {

    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("temp")
    @Expose
    private Double temp;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("hash")
    @Expose
    private String hash;
    public Double getHumidity() {
        return humidity;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}