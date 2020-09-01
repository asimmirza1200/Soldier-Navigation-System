package com.f.healthmonitoring.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GPS {

    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("hash")
    @Expose
    private String hash;
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTime() {
        return time;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
