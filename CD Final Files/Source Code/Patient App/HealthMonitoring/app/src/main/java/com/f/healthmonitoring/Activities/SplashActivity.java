package com.f.healthmonitoring.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.f.healthmonitoring.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ImageView imageView1=findViewById(R.id.img);
        //animation
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView1.startAnimation(animation);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
                if(prefs.getString("Token",null)!=null){
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                }else {
                    Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                }


            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}

