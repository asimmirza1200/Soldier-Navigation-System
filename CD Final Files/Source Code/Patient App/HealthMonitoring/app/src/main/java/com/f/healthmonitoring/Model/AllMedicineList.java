
package com.f.healthmonitoring.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllMedicineList {

    @SerializedName("response")
    @Expose
    private List<Medicine> response = null;

    public List<Medicine> getResponse() {
        return response;
    }

    public void setResponse(List<Medicine> response) {
        this.response = response;
    }

}
