package com.d.healthmonitoring.api_response;

import com.d.healthmonitoring.Model.AllAssignPatient;
import com.d.healthmonitoring.Model.AllMedicineList;
import com.d.healthmonitoring.Model.AllPatient;
import com.d.healthmonitoring.Model.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {


    @FormUrlEncoded
    @POST("loginDoctor")
    Call<LoginResponse> login(@Field("token") String token,@Field("phonenumber") String phonenumber, @Field("password") String password);
    @FormUrlEncoded
    @POST("insertMedicineData")
    Call<ResponseBody> insertMedicineData(@Header("Authorization")String token, @Field("medicine") String medicine, @Field("disease") String disease, @Field("symptom") String symptom, @Field("doctor_id") String doctor_id, @Field("patient_id") String patient_id, @Field("doctorname") String doctorname);

    @FormUrlEncoded
    @POST("assignDoctor")
    Call<ResponseBody> assignDoctor(@Header("Authorization")String token, @Field("doctor_id") String doctor_id, @Field("patient_id") String patient_id);

    @FormUrlEncoded
    @POST("getAssignPatient")
    Call<AllAssignPatient> getAssignPatient(@Header("Authorization")String token, @Field("doctor_id") String doctor_id);

    @GET("getAllPatient")
    Call<AllPatient> getAllPatient(@Header("Authorization")String token);

    @FormUrlEncoded
    @POST("getAssignMedicineData")
    Call<AllMedicineList> getAssignMedicineData(@Header("Authorization")String token, @Field("patient_id") String patient_id);
}
