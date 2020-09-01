
package com.f.healthmonitoring.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AssignData implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("DoctorData")
    @Expose
    private DoctorData doctorData;
    @SerializedName("PatientData")
    @Expose
    private PatientData patientData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DoctorData getDoctorData() {
        return doctorData;
    }

    public void setDoctorData(DoctorData doctorData) {
        this.doctorData = doctorData;
    }

    public PatientData getPatientData() {
        return patientData;
    }

    public void setPatientData(PatientData patientData) {
        this.patientData = patientData;
    }

}
