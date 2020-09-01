package com.d.healthmonitoring.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.d.healthmonitoring.R;
import com.d.healthmonitoring.ui.SeeMedicinePrescriptions.SeeMedicineFragment;

public class SeeMedicineActivirty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_medicine_activirty);
    SeeMedicineFragment();
    }
    public void SeeMedicineFragment(){
        SeeMedicineFragment frag = new SeeMedicineFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment,frag,"Test Fragment");
        transaction.commit();

    }
}