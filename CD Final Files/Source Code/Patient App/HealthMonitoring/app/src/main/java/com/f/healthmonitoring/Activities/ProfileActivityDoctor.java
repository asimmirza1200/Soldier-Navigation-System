package com.f.healthmonitoring.Activities;

import android.os.Bundle;
import android.widget.TextView;

import com.f.healthmonitoring.Model.AssignData;
import com.f.healthmonitoring.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivityDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile_doctor);
       AssignData assignData= (AssignData) getIntent().getSerializableExtra("Doctor");
      TextView name= findViewById(R.id.name);
        TextView Fathername= findViewById(R.id.fname);
        TextView Address= findViewById(R.id.address);
        TextView Specialization= findViewById(R.id.phone);
        TextView Phonenumber= findViewById(R.id.sep);
        TextView Date= findViewById(R.id.date);
        TextView Qualification= findViewById(R.id.qual);

        name.setText(assignData.getDoctorData().getDoctorname());
        Fathername.setText(assignData.getDoctorData().getFathername());
        Address.setText(assignData.getDoctorData().getAddress());
        Specialization.setText(assignData.getDoctorData().getSpecialization());
        Phonenumber.setText(assignData.getDoctorData().getPhonenumber());
        Date.setText(assignData.getDoctorData().getCreatedAt());
        Qualification.setText(assignData.getDoctorData().getQualification());


    }
}
