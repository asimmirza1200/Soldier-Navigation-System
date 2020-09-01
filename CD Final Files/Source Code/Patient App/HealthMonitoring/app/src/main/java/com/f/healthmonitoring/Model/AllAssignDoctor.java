
package com.f.healthmonitoring.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllAssignDoctor {

    @SerializedName("result")
    @Expose
    private List<AssignData> result = null;

    public List<AssignData> getResult() {
        return result;
    }

    public void setResult(List<AssignData> result) {
        this.result = result;
    }

}
