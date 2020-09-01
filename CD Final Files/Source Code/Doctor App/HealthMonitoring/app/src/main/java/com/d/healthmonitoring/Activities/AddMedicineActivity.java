package com.d.healthmonitoring.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.d.healthmonitoring.R;
import com.d.healthmonitoring.api_response.ApiClient;
import com.d.healthmonitoring.api_response.ApiInterface;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMedicineActivity extends AppCompatActivity {
Button save;
EditText medicinename,disease,symptom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        medicinename = findViewById(R.id.medicine_name);
        disease = findViewById(R.id.disease);
        symptom = findViewById(R.id.symptom);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (medicinename.getText().toString().isEmpty()) {
                    medicinename.setError("Enter Name");
                } else if (disease.getText().toString().isEmpty()) {
                    disease.setError("Enter disease");
                } else if (symptom.getText().toString().isEmpty()) {
                    symptom.setError("Enter symptom");
                } else {


     prepareMovieData();

                }

            }
        });
    }

    private void prepareMovieData() {

        
        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);


        /**
         GET List Resources
         **/

                Call<ResponseBody> call = apiInterface.insertMedicineData("Bearer "+getIntent().getStringExtra("token"),medicinename.getText().toString(), disease.getText().toString(), symptom.getText().toString(),getIntent().getStringExtra("did"),getIntent().getStringExtra("pid"),getIntent().getStringExtra("doctorname"));
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                       
                        if (response.isSuccessful()) {


                            finish();




                        } else {

                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                       
                        Toast.makeText(AddMedicineActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                        Log.e("jhjhj",t.getMessage());
                    }
                });



    }

    }


