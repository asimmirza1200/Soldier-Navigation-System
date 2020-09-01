package com.f.healthmonitoring.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.f.healthmonitoring.Model.LoginResponse;
import com.f.healthmonitoring.R;
import com.f.healthmonitoring.api_response.ApiClient;
import com.f.healthmonitoring.api_response.ApiInterface;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText phone, pass;
    Button signin;
    private TextView signup;
    ImageView top_curve;
    TextView email_text, password_text, login_title;
    ImageView logo;
    LinearLayout new_user_layout;
    CardView login_card;
    ProgressBar progressBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        signin = findViewById(R.id.login_button);
        top_curve = findViewById(R.id.top_curve);
        phone = findViewById(R.id.email);
//        email_text = findViewById(R.id.email_text);
        pass = findViewById(R.id.password);
//        password_text = findViewById(R.id.password_text);
        logo = findViewById(R.id.logo);
//        login_title = findViewById(R.id.login_text);
//        new_user_layout = findViewById(R.id.new_user_text);
        login_card = findViewById(R.id.login_card);
        progressBar =findViewById(R.id.progress_circular);


        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_down);
        top_curve.startAnimation(top_curve_anim);

        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.edittext_anim);
        phone.startAnimation(editText_anim);
        pass.startAnimation(editText_anim);

        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.field_name_anim);
//        email_text.startAnimation(field_name_anim);
//        password_text.startAnimation(field_name_anim);
        logo.startAnimation(field_name_anim);
//        login_title.startAnimation(field_name_anim);

        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);

        Animation new_user_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_top);
//        new_user_layout.startAnimation(new_user_anim);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (phone.getText().toString().isEmpty()) {
                    phone.setError("Please Enter phone");
                } else if (pass.getText().toString().isEmpty()) {
                    pass.setError("Please Enter password");

                }
              else
                {

                    prepareMovieData();
                }
            }

        });
    }
        private void prepareMovieData() {

            pass.setEnabled(false);
            phone.setEnabled(false);
            signin.setEnabled(false);
            final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

            progressBar.setVisibility(View.VISIBLE);

            /**
             GET List Resources
             **/
            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
                @Override
                public void onSuccess(InstanceIdResult instanceIdResult) {
                    Call<LoginResponse> call = apiInterface.login(instanceIdResult.getToken(),phone.getText().toString(), pass.getText().toString());
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            progressBar.setVisibility(View.INVISIBLE);
                            pass.setEnabled(true);
                            phone.setEnabled(true);
                            signin.setEnabled(true);
                            if (Boolean.parseBoolean(response.body().getStatus())) {

                                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                                SharedPreferences.Editor prefs = getSharedPreferences("login", MODE_PRIVATE).edit();
                                prefs.putString("Token", response.body().getData().getAccessToken());//"No name defined" is the default value.
                                prefs.putString("Name", response.body().getData().getPatientname());//"No name defined" is the default value.
                                prefs.putString("Fname", response.body().getData().getFathername());//"No name defined" is the default value.
                                prefs.putString("Address", response.body().getData().getAddress());//"No name defined" is the default value.
                                prefs.putString("phone", response.body().getData().getPhonenumber());//"No name defined" is the default value.
                                prefs.putString("Disease", response.body().getData().getDisease());//"No name defined" is the default value.
                                prefs.putString("Deviceid", response.body().getData().getDeviceid());//"No name defined" is the default value.
                                prefs.putString("Date", response.body().getData().getCreatedAt());//"No name defined" is the default value.
                                prefs.putString("id", response.body().getData().getId());//"No name defined" is the default value

                                prefs.apply();
                                LoginActivity.this.startActivity(mainIntent);
                                LoginActivity.this.finish();
                                Toast.makeText(LoginActivity.this,response.body().getMessage() , Toast.LENGTH_SHORT).show();




                            } else {

                                Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            progressBar.setVisibility(View.INVISIBLE);
                            pass.setEnabled(true);
                            phone.setEnabled(true);
                            signin.setEnabled(true);
                            Toast.makeText(LoginActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                            Log.e("jhjhj",t.getMessage());
                        }
                    });

                }
            });
}
    }

