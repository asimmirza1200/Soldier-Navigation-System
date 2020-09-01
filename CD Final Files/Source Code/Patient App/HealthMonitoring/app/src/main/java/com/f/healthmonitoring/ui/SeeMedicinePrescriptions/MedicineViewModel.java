package com.f.healthmonitoring.ui.SeeMedicinePrescriptions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MedicineViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MedicineViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Doctor fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}