
package com.f.healthmonitoring.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DoctorData implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("doctorname")
    @Expose
    private String doctorname;
    @SerializedName("fathername")
    @Expose
    private String fathername;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("qualification")
    @Expose
    private String qualification;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("firbaseToken")
    @Expose
    private String firbaseToken;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getFirbaseToken() {
        return firbaseToken;
    }

    public void setFirbaseToken(String firbaseToken) {
        this.firbaseToken = firbaseToken;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
