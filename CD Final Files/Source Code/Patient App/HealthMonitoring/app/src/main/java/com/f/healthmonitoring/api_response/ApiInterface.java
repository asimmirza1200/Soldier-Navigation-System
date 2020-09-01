package com.f.healthmonitoring.api_response;

import com.f.healthmonitoring.Model.AllAssignDoctor;
import com.f.healthmonitoring.Model.AllMedicineList;
import com.f.healthmonitoring.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {


    @FormUrlEncoded
    @POST("loginPatient")
    Call<LoginResponse> login(@Field("token") String token,@Field("phonenumber") String phonenumber, @Field("password") String password);

    @FormUrlEncoded
    @POST("getAssignDoctor")
    Call<AllAssignDoctor> getAssignDoctor(@Header("Authorization")String token,@Field("patient_id") String patient_id);


    @FormUrlEncoded
    @POST("getAssignMedicineData")
    Call<AllMedicineList> getAssignMedicineData(@Header("Authorization")String token, @Field("patient_id") String patient_id);
}
