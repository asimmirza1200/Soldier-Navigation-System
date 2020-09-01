package com.d.healthmonitoring.ui.addpatient;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllPatientViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AllPatientViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Doctor fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}