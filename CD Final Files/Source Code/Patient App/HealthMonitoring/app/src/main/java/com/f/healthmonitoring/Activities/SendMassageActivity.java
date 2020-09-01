package com.f.healthmonitoring.Activities;

import androidx.appcompat.app.AppCompatActivity;
import at.markushi.ui.CircleButton;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.f.healthmonitoring.R;

public class SendMassageActivity extends AppCompatActivity {
EditText Massage;
CircleButton  Send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
Send= (CircleButton) findViewById(R.id.send);
    }
}
