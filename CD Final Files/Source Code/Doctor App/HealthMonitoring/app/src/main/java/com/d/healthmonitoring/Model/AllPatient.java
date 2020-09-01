
package com.d.healthmonitoring.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllPatient {

    @SerializedName("response")
    @Expose
    private List<PatientData> result = null;

    public List<PatientData> getResult() {
        return result;
    }

    public void setResult(List<PatientData> result) {
        this.result = result;
    }

}
