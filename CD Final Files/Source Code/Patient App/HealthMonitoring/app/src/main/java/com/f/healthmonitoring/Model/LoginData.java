
package com.f.healthmonitoring.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("patientname")
    @Expose
    private String patientname;
    @SerializedName("fathername")
    @Expose
    private String fathername;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("deviceid")
    @Expose
    private String deviceid;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("disease")
    @Expose
    private String disease;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("firbaseToken")
    @Expose
    private String firbaseToken;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public String getFirbaseToken() {
        return firbaseToken;
    }

    public void setFirbaseToken(String firbaseToken) {
        this.firbaseToken = firbaseToken;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
